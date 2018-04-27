package br.github.superteits.brasille;

import java.security.SecureRandom;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import br.teits.brasille.commands.StatusAddCommand;
import br.teits.brasille.mobs.BrasilleMobs;
import br.teits.brasille.mobs.EnumBrasilleMobs;
import br.teits.brasille.mobs.JavaliDoTutorial;
import br.teits.brasille.mobs.PorcoDoTutorial;
import br.teits.brasille.mobs.Teste;
import br.teits.brasille.utils.ExpTable;
import br.teits.brasille.utils.LevelHandler;
import br.teits.brasille.utils.ReflectionHandler;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_11_R1.Entity;
import net.minecraft.server.v1_11_R1.EntityTypes;

public class Brasille extends JavaPlugin{
	
	public static Map<Player, Status> pstatus;
	public static SecureRandom random = new SecureRandom();
	public static ItemStack air;
	public static Connection con;
	public static NumberFormat formatarXp;
	
	@Override
	public void onEnable() {
		//registrando comandos
		this.getLogger().info("Registrando comandos");
		this.getCommand("status").setExecutor(new StatusAddCommand());
		
		//registrando listeners neutros
		this.getLogger().info("Registrando Listener neutros");
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		//registrando Mobs  IllegalAccessException InstantiationException
		this.getLogger().info("Registrando monstros");
		getServer().getPluginManager().registerEvents(new BrasilleMobs(), this);
		EnumBrasilleMobs.registerMobs();

		
		
		//Mapeando informa��es e abrindo conex�es
		this.getLogger().info("Mapeando informa��es e abrindo conex�es");
		pstatus = new HashMap<>();
		//con = ConnectionFactory.getConnection();
		
		//Instanciando depend�ncias
		this.getLogger().info("Instanciando depend�ncias");
		formatarXp = new DecimalFormat("0.00");
		
		//Agendando tarefas
		this.getLogger().info("Agendando tarefas");
		BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for(Player player : getServer().getOnlinePlayers()) {
                	if(player != null) {
                		if(!LevelHandler.isMaxLevel(player)) {
                			TextComponent message = new TextComponent(ChatColor.GREEN + 
                					"Exp: " + String.valueOf(Brasille.pstatus.get(player).getCurrentExp()) + 
                					"/" + String.valueOf(ExpTable.matchLevel(player).getXpToNextLvl()));
                			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, message);
                    	}
                    	else {
                    		TextComponent message = new TextComponent(ChatColor.GREEN + 
                					"Exp: " + String.valueOf(Brasille.pstatus.get(player).getTotalExp()));
                			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, message);
                    	}
                	}
                }
            }
        }, 100L, 40L);
	}

	@Override
	public void onDisable() {
		getServer().getScheduler().cancelTasks(this);
		/*try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}*/
	}
	
}
