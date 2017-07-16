package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.messageObject.DialogAction;
import com.ziprealty.hackathon.lex.messageObject.Message;
import com.ziprealty.hackathon.lex.messageObject.SessionAttributes;
import com.ziprealty.hackathon.pojo.Event;


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


        SessionAttributes sessionAttributes = new SessionAttributes();
        Message message;
        DialogAction dialogAction;
        LexResponse lexResponse = new LexResponse(null, null);
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
            message = new Message(PLAIN_TEXT, "IM at a different spot and HERE and invocation source is  " + lexRequest.getInvocationSource());
            dialogAction = new DialogAction(CLOSE, FULFILLED, message);
            sessionAttributes = new SessionAttributes();
            lexResponse.setDialogAction(dialogAction);
            lexResponse.setSessionAttributes(sessionAttributes);
        }

        return lexResponse;
    }
}
