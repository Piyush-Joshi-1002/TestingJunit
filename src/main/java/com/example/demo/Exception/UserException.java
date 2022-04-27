package com.example.demo.Exception;

public class UserException extends Exception{
    public UserException(){

    }
    public UserException(String errorMessage) {
        super(errorMessage);
    }
    public Throwable notFoundException(String Err) throws UserException {
        throw new UserException(Err);
    }

}
