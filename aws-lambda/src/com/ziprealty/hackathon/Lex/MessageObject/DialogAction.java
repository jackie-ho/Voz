package com.ziprealty.hackathon.Lex.MessageObject;

/**
 * Created by jamgale on 7/14/17.
 */
public class DialogAction {

    private String type;
    private String fulfillmentState;

    private LexMessage message;


    public DialogAction(String type, String fulfillmentState, LexMessage message) {
        this.type = type;
        this.fulfillmentState = fulfillmentState;
        this.message = message;
    }


    public String getType() {
        return type;
    }

    public String getFulfillmentState() {
        return fulfillmentState;
    }

    public LexMessage getLexMessage() {
        return message;
    }

}
