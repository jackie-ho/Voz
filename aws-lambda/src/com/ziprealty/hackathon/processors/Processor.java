package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.response.DialogAction;
import com.ziprealty.hackathon.lex.response.Message;


import java.util.Map;

import static com.ziprealty.hackathon.processors.CallContactProcessor.processCallContactIntent;
import static com.ziprealty.hackathon.processors.ContactPageProcessor.processContactPage;
import static com.ziprealty.hackathon.processors.DirectionProcessor.processDirections;
import static com.ziprealty.hackathon.processors.DisplayContactProcessor.processDisplayContact;
import static com.ziprealty.hackathon.processors.ShowScheduleProcessor.processScheduleIntent;
import static com.ziprealty.hackathon.util.Constants.*;

/**
 * Created by jamgale on 7/16/17.
 */
public class Processor {

    public LexResponse processIntent(LexRequest lexRequest) {


        Map<String, String> sessionAttributes = lexRequest.getSessionAttributes();
        Message message;
        LexResponse lexResponse = new LexResponse(null, null);
        lexResponse.setSessionAttributes(sessionAttributes);

        try {
            switch (lexRequest.getIntentName()) {
                case DISPLAY_CONTACT_INTENT:
                    processDisplayContact(lexRequest, lexResponse);
                    break;
                case SHOW_TODAYS_SCHEDULE:
                case SHOW_WEEK_SCHEDULE:
                    processScheduleIntent(lexRequest, lexResponse);
                    break;
                case NEXT_EVENT:
                    sessionAttributes.put("next_event", "true");
                    lexResponse.setSessionAttributes(sessionAttributes);
                    message = new Message(PLAIN_TEXT, "Here is your next event");
                    lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
                    break;
                case CALL_CONTACT:
                    processCallContactIntent(lexRequest, lexResponse);
                    break;
                case DIRECTIONS:
                    processDirections(lexRequest, lexResponse);
                    break;
                case SHOW_CONTACTS:
                    sessionAttributes.put("show_contacts", "true");
                    lexResponse.setSessionAttributes(sessionAttributes);
                    message = new Message(PLAIN_TEXT, "loading contacts");
                    lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
//                    processContactPage(lexRequest, lexResponse);
                    break;

                default:
                    message = new Message(PLAIN_TEXT, "Intent not recognised");
                    lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));

            }
        } catch (Exception e) {
            message = new Message(PLAIN_TEXT, "ERROR " + e.getMessage());
            lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
        }

        return lexResponse;
    }

    private void processStartListening(LexResponse lexResponse) {
        Map<String, String> sessionAttributes = lexResponse.getSessionAttributes();
        Message message = new Message(PLAIN_TEXT, "How can I help?");
        sessionAttributes.put("start_listening", "true");
        lexResponse.setDialogAction(new DialogAction(ELICIT_INTENT, null, message));
        lexResponse.setSessionAttributes(sessionAttributes);
    }
}
