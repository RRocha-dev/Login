package br.com.rederock.login.events.listeners;

import br.com.rederock.login.api.LoginAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!LoginAPI.hasLogin(player)) {
            player.teleport(event.getFrom());
        }
    }
}
