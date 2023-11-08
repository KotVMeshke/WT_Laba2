package com.example.wt_laba2.logic;

import com.example.wt_laba2.logic.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private static final CommandHelper commandHelper = new CommandHelper();

    private Map<CommandName, ICommand> commands = new HashMap<>();

    public CommandHelper(){
        commands.put(CommandName.SIGN_IN, new SignIn());
        commands.put(CommandName.REGISTER, new Register());
        commands.put(CommandName.DISPLAY_PRODUCTS, new GetProducts());
        commands.put(CommandName.ADD_TO_CART, new AddProductIntoCart());
        commands.put(CommandName.TO_PAGE, new PageChanger());
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
