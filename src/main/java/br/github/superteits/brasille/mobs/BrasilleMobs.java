package br.github.superteits.brasille.mobs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import br.teits.brasille.utils.LevelHandler;

public class BrasilleMobs implements Listener{
	
	public static JavaliDoTutorial JavaliDoTutorial = new JavaliDoTutorial();
	
	@EventHandler //(priority = EventPriority.LOWEST)
	public void onDeath(EntityDeathEvent death) {
		System.out.println("brasille");
		if(death.getEntity() instanceof Player) {
			LevelHandler.xpPenalty((Player)death.getEntity());
		}
		else {
			death.setDroppedExp(0);
			LevelHandler.rewardExp(death.getEntity().getKiller(), death.getEntity());
			/*death.getDrops().clear();
			death.setDroppedExp(0);
			if(death.getEntity().getKiller() != null) {
				if(!death.getEntity().getKiller().getEquipment().getItemInMainHand().getType().equals(Material.AIR))
					DurabilityHandler.removeDurability(death.getEntity().getKiller().getEquipment().getItemInMainHand(), 1);
				else if(!death.getEntity().getKiller().getEquipment().getItemInOffHand().getType().equals(Material.AIR))
					DurabilityHandler.removeDurability(death.getEntity().getKiller().getEquipment().getItemInOffHand(), 1);
			}*/
		}	
	}
	
	public void createEntity(World world, Location location) {
	}

}
