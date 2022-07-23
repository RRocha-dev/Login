package br.com.rederock.login.events;

import br.com.rederock.login.Login;
import br.com.rederock.login.events.listeners.PlayerMove;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class EventHandler {
    public EventHandler(Login plugin) {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerMove(), plugin);
    }
}
