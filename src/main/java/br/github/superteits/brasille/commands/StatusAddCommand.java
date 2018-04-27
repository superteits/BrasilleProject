package br.github.superteits.brasille.commands;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import br.teits.brasille.Brasille;
import br.teits.brasille.inventories.PlayerInfo;
import br.teits.brasille.mobs.PorcoDoTutorial;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_11_R1.AxisAlignedBB;

public class StatusAddCommand implements CommandExecutor{
	
	List<String> invs = new ArrayList<>();
	
	int i;

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player) {
			Player p = (Player) arg0;
			if(arg3[0].equals("info")) {
				PlayerInfo.openStatus(p);
			}
			if(arg3[0].equals("str")) {
				if(Brasille.pstatus.get(p).getFp() >= 1 && Integer.valueOf(arg3[1]) <= Brasille.pstatus.get(p).getFp()) {
					if(Brasille.pstatus.get(p).getStr() == 130) {
						p.sendMessage(ChatColor.RED + "Voc� j� adicionou o m�ximo de pontos desse atributo");
						if(p.getOpenInventory() != null) {
							p.closeInventory();
						}
					}
					else {
						Brasille.pstatus.get(p).addStr(Integer.valueOf(arg3[1]));
						Brasille.pstatus.get(p).removeFp(Integer.valueOf(arg3[1]));
						p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue() + Double.valueOf(arg3[1]));
						if(p.getOpenInventory().getTopInventory().getName().equals(ChatColor.BLACK + p.getDisplayName() + " Info")) {
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 0);
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 11);
						}
					}
				}
				else {
					p.sendMessage(ChatColor.RED + "Voc� n�o tem pontos suficientes!");
					if(p.getOpenInventory() != null) {
						p.closeInventory();
					}
				}
			}
			if(arg3[0].equals("vit")) {
				if(Brasille.pstatus.get(p).getFp() >= 1 && Integer.valueOf(arg3[1]) <= Brasille.pstatus.get(p).getFp()) {
					if(Brasille.pstatus.get(p).getVit() == 130) {
						p.sendMessage(ChatColor.RED + "Voc� j� adicionou o m�ximo de pontos desse atributo");
						if(p.getOpenInventory() != null) {
							p.closeInventory();
						}
					}
					else {
						Brasille.pstatus.get(p).addVit(Integer.valueOf(arg3[1]));
						Brasille.pstatus.get(p).removeFp(Integer.valueOf(arg3[1]));
						p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + (Double.valueOf(arg3[1]) * 5));
						p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).getValue() + (Double.valueOf(arg3[1]) * 0.003846));
						if(p.getOpenInventory().getTopInventory().getName().equals(ChatColor.BLACK + p.getDisplayName() + " Info")) {
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 0);
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 12);
						}
					}
				}
				else {
					p.sendMessage(ChatColor.RED + "Voc� n�o tem pontos suficientes!");
					if(p.getOpenInventory() != null) {
						p.closeInventory();
					}
				}
			}
			if(arg3[0].equals("dex")) {
				if(Brasille.pstatus.get(p).getFp() >= 1 && Integer.valueOf(arg3[1]) <= Brasille.pstatus.get(p).getFp()) {
					if(Brasille.pstatus.get(p).getDex() == 130) {
						p.sendMessage(ChatColor.RED + "Voc� j� adicionou o m�ximo de pontos desse atributo");
						if(p.getOpenInventory() != null) {
							p.closeInventory();
						}
					}
					else {
						Brasille.pstatus.get(p).addDex(Integer.valueOf(arg3[1]));
						Brasille.pstatus.get(p).removeFp(Integer.valueOf(arg3[1]));
						Brasille.pstatus.get(p).addCritChance(Integer.valueOf(arg3[1]) * 0.1538);
						if(p.getOpenInventory().getTopInventory().getName().equals(ChatColor.BLACK + p.getDisplayName() + " Info")) {
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 0);
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 13);
						}
					}
				}
				else {
					p.sendMessage(ChatColor.RED + "Voc� n�o tem pontos suficientes!");
					if(p.getOpenInventory() != null) {
						p.closeInventory();
					}
				}
			}
			if(arg3[0].equals("agi")) {
				if(Brasille.pstatus.get(p).getFp() >= 1 && Integer.valueOf(arg3[1]) <= Brasille.pstatus.get(p).getFp()) {
					if(Brasille.pstatus.get(p).getAgi() == 130) {
						p.sendMessage(ChatColor.RED + "Voc� j� adicionou o m�ximo de pontos desse atributo");
						if(p.getOpenInventory() != null) {
							p.closeInventory();
						}
					}
					else {
						Brasille.pstatus.get(p).addAgi(Integer.valueOf(arg3[1]));
						Brasille.pstatus.get(p).removeFp(Integer.valueOf(arg3[1]));
						p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue() + (Integer.valueOf(arg3[1]) * 0.0692));
						Brasille.pstatus.get(p).addFlee(Integer.valueOf(arg3[1]) * 0.1923);
						if(p.getOpenInventory().getTopInventory().getName().equals(ChatColor.BLACK + p.getDisplayName() + " Info")) {
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 0);
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 14);
						}
					}
				}
				else {
					p.sendMessage(ChatColor.RED + "Voc� n�o tem pontos suficientes!");
					if(p.getOpenInventory() != null) {
						p.closeInventory();
					}
				}
			}
			if(arg3[0].equals("int")) {
				if(Brasille.pstatus.get(p).getFp() >= 1 && Integer.valueOf(arg3[1]) <= Brasille.pstatus.get(p).getFp()) {
					if(Brasille.pstatus.get(p).getInte() == 130) {
						p.sendMessage(ChatColor.RED + "Voc� j� adicionou o m�ximo de pontos desse atributo");
						if(p.getOpenInventory() != null) {
							p.closeInventory();
						}
					}
					else {
						Brasille.pstatus.get(p).addInte(Integer.valueOf(arg3[1]));
						Brasille.pstatus.get(p).removeFp(Integer.valueOf(arg3[1]));
						if(p.getOpenInventory().getTopInventory().getName().equals(ChatColor.BLACK + p.getDisplayName() + " Info")) {
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 0);
							PlayerInfo.updateItem(p.getOpenInventory().getTopInventory(), p, 15);
						}
					}
				}
				else {
					p.sendMessage(ChatColor.RED + "Voc� n�o tem pontos suficientes!");
					if(p.getOpenInventory() != null) {
						p.closeInventory();
					}
				}
			}
			if(arg3[0].equals("spawn")) {
				PorcoDoTutorial pig = new PorcoDoTutorial(((CraftWorld)p.getWorld()).getHandle());
				pig.setPosition(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
				pig.a(pig.getBoundingBox().grow(0.0D, 2.0D, 0.0D));
				((CraftWorld)p.getWorld()).getHandle().addEntity(pig, SpawnReason.CUSTOM);
				pig.a(pig.getBoundingBox().grow(0.0D, 2.0D, 0.0D));
			}
			if(arg3[0].equals("adm")) {
				if(arg3[1].equals("str")) {
					Brasille.pstatus.get(p).addStr(999);
					p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(999.0D);
				}
				if(arg3[1].equals("vit")) {
					Brasille.pstatus.get(p).addVit(999);
					p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(999.0D);
					p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(999.0D);
				}
				if(arg3[1].equals("agi")) {
					Brasille.pstatus.get(p).addAgi(999);
					p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(999.0D);
					p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(999.0D);
					Brasille.pstatus.get(p).addFlee(999.0D);
				}
				if(arg3[1].equals("int")) {
					Brasille.pstatus.get(p).addInte(999);
				}
				if(arg3[1].equals("dex")) {
					Brasille.pstatus.get(p).addDex(999);
					Brasille.pstatus.get(p).addCritChance(999);
				}
			}
			if(arg3[0].equals("oie")) {
				i++;
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(String.valueOf(i)));
			}
			if(arg3[0].equals("xp")) {
				p.sendMessage(String.valueOf(p.getExp()));
				p.sendMessage(String.valueOf(p.getLevel()));
				p.setExp(0.51F);
			}
			if(arg3[0].equals("inv")) {
				if(arg3[1].equals("save")) {
					try {
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						BukkitObjectOutputStream boos = new BukkitObjectOutputStream(baos);
						
						boos.writeInt(p.getInventory().getContents().length);
						
						for(ItemStack item : p.getInventory().getContents()) {
							boos.writeObject(item);
						}
						
						boos.close();
						invs.add(Base64Coder.encodeLines(baos.toByteArray()));
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(arg3[1].equals("load")) {
					try {
						ByteArrayInputStream bais = new ByteArrayInputStream(Base64Coder.decodeLines(invs.get(0)));
						BukkitObjectInputStream bois = new BukkitObjectInputStream(bais);
						ItemStack[] items = new ItemStack[bois.readInt()];
						
						for(int i = 0; i < items.length; i++) {
							items[i] = (ItemStack) bois.readObject();
						}
						
						bois.close();
						p.getInventory().setContents(items);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				if(arg3[1].equals("print")) {
					System.out.println(invs.get(0));
				}
			}
				
		}
		return true;
	}
}
