package com.ziprealty.hackathon.Lex.MessageObject;

/**
 * Created by jamgale on 7/15/17.
 *
 * shares session attributes across conversations
 * say we load up Ben Burnside's profile page and say call a contact
 *
 * We can pass Ben's details and ask if you want to call him
 */

public class SessionAttributes {
    private String key1;
    private String key2;

    public SessionAttributes(String key1, String key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }
}
