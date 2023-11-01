package com.example.wt_laba2.exception;

public class CommandException extends ProjectException{

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Exception ex) {
        super(message, ex);
    }
}
