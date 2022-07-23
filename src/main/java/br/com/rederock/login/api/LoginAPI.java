package br.com.rederock.login.api;

import br.com.rederock.login.Login;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class LoginAPI {
    @Getter
    @Setter
    private static Login login;

    static {
        login = Login.getInstance();
    }

    @Getter
    private static List<Player> listLoginPlayers = new ArrayList();

    public static boolean hasLogin(Player player) {
        return listLoginPlayers.contains(player);
    }

    public static void login(Player player) {
        listLoginPlayers.add(player);
    }

    public static void logOut(Player player) {
        listLoginPlayers.remove(player);
    }

    public static String getPassword(Player player) {
        return login.getConfig().getString(player.getName().toLowerCase());
    }

    public static boolean hasRegister(Player player) {
        return login.getConfig().contains(player.getName().toLowerCase());
    }

    public static void suspendAccount(String account) {
        login.getConfig().set(account.toLowerCase(), null);
        login.saveConfig();
    }

    public static void register(Player player, String password) {
        login.getConfig().set(player.getName().toLowerCase(), password);
        login.saveConfig();
    }


}
