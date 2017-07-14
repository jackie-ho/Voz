package com.ziprealty.hackathon.Lex.MessageObjects;

/**
 * Created by jamgale on 7/14/17.
 */
public class Message {
    private String contentType;
    private String content;

    public Message(String contentType, String content) {
        this.contentType = contentType;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getContentType() {
        return contentType;
    }
}
