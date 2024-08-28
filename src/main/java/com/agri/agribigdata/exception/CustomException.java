package com.agri.agribigdata.exception;

public class CustomException extends Exception{
    private int code;

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
