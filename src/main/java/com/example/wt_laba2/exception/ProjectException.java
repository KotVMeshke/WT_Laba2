package com.example.wt_laba2.exception;

/**
 * Base exception class for handling exceptions within the project.
 * Extends the standard Java Exception class.
 */
public class ProjectException extends Exception {
    private Exception hiddenException;

    /**
     * Constructs a new ProjectException with no specified detail message.
     */
    public ProjectException() {
        super();
    }

    /**
     * Constructs a new ProjectException with the specified detail message.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ProjectException(String message) {
        super(message);
    }

    /**
     * Constructs a new ProjectException with the specified detail message and cause.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     * @param ex The cause (which is saved for later retrieval by the getCause() method).
     */
    public ProjectException(String message, Exception ex) {
        super(message);
        hiddenException = ex;
    }

    /**
     * Retrieves the hidden exception that caused this ProjectException.
     * @return The hidden exception (if available), null otherwise.
     */
    public Exception getHiddenException() {
        return hiddenException;
    }
}
