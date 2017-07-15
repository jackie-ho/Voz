package com.ziprealty.hackathon.Lex;

import com.ziprealty.hackathon.Lex.MessageObject.DialogAction;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexResponse {
    private DialogAction dialogAction;

    public LexResponse(DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

    public DialogAction getDialogAction() {
        return dialogAction;
    }
}
