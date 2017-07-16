package com.ziprealty.hackathon.lex;

import com.ziprealty.hackathon.lex.messageObject.DialogAction;
import com.ziprealty.hackathon.lex.messageObject.SessionAttributes;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexResponse {
    private DialogAction dialogAction;
    private SessionAttributes sessionAttributes;

    public LexResponse(DialogAction dialogAction, SessionAttributes sessionAttributes) {
        this.dialogAction = dialogAction;
        if (sessionAttributes != null) {
            this.sessionAttributes = sessionAttributes;
        }
    }

    public DialogAction getDialogAction() {
        return dialogAction;
    }

    public SessionAttributes getSessionAttributes() {
        return sessionAttributes;
    }

}
