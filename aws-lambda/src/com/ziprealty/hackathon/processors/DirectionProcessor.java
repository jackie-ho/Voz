package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.response.DialogAction;
import com.ziprealty.hackathon.lex.response.Message;

import java.util.Map;

import static com.ziprealty.hackathon.api.ResponseBuilder.getAddressFromRequest;
import static com.ziprealty.hackathon.util.Constants.CLOSE;
import static com.ziprealty.hackathon.util.Constants.FULFILLED;
import static com.ziprealty.hackathon.util.Constants.PLAIN_TEXT;

/**
 * Created by jamgale on 7/16/17.
 */
class DirectionProcessor {

    private DirectionProcessor() {
    }

    static void processDirections(LexRequest lexRequest, LexResponse lexResponse){

        String address = getAddressFromRequest(lexRequest);
        Map<String, String> sessionAttributes = lexResponse.getSessionAttributes();
        sessionAttributes.put("address", address);
        Message message = new Message(PLAIN_TEXT, "Getting directions to " + address);
        lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
        lexResponse.setSessionAttributes(sessionAttributes);

    }
}
