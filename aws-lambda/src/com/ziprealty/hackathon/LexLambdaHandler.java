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

            Message message;
            DialogAction dialogAction = new DialogAction(null, null, null);

            Contact contact;

        try {
            switch (lexRequest.getIntentName()) {
                case DISPLAY_CONTACT_INTENT:
                    contact = getContactFromRequest(lexRequest);
                    response = "Showing the contact page for " + contact.getFirstName() + " " + contact.getLastName() + ".";
                    sessionAttributes = createSessionAttributesFromContact(contact);
                    message = new Message(PLAIN_TEXT, response);
                    dialogAction = new DialogAction(CLOSE, FULFILLED, message);
                    break;
                case SHOW_TODAYS_SCHEDULE:
                    response = "Showing today's schedule";
                    sessionAttributes.setInputTranscript(response);
                    sessionAttributes.setSchedule(TODAY);
                    message = new Message(PLAIN_TEXT, response);
                    dialogAction = new DialogAction(CLOSE, FULFILLED, message);
                    break;
                case SHOW_WEEK_SCHEDULE:
                    response = "Showing this week's schedule";
                    sessionAttributes.setInputTranscript(response);
                    sessionAttributes.setSchedule(WEEK);
                    message = new Message(PLAIN_TEXT, response);
                    dialogAction = new DialogAction(CLOSE, FULFILLED, message);
                    break;
                case NEXT_EVENT:
                    Event nextEvent = getNextEvent(lexRequest);
//                sessionAttributes = createSessionAttributesFromNextEvent(nextEvent);
                    break;
                case CALL_CONTACT:
                    // would you like to call 'contact saved from view contact'
                    if (DIALOG_CODE_HOOK.equals(lexRequest.getInvocationSource())) {
                        // Try both DELEGATE and ElicitSlot
                        if (sessionAttributes.getFirstName() != null) {
                            message = new Message(PLAIN_TEXT, "Would you like to call " + sessionAttributes.getFirstName() + " " + sessionAttributes.getLastName() + "?");
                            dialogAction = new DialogAction(CONFIRM_INTENT, null, message);
                        } else {
                            message = new Message(PLAIN_TEXT, "Who would you like to call?");
                            dialogAction = new DialogAction(ELICIT_SLOT, null, message);
                            dialogAction.setSlotToElicit("FullName");
                        }
                    } else {
//                        message = new Message(PLAIN_TEXT, lexRequest.getInvocationSource());
                        message = new Message(PLAIN_TEXT, "IM HERE and invocation source is  " + lexRequest.getInvocationSource());
                        contact = getContactFromRequest(lexRequest);
                        sessionAttributes = createSessionAttributesFromContact(contact);
                        dialogAction = new DialogAction(CLOSE, FULFILLED, message);
                    }
                    break;
                case DIRECTIONS:
                    // use nextEvent to ask about directions to the next event
                    break;
                default:
                    message = new Message(PLAIN_TEXT, "Intent not recognised");
                    dialogAction = new DialogAction(CLOSE, FULFILLED, message);

            }
        }
        catch (Exception e) {
            message = new Message(PLAIN_TEXT, "IM at a different spot and HERE and invocation source is  " + lexRequest.getInvocationSource());
            dialogAction = new DialogAction(CLOSE, FULFILLED, message);
            sessionAttributes = new SessionAttributes();
        }

        return new LexResponse(dialogAction, sessionAttributes);
    }

    private SessionAttributes createSessionAttributesFromContact(Contact contact) {
        SessionAttributes sessionAttributes = new SessionAttributes();
        sessionAttributes.setFirstName(contact.getFirstName());
        sessionAttributes.setLastName(contact.getLastName());
        sessionAttributes.setCustomerId(Integer.toString(contact.getCustomerId()));
        sessionAttributes.setMedianHomePrice(contact.getMedianPrice());
        sessionAttributes.setClientType(contact.getClientType());
        sessionAttributes.setTelephoneNumber(contact.getTelephone());
        sessionAttributes.setEmail(contact.getEmail());
        sessionAttributes.setZipScore(contact.getZapScore());
        return sessionAttributes;
    }
}
