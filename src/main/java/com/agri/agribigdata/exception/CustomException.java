package com.agri.agribigdata.exception;

public class CustomException extends Exception{
    private int code;
    private String msgToFront;

    public CustomException(int code, String message, String msgToFront) {
        super(message);
        this.code = code;
        this.msgToFront = msgToFront;
    }

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
        this.msgToFront = msgToFront;
    }

    public String getMsgToFront(){
        return this.msgToFront;
    }

    public int getCode() {
        return code;
    }
}
