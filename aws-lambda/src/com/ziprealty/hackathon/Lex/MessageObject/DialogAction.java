package com.ziprealty.hackathon.Lex.MessageObject;

/**
 * Created by jamgale on 7/14/17.
 */
public class DialogAction {

    private String type;
    private String fulfillmentState;

    private Message message;
    private String slotToElicit;


    public DialogAction(String type, String fulfillmentState, Message message) {
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

    public Message getMessage() {
        return message;
    }

    public String getSlotToElicit() {
        return slotToElicit;
    }

    public void setSlotToElicit(String slotToElicit) {
        this.slotToElicit = slotToElicit;
    }

}
