package com.ziprealty.hackathon;

import com.ziprealty.hackathon.Jackson.JSONParser;
import com.ziprealty.hackathon.Lex.LexRequest;
import com.ziprealty.hackathon.Lex.LexRequestFactory;
import com.ziprealty.hackathon.Lex.LexResponse;
import com.ziprealty.hackathon.Lex.MessageObject.DialogAction;
import com.ziprealty.hackathon.Lex.MessageObject.Message;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ziprealty.hackathon.Lex.MessageObject.SQLResponse;
import com.ziprealty.hackathon.POJO.Personnel;
import com.ziprealty.hackathon.util.StringUtils;
import com.ziprealty.hackathon.zap.ApiRequestFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.ziprealty.hackathon.Lex.ResponseBuilder.buildResponseForDisplayContact;
import static com.ziprealty.hackathon.util.Constants.*;

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
        String response = "NO RESPONSE SET";

        if (DISPLAY_CONTACT_INTENT.equals(lexRequest.getIntentName())) {
            response = buildResponseForDisplayContact(lexRequest);
        }
        response = StringUtils.condenseResponse(response);

        Message message = new Message(PLAIN_TEXT, response);
        DialogAction dialogAction = new DialogAction(CLOSE, FULFILLED, message);
        return new LexResponse(dialogAction);
    }




}
