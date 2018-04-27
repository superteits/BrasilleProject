package br.github.superteits.brasille.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnListener implements Listener {

    @EventHandler
    public void onNaturalMobSpawn(CreatureSpawnEvent s) {
        if(!s.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.CUSTOM) || !s.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER_EGG)) {
            s.setCancelled(true);
        }
    }

}
