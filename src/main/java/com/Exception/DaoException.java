package com.Exception;

public class DaoException extends Exception{
    private final static String HEADER = "Error in DAO: ";
    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(HEADER + message);
    }
}
