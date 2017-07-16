package com.ziprealty.hackathon;

import com.ziprealty.hackathon.Lex.LexRequest;
import com.ziprealty.hackathon.Lex.LexRequestFactory;
import com.ziprealty.hackathon.Lex.LexResponse;
import com.ziprealty.hackathon.Lex.MessageObject.DialogAction;
import com.ziprealty.hackathon.Lex.MessageObject.Message;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ziprealty.hackathon.Lex.MessageObject.SessionAttributes;
import com.ziprealty.hackathon.POJO.Contact;
import com.ziprealty.hackathon.POJO.Event;
import com.ziprealty.hackathon.util.StringUtils;
import java.util.Map;

import static com.ziprealty.hackathon.Lex.ResponseBuilder.getContactFromRequest;
import static com.ziprealty.hackathon.Lex.ResponseBuilder.getNextEvent;
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
        SessionAttributes sessionAttributes = new SessionAttributes();

        Contact contact;

        if (DISPLAY_CONTACT_INTENT.equals(lexRequest.getIntentName())) {
            contact = getContactFromRequest(lexRequest);
            response = contact.getFirstName() + " " + contact.getLastName();
            sessionAttributes = createSessionAttributesFromContact(contact);
        }

        if (SHOW_TODAYS_SCHEDULE.equals(lexRequest.getIntentName()) || SHOW_WEEK_SCHEDULE.equals(lexRequest.getIntentName())) {
            response = lexRequest.getInputTranscript();
//            sessionAttributes.setInputTranscript(response);
        }
        if (NEXT_EVENT.equals(lexRequest.getIntentName())) {
            Event nextEvent = getNextEvent();
        }

        response = StringUtils.condenseResponse(response);

        Message message = new Message(PLAIN_TEXT, response);

        DialogAction dialogAction = new DialogAction(CLOSE, FULFILLED, message);
        return new LexResponse(dialogAction, sessionAttributes);
    }

    private SessionAttributes createSessionAttributesFromContact(Contact contact) {
        SessionAttributes sessionAttributes = new SessionAttributes();
        sessionAttributes.setFirstName(contact.getFirstName());
        sessionAttributes.setLastName(contact.getLastName());
        sessionAttributes.setCustomerId(Integer.toString(contact.getCustomerId()));
        return sessionAttributes;
    }
}
