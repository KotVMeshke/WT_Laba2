package com.example.wt_laba2.logic;

import com.example.wt_laba2.logic.impl.*;
import com.example.wt_laba2.logic.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The CommandHelper class manages a set of commands available in the application.
 * It provides methods to retrieve specific commands based on their names.
 */
public class CommandHelper {

    /**
     * Singleton instance of the CommandHelper class.
     */
    private static final CommandHelper commandHelper = new CommandHelper();

    /**
     * Map containing CommandName enum as keys and ICommand implementations as values.
     * This map stores the available commands and their associated implementations.
     */
    private final Map<CommandName, ICommand> commands = new HashMap<>();

    /**
     * Constructs a CommandHelper instance and initializes available commands.
     * The constructor populates the commands map with predefined commands.
     */
    public CommandHelper(){
        // Initializing predefined commands
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

    /**
     * Retrieves the singleton instance of the CommandHelper class.
     * @return The singleton instance of CommandHelper.
     */
    public static CommandHelper getCommandHelper(){
        return commandHelper;
    }

    /**
     * Retrieves the ICommand implementation associated with the given command name.
     * @param commandName The name of the command.
     * @return The ICommand implementation corresponding to the command name.
     */
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

