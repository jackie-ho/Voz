package com.ziprealty.hackathon.Lex.MessageObject;

/**
 * Created by jamgale on 7/15/17.
 */
public class SQLResponse {

    private int responseCode;
    private String message;

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
