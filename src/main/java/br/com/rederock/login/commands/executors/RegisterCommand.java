package br.com.rederock.login.commands.executors;

import br.com.rederock.login.Login;
import br.com.rederock.login.api.LoginAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("§4 Esse comando só pode ser executado por jogadores!");
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            return false;
        } else {
            if (!LoginAPI.hasRegister(player)) {
                String initialPassword = args[0];
                if (args.length < 2) {
                    player.sendMessage("§2Digite a confirmação de senha!");
                } else {
                    String confirmPassword = args[1];
                    if (initialPassword.equals(confirmPassword)) {
                        LoginAPI.register(player, initialPassword);
                        player.sendMessage("§2Você Logou com sucesso!");
                        LoginAPI.login(player);
                    } else {
                        player.sendMessage("§2Senhas não conferem");
                    }
                }
            } else {
                player.sendMessage("§2Você já está registrado!");
            }
        }

        return true;
    }
}
