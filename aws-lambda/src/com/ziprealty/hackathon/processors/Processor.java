package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.response.DialogAction;
import com.ziprealty.hackathon.lex.response.Message;
import com.ziprealty.hackathon.pojo.Event;


import java.util.HashMap;
import java.util.Map;

import static com.ziprealty.hackathon.lex.ResponseBuilder.getNextEventFromRequest;
import static com.ziprealty.hackathon.processors.CallContactProcessor.processCallContactIntent;
import static com.ziprealty.hackathon.processors.DisplayContactProcessor.processDisplayContact;
import static com.ziprealty.hackathon.processors.ShowScheduleProcessor.processScheduleIntent;
import static com.ziprealty.hackathon.util.Constants.*;

/**
 * Created by jamgale on 7/16/17.
 */
public class Processor {

    public LexResponse processIntent(LexRequest lexRequest) {


        Map<String, String> sessionAttributes = new HashMap<>();
        Message message;
        DialogAction dialogAction;
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
                    Event nextEvent = getNextEventFromRequest(lexRequest);
//                sessionAttributes = createSessionAttributesFromNextEvent(nextEvent);
                    break;
                case CALL_CONTACT:
                    processCallContactIntent(lexRequest, lexResponse);
                    break;
                case DIRECTIONS:
                    // use nextEvent to ask about directions to the next event
                    break;
                default:
                    message = new Message(PLAIN_TEXT, "Intent not recognised");
                    lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));

            }
        }
        catch (Exception e) {
            message = new Message(PLAIN_TEXT, "ERROR: " + sessionAttributes.toString());
            dialogAction = new DialogAction(CLOSE, FULFILLED, message);
            sessionAttributes = new HashMap<>();
            lexResponse.setDialogAction(dialogAction);
            lexResponse.setSessionAttributes(sessionAttributes);
        }

        return lexResponse;
    }
}
