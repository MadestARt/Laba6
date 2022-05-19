package com.madest.exceptions;

public class ServerConnectionException extends RuntimeException{

    public ServerConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
