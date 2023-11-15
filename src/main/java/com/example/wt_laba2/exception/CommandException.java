package com.example.wt_laba2.exception;

/**
 * Signals an exception in command execution.
 * Extends ProjectException.
 */
public class CommandException extends ProjectException {

    /**
     * Constructs a new CommandException with the specified detail message.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public CommandException(String message) {
        super(message);
    }

    /**
     * Constructs a new CommandException with the specified detail message and cause.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     * @param ex The cause (which is saved for later retrieval by the getCause() method).
     */
    public CommandException(String message, Exception ex) {
        super(message, ex);
    }
}
