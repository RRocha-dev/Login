package br.com.rederock.login.events.listeners;

import br.com.rederock.login.Login;
import br.com.rederock.login.api.LoginAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!LoginAPI.hasRegister(player)) {
            player.sendMessage("§2 Utilize → /registrar <Senha> <Confirma Senha> ←");
            player.sendMessage("§2 Para se registrar");
        } else {
            player.sendMessage("§2 Utilize → /login <Sua Senha> ←");
            player.sendMessage("§2 Para logar-se");
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!LoginAPI.hasLogin(player)){
                    player.kickPlayer("§4Você demorou muito para entrar.");
                }
            }
        }.runTaskLater(Login.getInstance(), 20*20);
    }
}
