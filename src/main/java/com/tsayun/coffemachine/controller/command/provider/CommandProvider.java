package com.tsayun.coffemachine.controller.command.provider;

import com.tsayun.coffemachine.controller.command.Command;

public interface CommandProvider {
    Command getCommand(String commandName);
}
