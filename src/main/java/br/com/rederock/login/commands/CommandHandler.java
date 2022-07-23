package br.com.rederock.login.commands;

import br.com.rederock.login.Login;
import br.com.rederock.login.commands.executors.ChangePasswordCommand;
import br.com.rederock.login.commands.executors.LoginCommand;
import br.com.rederock.login.commands.executors.RegisterCommand;

public class CommandHandler {
    public CommandHandler(Login plugin) {
        plugin.getCommand("login").setExecutor(new LoginCommand());
        plugin.getCommand("registrar").setExecutor(new RegisterCommand());
        plugin.getCommand("mudarsenha").setExecutor(new ChangePasswordCommand());
    }
}
