package br.com.rederock.login;

import br.com.rederock.login.commands.CommandHandler;
import br.com.rederock.login.events.EventHandler;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Login extends JavaPlugin {

    @Getter
    @Setter
    private static Login instance;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§4Plugin §2Login §4Iniciado");
        instance = this;
        new CommandHandler(this);
        new EventHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
