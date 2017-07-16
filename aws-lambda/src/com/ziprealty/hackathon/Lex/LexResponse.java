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

    public SessionAttributes getSessionAttributes() {
        return sessionAttributes;
    }

    public void setDialogAction(DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

    public void setSessionAttributes(SessionAttributes sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
}
