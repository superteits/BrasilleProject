package br.github.superteits.brasille.listeners;

import org.bukkit.Material;
import org.bukkit.entity.SplashPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PlayerInteractListener implements Listener {

    ItemStack potionis = new ItemStack(Material.SPLASH_POTION);
    PotionEffect potione = new PotionEffect(PotionEffectType.HEAL, 1, 1);
    PotionEffect potione2 = new PotionEffect(PotionEffectType.HARM, 1, 1);

    @EventHandler
    public void onInteract(PlayerInteractEvent i) {
        if(i.getItem() != null) {
            if(i.getItem().getType().equals(Material.WOOD_SPADE)) {
                if(i.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    PotionMeta potionMeta = (PotionMeta) potionis.getItemMeta();
                    potionMeta.addCustomEffect(potione, true);
                    potionis.setItemMeta(potionMeta);
                    SplashPotion sp = i.getPlayer().launchProjectile(SplashPotion.class, new Vector(i.getPlayer().getLocation().getDirection().getX(), i.getPlayer().getLocation().getDirection().getY(), i.getPlayer().getLocation().getDirection().getZ()));
                    sp.setItem(potionis);
                }
                else if(i.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    PotionMeta potionMeta = (PotionMeta) potionis.getItemMeta();
                    potionMeta.addCustomEffect(potione2, true);
                    potionis.setItemMeta(potionMeta);
                    SplashPotion sp = i.getPlayer().launchProjectile(SplashPotion.class, new Vector(i.getPlayer().getLocation().getDirection().getX(), i.getPlayer().getLocation().getDirection().getY(), i.getPlayer().getLocation().getDirection().getZ()));
                    sp.setItem(potionis);
                }
            }
        }
    }

}
