package com.ziprealty.hackathon;

import com.ziprealty.hackathon.Lex.LexRequest;
import com.ziprealty.hackathon.Lex.LexRequestFactory;
import com.ziprealty.hackathon.Lex.LexResponse;
import com.ziprealty.hackathon.Lex.MessageObjects.DialogAction;
import com.ziprealty.hackathon.Lex.MessageObjects.Message;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

/**
 * Created by jamgale on 7/14/17.
 */
public class TestLexLambda implements RequestHandler<Map<String, Object>, Object> {

    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {

        LexRequest lexRequest = LexRequestFactory.createLexRequest(input);

        // write the output message with hte lexRequest from here
        String content = String.format("Request came from Bot: %s, Intent: %s ", lexRequest.getBotName(), lexRequest.getIntentName());

        Message message = new Message("PlainText", content);
        DialogAction dialogAction = new DialogAction("Close", "Fulfilled", message);
        return new LexResponse(dialogAction);
    }

}
