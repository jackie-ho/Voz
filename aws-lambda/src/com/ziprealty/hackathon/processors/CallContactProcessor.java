package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.response.DialogAction;
import com.ziprealty.hackathon.lex.response.Message;

import java.util.HashMap;
import java.util.Map;

import static com.ziprealty.hackathon.lex.ResponseBuilder.getPhoneNumberFromRequest;
import static com.ziprealty.hackathon.util.Constants.*;
import static com.ziprealty.hackathon.util.Constants.CLOSE;
import static com.ziprealty.hackathon.util.Constants.FULFILLED;

/**
 * Created by jamgale on 7/16/17.
 */
class CallContactProcessor {

    private CallContactProcessor(){

    }


    static void processCallContactIntent(LexRequest lexRequest, LexResponse lexResponse) {
        Map<String, String> sessionAttributes = lexResponse.getSessionAttributes();
        // would you like to call 'contact saved from view contact'
        if (DIALOG_CODE_HOOK.equals(lexRequest.getInvocationSource())) {
            // Try both DELEGATE and ElicitSlot
            if (lexResponse.getSessionAttributes().containsKey("first_name")) {
                useSessionAttributesAndConfirm(lexResponse);
            } else if (lexRequest.getSlots().get(FULL_NAME) == null ) {
                elicitSlot(lexResponse);
            }
            else {
                fulfillCall(lexRequest, lexResponse, sessionAttributes);
            }
        } else if (FULFILLMENT_CODE_HOOK.equals(lexRequest.getInvocationSource())){
            fulfillCall(lexRequest, lexResponse, sessionAttributes);
        }
    }

    private static void fulfillCall(LexRequest lexRequest, LexResponse lexResponse, Map<String, String> sessionAttributes) {
        Message message = new Message(PLAIN_TEXT, "Calling " + lexRequest.getSlots().get(FULL_NAME));
        String phoneNumber = getPhoneNumberFromRequest(lexRequest);
        sessionAttributes.put("telephone_number", phoneNumber);
        lexResponse.setSessionAttributes(sessionAttributes);
        lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
    }

    private static void elicitSlot(LexResponse lexResponse) {
        Message message = new Message(PLAIN_TEXT, "Who would you like to call?");
        DialogAction dialogAction = new DialogAction(ELICIT_SLOT, null, message);
        dialogAction.setSlotToElicit(FULL_NAME);
        dialogAction.setIntentName(CALL_CONTACT);
        Map<String, Object> slots = new HashMap<>();
        slots.put(FULL_NAME, null);
        dialogAction.setSlots(slots);

        lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
    }

    private static void useSessionAttributesAndConfirm(LexResponse lexResponse) {
        Message message = new Message(PLAIN_TEXT, "Would you like to call " + lexResponse.getSessionAttribute("first_name") + " " + lexResponse.getSessionAttribute("last_name") + "?");
        lexResponse.setDialogAction(new DialogAction(CONFIRM_INTENT, null, message));
    }
}
