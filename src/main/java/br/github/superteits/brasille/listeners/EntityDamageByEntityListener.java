package br.github.superteits.brasille.listeners;

import br.github.superteits.brasille.Brasille;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.SplashPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Arrow) {
            Arrow p = (Arrow) e.getDamager();
            if(p.getShooter() instanceof Player) {
                Player pl = (Player) p.getShooter();
                int chance = Brasille.random.nextInt(101);
                e.setDamage(e.getDamage() + (Brasille.pstatus.get(pl).getDex() / 2));
                if(chance > 0 && chance <= Brasille.pstatus.get(pl).getCritChance()) {
                    e.setDamage(e.getFinalDamage() * 2);
                }
            }
            //e.setDamage(e.getDamage() * Brasille.pstatus.get(p).getStr());
        }
        if(e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            int chance = Brasille.random.nextInt(101);
            if(chance > 0 && chance <= Brasille.pstatus.get(p).getCritChance()) {
                e.setDamage(e.getDamage() * 2);
            }

        }
        if(e.getDamager() instanceof SplashPotion) {
            SplashPotion sp = (SplashPotion) e.getDamager();
            if(sp.getShooter() instanceof Player) {
                Player p = (Player) sp.getShooter();
                e.setDamage(e.getDamage() + (Brasille.pstatus.get(p).getInte() / 2));
            }
        }
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            int chance = Brasille.random.nextInt(101);
            if(chance > (100 - Brasille.pstatus.get(p).getFlee()) && chance <= 100) {
                e.setDamage(e.getDamage() * 0);
            }
        }
        //Bukkit.broadcastMessage(String.valueOf(e.getDamager()));
    }

}
