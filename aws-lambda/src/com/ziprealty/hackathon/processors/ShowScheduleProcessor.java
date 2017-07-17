package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.response.DialogAction;
import com.ziprealty.hackathon.lex.response.Message;

import java.util.HashMap;
import java.util.Map;

import static com.ziprealty.hackathon.util.Constants.*;

/**
 * Created by jamgale on 7/16/17.
 */
class ShowScheduleProcessor {

    private ShowScheduleProcessor() {

    }


    static void processScheduleIntent(LexRequest lexRequest, LexResponse lexResponse) {
        String response;
        Map<String, String> sessionAttributes = new HashMap<>();
        if (SHOW_TODAYS_SCHEDULE.equals(lexRequest.getIntentName())) {
            response = "Showing today's schedule";
            sessionAttributes.put("schedule", TODAY);
        }
        else if (SHOW_WEEK_SCHEDULE.equals(lexRequest.getIntentName())) {
            response = "Showing this week's schedule";
            sessionAttributes.put("schedule", WEEK);
        }
        else {
            response = "error: schedule intent malfunction";
        }
        Message message = new Message(PLAIN_TEXT, response);
        lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
        lexResponse.setSessionAttributes(sessionAttributes);
    }
}
