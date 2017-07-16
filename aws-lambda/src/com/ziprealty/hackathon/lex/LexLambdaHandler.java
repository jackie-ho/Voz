package com.ziprealty.hackathon.lex;

import com.ziprealty.hackathon.lex.messageObject.DialogAction;
import com.ziprealty.hackathon.lex.messageObject.Message;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ziprealty.hackathon.lex.messageObject.SessionAttributes;
import com.ziprealty.hackathon.pojo.Contact;
import com.ziprealty.hackathon.pojo.Event;
import com.ziprealty.hackathon.processors.Processor;

import java.util.HashMap;
import java.util.Map;

import static com.ziprealty.hackathon.lex.ResponseBuilder.getContactFromRequest;
import static com.ziprealty.hackathon.lex.ResponseBuilder.getNextEventFromRequest;
import static com.ziprealty.hackathon.lex.ResponseBuilder.getPhoneNumberFromRequest;
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

        Processor processor = new Processor();
        LexResponse lexResponse = processor.processIntent(lexRequest);

        return lexResponse;
    }
}



