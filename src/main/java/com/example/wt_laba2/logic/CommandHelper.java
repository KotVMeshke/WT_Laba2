package com.example.wt_laba2.logic;

import com.example.wt_laba2.logic.impl.*;
import com.example.wt_laba2.logic.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private static final CommandHelper commandHelper = new CommandHelper();

    private final Map<CommandName, ICommand> commands = new HashMap<>();

    public CommandHelper(){
        commands.put(CommandName.SIGN_IN, new SignIn());
        commands.put(CommandName.REGISTER, new Register());
        commands.put(CommandName.DISPLAY_PRODUCTS, new GetProducts());
        commands.put(CommandName.ADD_TO_CART, new AddProductIntoCart());
        commands.put(CommandName.EXIT, new LogOut());
        commands.put(CommandName.REMOVE_FROM_CART, new RemoveProductFromCart());
        commands.put(CommandName.PROCESS_ORDER, new ProcessOrder());
        commands.put(CommandName.SET_DISCOUNT, new SetDiscount());
        commands.put(CommandName.SET_BAN, new SetBan());
        commands.put(CommandName.REMOVE_BAN, new RemoveBan());
        commands.put(CommandName.ADD_PRODUCT, new AddProduct());
        commands.put(CommandName.UPDATE_CART, new UpdateCart());
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
