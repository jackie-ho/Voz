package com.ziprealty.hackathon;

import com.ziprealty.hackathon.Lex.LexRequest;
import com.ziprealty.hackathon.Lex.LexRequestFactory;
import com.ziprealty.hackathon.Lex.LexResponse;
import com.ziprealty.hackathon.Lex.MessageObject.DialogAction;
import com.ziprealty.hackathon.Lex.MessageObject.Message;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ziprealty.hackathon.zap.ApiRequestFactory;

import java.util.Map;

import static com.ziprealty.hackathon.Lex.Constants.CLOSE;
import static com.ziprealty.hackathon.Lex.Constants.FULFILLED;
import static com.ziprealty.hackathon.Lex.Constants.PLAIN_TEXT;

/**
 * Created by jamgale on 7/14/17.
 *
 * Handles a request from Lex, we receive the input of the form https://github.com/jackie-ho/Voz/wiki/AWS-Lambda-Templates
 * The JSON is handled in Map format key value pairs
 *
 * From the input we can receive which bot is making the request, the intent, and the slots
 * Using this information we can decide what business logic we want to run, and with which parameters
 */
public class LexLambdaHandler implements RequestHandler<Map<String, Object>, Object> {

    @Override
    public LexResponse handleRequest(Map<String, Object> input, Context context) {

        LexRequest lexRequest = LexRequestFactory.createLexRequest(input);
        ApiRequestFactory apiRequest = new ApiRequestFactory();

        String sql = "SELECT * FROM personnel WHERE personnel_id = 185667";

        // write the output message with hte lexRequest from here
        //String content = String.format("Request came from Bot: %s, Intent: %s ", lexRequest.getBotName(), lexRequest.getIntentName());
        String sqlResponse = "";

        if("TestGetString".equals(lexRequest.getIntentName())) {
            sqlResponse = apiRequest.sendGet(sql, "1", "10");
        }

        Message message = new Message(PLAIN_TEXT, sqlResponse);
        DialogAction dialogAction = new DialogAction(CLOSE, FULFILLED, message);
        return new LexResponse(dialogAction);
    }

}