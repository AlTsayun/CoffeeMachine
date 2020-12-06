package com.tsayun.coffemachine.controller.command.provider.impl;

import com.tsayun.coffemachine.controller.command.Command;
import com.tsayun.coffemachine.controller.command.provider.CommandProvider;

import java.util.HashMap;
import java.util.Map;

public class CommandProviderImpl implements CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProviderImpl() {
//        commands.put("authorization", new AuthorizationCommand());
//        commands.put("goToRegistratioPage", new GoToRegistrationCommand());
//        commands.put("registration", new RegistrationCommand());
//        commands.put("find_book", new FindBookCommand());
//        commands.put("go_to_index", new GoToIndexPageCommand());
//        commands.put("change_locale", new ChangeLocale());
    }

    @Override
    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
