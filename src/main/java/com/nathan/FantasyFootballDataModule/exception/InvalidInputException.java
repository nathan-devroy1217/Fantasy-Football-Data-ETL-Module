package com.nathan.FantasyFootballDataModule.exception;

public class InvalidInputException extends Throwable {

    public InvalidInputException(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidInputException(String msg) {
        super(msg);
    }
}
