package br.com.rederock.login.commands.executors;

import br.com.rederock.login.Login;
import br.com.rederock.login.api.LoginAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("§2Esse comando só pode ser executado por Jogadores!");
            return false;
        }
        Player player = (Player) sender;
        int trying = 0;

        if (args.length == 0) {
            return false;
        } else {
            if (trying <= 3) {
                trying++;
                if (!LoginAPI.hasLogin(player)) {
                    String password = args[0];

                    if (password.equals(LoginAPI.getPassword(player))) {
                        LoginAPI.login(player);
                        player.sendMessage("§3Logado com Sucesso!");
                        player.sendMessage("§3Seja bem vindo ao servidor §2" + player.getName() + "§3!");
                    } else {
                        player.sendMessage("§4Senha incorreta!");
                    }
                } else {
                    player.sendMessage("§6 Você já está logado!");
                }
            } else {
                player.kickPlayer("§4Tentativas expiradas!");
            }
        }
        return true;
    }
}
