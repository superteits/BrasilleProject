package br.github.superteits.brasille.items;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import br.teits.brasille.items.weapons.axes.MachadoDoAprendiz;
import br.teits.brasille.items.weapons.bows.ArcoDoAprendiz;
import br.teits.brasille.items.weapons.cauldrons.CaldeiraoDoAprendiz;
import br.teits.brasille.items.weapons.swords.EspadaDoAprendiz;

public class BrasilleItems implements Listener{
	
	public static ArcoDoAprendiz ArcoDoAprendiz = new ArcoDoAprendiz();
	public static EspadaDoAprendiz EspadaDoAprendiz = new EspadaDoAprendiz();
	public static MachadoDoAprendiz MachadoDoAprendiz = new MachadoDoAprendiz();
	public static CaldeiraoDoAprendiz CaldeiraoDoAprendiz = new CaldeiraoDoAprendiz();
	
	public void onAttack(EntityDamageByEntityEvent act) {
	}
	
	public ItemStack createItem() {
		return null;
	}

}
