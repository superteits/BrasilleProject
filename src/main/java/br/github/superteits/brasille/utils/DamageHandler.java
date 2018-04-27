package br.github.superteits.brasille.utils;

import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DamageHandler {
	
	public static double getDamageFromLore(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		if(!meta.getLore().equals(null)) {
			List<String> lore = meta.getLore();
			for(String line : lore) {
				if(line.contains("Dano")) {
					String[] splitletters = line.split(":", 2);
					String dano = splitletters[1].replace(" ", "");
					return Double.valueOf(dano);
				}
			}
		}
		return 0;
	}

}
