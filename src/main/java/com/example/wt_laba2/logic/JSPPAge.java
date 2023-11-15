package com.example.wt_laba2.logic;

import com.example.wt_laba2.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * The JSPPAge interface represents a JSP page action that can be executed.
 * Classes implementing this interface define specific actions to be performed on JSP pages.
 */
public interface JSPPAge {

    /**
     * Executes a specific action associated with a JSP page based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the request.
     * @return A String representing the result or outcome of the JSP page action.
     * @throws CommandException If an error occurs while executing the JSP page action.
     */
    String execute(HttpServletRequest request) throws CommandException;
}

