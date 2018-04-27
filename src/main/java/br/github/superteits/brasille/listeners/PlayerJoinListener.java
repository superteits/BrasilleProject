package br.github.superteits.brasille.listeners;

import br.github.superteits.brasille.Brasille;
import br.github.superteits.brasille.Status;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onConnect(PlayerJoinEvent e) {
        Brasille.pstatus.put(e.getPlayer(), new Status(e.getPlayer().getUniqueId().toString(), 0, 0, 0, 0, 0, 0, 0, 0, true, 0, 0));
        e.getPlayer().setHealthScaled(true);
        if(!e.getPlayer().hasPlayedBefore())
            e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(1024.0D);
    }

}
