package br.github.superteits.brasille.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.base.CharMatcher;

public class DurabilityHandler {
	
	public static void removeDurability(ItemStack item, int quantity) {
		ItemMeta meta = item.getItemMeta();
		if(meta.getLore()!= null) {
			List<String> lore = meta.getLore();
			for(String line : lore) {
				if(line.contains("Durabilidade")) {
					String[] splitletters = line.split(":", 2);
					String[] splitnumbers = splitletters[1].split("/", 2);
					int d = Integer.valueOf(CharMatcher.DIGIT.retainFrom(splitnumbers[0]));
					int d2 = d - quantity;
					if(d2 < 0) {
						d2 = 0;
						lore.remove(line);
						line = splitletters[0] + ": " + d2 + "/" + splitnumbers[1];
						lore.add(line);
						meta.setLore(lore);
						item.setItemMeta(meta);
					}
					else{
						lore.remove(line);
						line = splitletters[0] + ": " + d2 + "/" + splitnumbers[1];
						lore.add(line);
						meta.setLore(lore);
						item.setItemMeta(meta);
					}
					break;
				}
			}
		}
	}
	
	public static int checkDurability(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<>();
		lore = meta.getLore();
		for(String line : lore) {
			if(line.contains("Durabilidade")) {
				String[] splitletters = line.split(":", 2);
				String[] splitnumbers = splitletters[1].split("/", 2);
				int d = Integer.valueOf(CharMatcher.DIGIT.retainFrom(splitnumbers[0]));
				return d;
			}
		}
		return -1;
	}
	
	public static List<String> repairDurability(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<>();
		lore = meta.getLore();
		for(String line : lore) {
			if(line.contains("Durabilidade")) {
				String[] split = line.split("/", 2);
				int s = Integer.valueOf(CharMatcher.DIGIT.retainFrom(split[0]));
				int s2 = Integer.valueOf(CharMatcher.DIGIT.retainFrom(split[1]));
				split[0].replaceAll(String.valueOf(s), String.valueOf(s2));
				line = "";
				line = split[0] + "/" + split[1];
				break;
			}
		}
		return lore;
		
	}
}
