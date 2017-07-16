package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.messageObject.DialogAction;
import com.ziprealty.hackathon.lex.messageObject.Message;
import com.ziprealty.hackathon.lex.messageObject.SessionAttributes;

import static com.ziprealty.hackathon.util.Constants.*;

/**
 * Created by jamgale on 7/16/17.
 */
class ShowScheduleProcessor {

    private ShowScheduleProcessor() {

    }


    static void processScheduleIntent(LexRequest lexRequest, LexResponse lexResponse) {
        String response;
        SessionAttributes sessionAttributes = new SessionAttributes();
        if (SHOW_TODAYS_SCHEDULE.equals(lexRequest.getIntentName())) {
            response = "Showing today's schedule";
            sessionAttributes.setSchedule(TODAY);
        }
        else if (SHOW_WEEK_SCHEDULE.equals(lexRequest.getIntentName())) {
            response = "Showing this week's schedule";
            sessionAttributes.setSchedule(WEEK);
        }
        else {
            response = "error: schedule intent malfunction";
        }
        sessionAttributes.setInputTranscript(response);
        Message message = new Message(PLAIN_TEXT, response);
        lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
        lexResponse.setSessionAttributes(sessionAttributes);
    }
}
