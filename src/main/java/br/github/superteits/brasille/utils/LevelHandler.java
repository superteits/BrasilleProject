package br.github.superteits.brasille.utils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import br.teits.brasille.Brasille;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class LevelHandler {
	//testar
	public static void rewardExp(Player player, Entity mob) {
		Brasille.pstatus.get(player).addTotalExp(getExpFromMob(mob));
		if(!isMaxLevel(player)) {
			Brasille.pstatus.get(player).addCurrentExp(getExpFromMob(mob));
			if(Brasille.pstatus.get(player).getCurrentExp() >= ExpTable.matchLevel(player).getXpToNextLvl()) {
				Brasille.pstatus.get(player).setCurrentExp(Brasille.pstatus.get(player).getCurrentExp() - 
						ExpTable.matchLevel(player).getXpToNextLvl());
				player.setLevel(player.getLevel() + 1);
				if(Brasille.pstatus.get(player).getCurrentExp() >= ExpTable.matchLevel(player).getXpToNextLvl()) {
					Brasille.pstatus.get(player).setCurrentExp(ExpTable.matchLevel(player).getXpToNextLvl() - 1);
				}
			}
			player.setExp(Float.valueOf(ExpParser.formatXp(
					((float)Brasille.pstatus.get(player).getCurrentExp() / 
							(float)ExpTable.matchLevel(player).getXpToNextLvl()))));
			TextComponent message = new TextComponent(ChatColor.GREEN + 
					"Exp: " + String.valueOf(Brasille.pstatus.get(player).getCurrentExp()) + 
					"/" + String.valueOf(ExpTable.matchLevel(player).getXpToNextLvl()));
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, message);
		}
		else {
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
					TextComponent.fromLegacyText(ChatColor.GREEN +
							String.valueOf(Brasille.pstatus.get(player).getTotalExp())));
		}
	}
	
	public static boolean isMaxLevel(Player player) {
		if(player.getLevel() >= 50)
			return true;
		else 
			return false;
	}
	
	public static void xpPenalty(Player player) {
		if(!isMaxLevel(player)) {
			if(Brasille.pstatus.get(player).getCurrentExp() == 0) {
				return;
			}
			else {
				Brasille.pstatus.get(player).setCurrentExp(Brasille.pstatus.get(player).getCurrentExp() - Math.round(ExpTable.matchLevel(player).getXpToNextLvl() * 0.1));
				if(Brasille.pstatus.get(player).getCurrentExp() < 0) {
					Brasille.pstatus.get(player).setCurrentExp(0);
				}
				player.setExp(Float.valueOf(ExpParser.formatXp(
						((float)Brasille.pstatus.get(player).getCurrentExp() / 
								(float)ExpTable.matchLevel(player).getXpToNextLvl()))));
			}
		}
		else {
			Brasille.pstatus.get(player).setTotalExp(Brasille.pstatus.get(player).getTotalExp() - 
					Math.round(ExpTable.Level49.getXpToNextLvl() * 0.1));
		}
	}
	
	public static int getExpFromMob(Entity mob) {
		for(String tag : mob.getScoreboardTags()) {
			System.out.print(tag);
			if(tag.contains("Exp:")) {
				String[] split = tag.split(":", 2);
				return Integer.valueOf(split[1]);
			}
		}
		return 0;
	}

}
