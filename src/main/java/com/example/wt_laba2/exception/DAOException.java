package com.example.wt_laba2.exception;

public class DAOException extends ProjectException {

    public DAOException(){
        super();
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(String message,Exception ex){
        super(message,ex);
    }
}
