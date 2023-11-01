package com.example.wt_laba2.logic;

import com.example.wt_laba2.logic.impl.Register;
import com.example.wt_laba2.logic.impl.SignIn;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private static final CommandHelper commandHelper = new CommandHelper();

    private Map<CommandName, ICommand> commands = new HashMap<>();

    public CommandHelper(){
        commands.put(CommandName.SIGN_IN, new SignIn());
        commands.put(CommandName.REGISTER, new Register());
    }

    public static CommandHelper getCommandHelper(){
        return commandHelper;
    }

    public ICommand getCommand(String commandName){
        CommandName name = CommandName.valueOf(commandName);
        ICommand command;
        if (name != null){
            command = commands.get(name);
        }else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }
}
