package br.github.superteits.brasille.inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import br.teits.brasille.Brasille;

public class PlayerInfo {
	
	public static void openStatus(Player player) {
		
		//lore dos itens
		List<String> loreStr = new ArrayList<>();
		loreStr.add(ChatColor.GRAY + "Aumenta o dano com armas corpo a corpo");
		loreStr.add(ChatColor.GRAY + "Clique para adicionar pontos em For�a");
		loreStr.add("");
		loreStr.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getStr());
		
		List<String> loreVit = new ArrayList<>();
		loreVit.add(ChatColor.GRAY + "Aumenta a vida m�xima e a resist�ncia a empurr�o");
		loreVit.add(ChatColor.GRAY + "Clique para adicionar pontos em Vitalidade");
		loreVit.add("");
		loreVit.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getVit());
		
		List<String> loreDex = new ArrayList<>();
		loreDex.add(ChatColor.GRAY + "Aumenta o dano com arcos e a chance de cr�tico");
		loreDex.add(ChatColor.GRAY + "Clique para adicionar pontos em Destreza");
		loreDex.add("");
		loreDex.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getDex());
		
		List<String> loreAgi = new ArrayList<>();
		loreAgi.add(ChatColor.GRAY + "Aumenta a velocidade de ataque e a chance de esquiva");
		loreAgi.add(ChatColor.GRAY + "Clique para adicionar pontos em Agilidade");
		loreAgi.add("");
		loreAgi.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getAgi());
		
		List<String> loreInte = new ArrayList<>();
		loreInte.add(ChatColor.GRAY + "Aumenta o seu dano com po��es");
		loreInte.add(ChatColor.GRAY + "Clique para adicionar pontos em Intelig�ncia");
		loreInte.add("");
		loreInte.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getInte());
		
		List<String> lorePlayer = new ArrayList<>();
		lorePlayer.add(ChatColor.GRAY + "Dano base (melee): " + ChatColor.WHITE + player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue());//ChatColor.WHITE + Brasille.pstatus.get(player).getStr());
		lorePlayer.add(ChatColor.GRAY + "Dano adicional com arco: " + ChatColor.WHITE + (Brasille.pstatus.get(player).getDex() / 2));
		lorePlayer.add(ChatColor.GRAY + "Vida base: " + ChatColor.WHITE + player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		lorePlayer.add(ChatColor.GRAY + "Resist�ncia a empurr�o: " + ChatColor.WHITE + player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).getValue() * 100 + "%");
		lorePlayer.add(ChatColor.GRAY + "Velocidade de movimento: " + ChatColor.WHITE + player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue());
		lorePlayer.add(ChatColor.GRAY + "Chance de esquiva: " + ChatColor.WHITE + Brasille.pstatus.get(player).getFlee());
		lorePlayer.add(ChatColor.GRAY + "Chance de cr�tico: " + ChatColor.WHITE + Brasille.pstatus.get(player).getCritChance() + "%");
		lorePlayer.add(ChatColor.GRAY + "Pontos dispon�veis: " + ChatColor.WHITE + Brasille.pstatus.get(player).getFp());
		
		//criando invent�rio
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BLACK + player.getDisplayName() + " Info");
		//criando os itens
		ItemStack statusStr = new ItemStack(Material.PAPER);
		ItemStack statusVit = new ItemStack(Material.PAPER);
		ItemStack statusDex = new ItemStack(Material.PAPER);
		ItemStack statusAgi = new ItemStack(Material.PAPER);
		ItemStack statusInte = new ItemStack(Material.PAPER);
		ItemStack statusPlayer = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		//gettando os itemmetas
		ItemMeta statusStrMeta =  statusStr.getItemMeta();
		ItemMeta statusVitMeta =  statusVit.getItemMeta();
		ItemMeta statusDexMeta =  statusDex.getItemMeta();
		ItemMeta statusAgiMeta =  statusAgi.getItemMeta();
		ItemMeta statusInteMeta =  statusInte.getItemMeta();
		SkullMeta statusPlayerMeta = (SkullMeta) statusPlayer.getItemMeta();
		//setando os itemmetas
		statusStrMeta.setDisplayName(ChatColor.RED + "For�a");
		statusStrMeta.setLore(loreStr);
		
		statusVitMeta.setDisplayName(ChatColor.GREEN + "Vitalidade");
		statusVitMeta.setLore(loreVit);
		
		statusDexMeta.setDisplayName(ChatColor.BLUE + "Destreza");
		statusDexMeta.setLore(loreDex);
		
		statusAgiMeta.setDisplayName(ChatColor.WHITE + "Agilidade");
		statusAgiMeta.setLore(loreAgi);
		
		statusInteMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Intelig�ncia");
		statusInteMeta.setLore(loreInte);
		
		statusPlayerMeta.setOwner(player.getName());
		statusPlayerMeta.setDisplayName(ChatColor.GOLD + player.getDisplayName());
		statusPlayerMeta.setLore(lorePlayer);
		//atribuindo os itemmetas aos itemstacks
		statusStr.setItemMeta(statusStrMeta);
		statusVit.setItemMeta(statusVitMeta);
		statusDex.setItemMeta(statusDexMeta);
		statusAgi.setItemMeta(statusAgiMeta);
		statusInte.setItemMeta(statusInteMeta);
		statusPlayer.setItemMeta(statusPlayerMeta);
		//adicionando os itemstacks ao invent�rio
		inv.setItem(0, statusPlayer);
		inv.setItem(11, statusStr);
		inv.setItem(12, statusVit);
		inv.setItem(13, statusDex);
		inv.setItem(14, statusAgi);
		inv.setItem(15, statusInte);
		player.openInventory(inv);
	}
	
	public static void updateItem(Inventory inv, Player player, int index) {
		if(inv.getItem(index).getItemMeta().getDisplayName().equals(ChatColor.GOLD + player.getName())) {
			
			List<String> lorePlayer = new ArrayList<>();
			lorePlayer.add(ChatColor.GRAY + "Dano base (melee): " + ChatColor.WHITE + player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue());
			lorePlayer.add(ChatColor.GRAY + "Dano adicional com arco: " + ChatColor.WHITE + (Brasille.pstatus.get(player).getDex() / 2));
			lorePlayer.add(ChatColor.GRAY + "Dano adicional com po��es: " + ChatColor.WHITE + (Brasille.pstatus.get(player).getInte() / 2));
			lorePlayer.add(ChatColor.GRAY + "Vida base: " + ChatColor.WHITE + player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
			lorePlayer.add(ChatColor.GRAY + "Resist�ncia a empurr�o: " + ChatColor.WHITE + player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).getValue() * 100 + "%");
			lorePlayer.add(ChatColor.GRAY + "Velocidade de ataque: " + ChatColor.WHITE + player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue());
			lorePlayer.add(ChatColor.GRAY + "Chance de esquiva: " + ChatColor.WHITE + Brasille.pstatus.get(player).getFlee());
			lorePlayer.add(ChatColor.GRAY + "Chance de cr�tico: " + ChatColor.WHITE + Brasille.pstatus.get(player).getCritChance() + "%");
			lorePlayer.add(ChatColor.GRAY + "Pontos dispon�veis: " + ChatColor.WHITE + Brasille.pstatus.get(player).getFp());
			
			ItemStack statusPlayer = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
			
			SkullMeta statusPlayerMeta = (SkullMeta) statusPlayer.getItemMeta();
			
			statusPlayerMeta.setOwner(player.getName());
			statusPlayerMeta.setDisplayName(ChatColor.GOLD + player.getDisplayName());
			statusPlayerMeta.setLore(lorePlayer);
			
			statusPlayer.setItemMeta(statusPlayerMeta);
			
			inv.setItem(0, statusPlayer);
			
			
		}
		else if(inv.getItem(index).getItemMeta().getDisplayName().equals(ChatColor.RED + "For�a")) {
			
			List<String> loreStr = new ArrayList<>();
			loreStr.add(ChatColor.GRAY + "Aumenta o dano com armas corpo a corpo");
			loreStr.add(ChatColor.GRAY + "Clique para adicionar pontos em For�a");
			loreStr.add("");
			loreStr.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getStr());
			
			ItemStack statusStr = new ItemStack(Material.PAPER);
			
			ItemMeta statusStrMeta =  statusStr.getItemMeta();
			
			statusStrMeta.setDisplayName(ChatColor.RED + "For�a");
			statusStrMeta.setLore(loreStr);
			
			statusStr.setItemMeta(statusStrMeta);
			
			inv.setItem(11, statusStr);
		}
		else if(inv.getItem(index).getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Vitalidade")) {
			
			List<String> loreVit = new ArrayList<>();
			loreVit.add(ChatColor.GRAY + "Aumenta a vida m�xima e a resist�ncia a empurr�o");
			loreVit.add(ChatColor.GRAY + "Clique para adicionar pontos em Vitalidade");
			loreVit.add("");
			loreVit.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getVit());
			
			ItemStack statusVit = new ItemStack(Material.PAPER);
			
			ItemMeta statusVitMeta =  statusVit.getItemMeta();
			
			statusVitMeta.setDisplayName(ChatColor.GREEN + "Vitalidade");
			statusVitMeta.setLore(loreVit);
			
			statusVit.setItemMeta(statusVitMeta);
			
			inv.setItem(12, statusVit);
		}
		else if(inv.getItem(index).getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Destreza")) {
			
			List<String> loreDex = new ArrayList<>();
			loreDex.add(ChatColor.GRAY + "Aumenta o dano com arcos e a chance de cr�tico");
			loreDex.add(ChatColor.GRAY + "Clique para adicionar pontos em Destreza");
			loreDex.add("");
			loreDex.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getDex());
			
			ItemStack statusDex = new ItemStack(Material.PAPER);
			
			ItemMeta statusDexMeta =  statusDex.getItemMeta();
			
			statusDexMeta.setDisplayName(ChatColor.BLUE + "Destreza");
			statusDexMeta.setLore(loreDex);
			
			statusDex.setItemMeta(statusDexMeta);
			
			inv.setItem(13, statusDex);
		}
		else if(inv.getItem(index).getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Agilidade")) {
			
			List<String> loreAgi = new ArrayList<>();
			loreAgi.add(ChatColor.GRAY + "Aumenta a velocidade de ataque e a chance de esquiva");
			loreAgi.add(ChatColor.GRAY + "Clique para adicionar pontos em Agilidade");
			loreAgi.add("");
			loreAgi.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getAgi());
			
			ItemStack statusAgi = new ItemStack(Material.PAPER);
			
			ItemMeta statusAgiMeta =  statusAgi.getItemMeta();
			
			statusAgiMeta.setDisplayName(ChatColor.WHITE + "Agilidade");
			statusAgiMeta.setLore(loreAgi);
			
			statusAgi.setItemMeta(statusAgiMeta);
			
			inv.setItem(14, statusAgi);
		}
		else if(inv.getItem(index).getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Intelig�ncia")) {
			
			List<String> loreInte = new ArrayList<>();
			loreInte.add(ChatColor.GRAY + "Aumenta o seu dano com po��es");
			loreInte.add(ChatColor.GRAY + "Clique para adicionar pontos em Intelig�ncia");
			loreInte.add("");
			loreInte.add(ChatColor.GRAY + "Pontos adicionados: " + ChatColor.WHITE + Brasille.pstatus.get(player).getInte());
			
			ItemStack statusInte = new ItemStack(Material.PAPER);
			
			ItemMeta statusInteMeta =  statusInte.getItemMeta();
			
			statusInteMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Intelig�ncia");
			statusInteMeta.setLore(loreInte);
			
			statusInte.setItemMeta(statusInteMeta);
			
			inv.setItem(15, statusInte);
		}
	}

}
