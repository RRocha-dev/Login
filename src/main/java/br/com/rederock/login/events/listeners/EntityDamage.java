package br.com.rederock.login.events.listeners;

import br.com.rederock.login.api.LoginAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {
    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (!LoginAPI.hasLogin(player)) {
                event.setCancelled(true);
            }
        }
    }
}
