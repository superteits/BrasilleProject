package br.github.superteits.brasille.items.weapons.swords;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.teits.brasille.items.BrasilleItems;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

public class EspadaDoAprendiz extends BrasilleItems{

	@Override
	public ItemStack createItem() {
		int dano = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		ItemStack espadaDoAprendiz = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta espadaDoAprendizMeta = espadaDoAprendiz.getItemMeta();
		
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.RED + "Dano: " + dano);
		lore.add("");
		lore.add(ChatColor.GRAY + "Durabilidade: 250/250");
		
		espadaDoAprendizMeta.setDisplayName(ChatColor.WHITE + "Espada do Aprendiz");
		espadaDoAprendizMeta.setLore(lore);
		espadaDoAprendizMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		espadaDoAprendizMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		espadaDoAprendiz.setItemMeta(espadaDoAprendizMeta);
		
		net.minecraft.server.v1_11_R1.ItemStack item = CraftItemStack.asNMSCopy(espadaDoAprendiz);
		
		NBTTagCompound tc = (item.hasTag() ? item.getTag() : new NBTTagCompound());
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		damage.set("Name", new NBTTagString("generic.attackDamage"));
		damage.set("Amount", new NBTTagInt(dano));
		damage.set("Slot", new NBTTagString("mainhand"));
		damage.set("Operation", new NBTTagInt(0));
		damage.set("UUIDLeast", new NBTTagInt(894654));
		damage.set("UUIDMost", new NBTTagInt(2872));
		modifiers.add(damage);
		tc.set("AttributeModifiers", modifiers);
		tc.setBoolean("Unbreakable", true);
		item.setTag(tc);
		
		espadaDoAprendiz = CraftItemStack.asBukkitCopy(item);
		return espadaDoAprendiz;
	}
	
	

}
