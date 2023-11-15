package com.example.wt_laba2.Jsp.impl;

import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.logic.JSPPAge;
import jakarta.servlet.http.HttpServletRequest;

/**
 * ErrorPage represents the logic for handling error pages in the application.
 */
public class ErrorPage implements JSPPAge {

    /**
     * Executes the logic related to displaying an error page.
     * @param request The HttpServletRequest object.
     * @return A String representing the page or resource to redirect or display in case of an error.
     * @throws CommandException If an error occurs while executing the command.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return null;
    }
}
