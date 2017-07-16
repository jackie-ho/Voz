package com.ziprealty.hackathon.Lex;

import com.ziprealty.hackathon.Lex.MessageObject.DialogAction;
import com.ziprealty.hackathon.Lex.MessageObject.SessionAttributes;

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
