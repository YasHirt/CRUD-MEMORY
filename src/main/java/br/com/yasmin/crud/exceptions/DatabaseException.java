package br.com.yasmin.crud.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message, Exception cause) {
        super(message);
    }
}
