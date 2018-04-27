package br.github.superteits.brasille.mobs;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

import br.teits.brasille.items.BrasilleItems;
import br.teits.brasille.utils.LevelHandler;

public class JavaliDoTutorial extends BrasilleMobs{
	
	@EventHandler
    @Override
	public void onDeath(EntityDeathEvent death) {
		if(death.getEntity().getCustomName() != null) {
			if(death.getEntity().getKiller() != null) {
				if(death.getEntity().getCustomName().equals(getName())) {
					//LevelHandler.rewardExp(death.getEntity().getKiller(), 500);
					System.out.println("javali");
					if(ThreadLocalRandom.current().nextInt(1, 100 + 1) <= 25)
						death.getDrops().add(BrasilleItems.ArcoDoAprendiz.createItem());
					//MachadoDoAprendiz
					else if(ThreadLocalRandom.current().nextInt(1, 100 + 1) >= 26 && ThreadLocalRandom.current().nextInt(1, 100 + 1) <= 50)
						death.getDrops().add(BrasilleItems.MachadoDoAprendiz.createItem());
					//EspadaDoAprendiz
					else if(ThreadLocalRandom.current().nextInt(1, 100 + 1) >= 51 && ThreadLocalRandom.current().nextInt(1, 100 + 1) <= 75)
						death.getDrops().add(BrasilleItems.EspadaDoAprendiz.createItem());
					//CaldeiraoDoAprendiz
					else
						death.getDrops().add(BrasilleItems.CaldeiraoDoAprendiz.createItem());
				}
			}
		}
	}
	

	public void createEntity(World world, Location location) {
		Pig pig = (Pig) world.spawnEntity(location, EntityType.PIG);
		pig.setCustomName(ChatColor.UNDERLINE + "Javali do Tutorial");
		pig.setCustomNameVisible(true);
		pig.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(15.0D);
	}
	
	public String getName() {
		return ChatColor.UNDERLINE + "Javali do Tutorial";
	}

}
