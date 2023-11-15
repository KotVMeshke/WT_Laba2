package com.example.wt_laba2.exception;

/**
 * Signals an exception related to Data Access Objects (DAO) operations.
 * Extends ProjectException.
 */
public class DAOException extends ProjectException {

    /**
     * Constructs a new DAOException with no specified detail message.
     */
    public DAOException() {
        super();
    }

    /**
     * Constructs a new DAOException with the specified detail message.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Constructs a new DAOException with the specified detail message and cause.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     * @param ex The cause (which is saved for later retrieval by the getCause() method).
     */
    public DAOException(String message, Exception ex) {
        super(message, ex);
    }
}
