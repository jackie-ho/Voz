package com.ziprealty.hackathon.lex;

import com.ziprealty.hackathon.lex.response.DialogAction;

import java.util.Map;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexResponse {
    private DialogAction dialogAction;

    private Map<String, String> sessionAttributes;

    public LexResponse(DialogAction dialogAction, Map<String, String> sessionAttributes) {
        if (dialogAction != null) {
            this.dialogAction = dialogAction;
        }
        if (sessionAttributes != null) {
            this.sessionAttributes = sessionAttributes;
        }
    }

    public DialogAction getDialogAction() {
        return dialogAction;
    }

    public Map<String, String> getSessionAttributes() {
        return sessionAttributes;
    }

    public String getSessionAttribute(String key){
        return sessionAttributes.get(key);
    }

    public void setDialogAction(DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

    public void setSessionAttributes(Map<String, String> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
}
