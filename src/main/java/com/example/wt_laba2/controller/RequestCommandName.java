package com.example.wt_laba2.controller;

/**
 * Class containing constants for request parameter names.
 * Used to retrieve command and page names from HTTP requests.
 */
public class RequestCommandName {

    /** Private constructor to prevent instantiation of this class. */
    private RequestCommandName() {}

    /** Constant representing the command parameter name in HTTP requests. */
    public static final String COMMAND_NAME = "command";

    /** Constant representing the page name parameter in HTTP requests. */
    public static final String PAGE_NAME = "page_name";
}
