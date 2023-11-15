package com.example.wt_laba2.logic;

import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The ICommand interface represents a command that can be executed.
 * Classes implementing this interface define specific actions to be performed.
 */
public interface ICommand {

    /**
     * Executes a specific action based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the request.
     * @return A String representing the result or outcome of the command execution.
     * @throws CommandException         If an error occurs while executing the command.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException              If an I/O exception occurs during execution.
     * @throws DAOException             If there's an issue with the Data Access Object.
     */
    String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException;
}
