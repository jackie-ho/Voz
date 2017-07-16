package com.ziprealty.hackathon.Lex.MessageObject;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexMessage {
    private String contentType;
    private String content;

    public LexMessage(String contentType, String content) {
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
