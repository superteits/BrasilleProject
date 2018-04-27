package br.github.superteits.brasille.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent c) {
        if(c.getInventory() != null) {
            if(c.getInventory().getName().equals(ChatColor.BLACK + c.getWhoClicked().getName() + " Info")) {
                if(c.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "For�a")) {
                    ((Player)c.getWhoClicked()).performCommand("status str 1");
                    c.setCancelled(true);
                }
                else if(c.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Vitalidade")) {
                    ((Player)c.getWhoClicked()).performCommand("status vit 1");
                    c.setCancelled(true);
                }
                else if(c.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Destreza")) {
                    ((Player)c.getWhoClicked()).performCommand("status dex 1");
                    c.setCancelled(true);
                }
                else if(c.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Agilidade")) {
                    ((Player)c.getWhoClicked()).performCommand("status agi 1");
                    c.setCancelled(true);
                }
                else if(c.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Intelig�ncia")) {
                    ((Player)c.getWhoClicked()).performCommand("status int 1");
                    c.setCancelled(true);
                }
                else {
                    c.setCancelled(true);
                }
            }
        }
    }

}
