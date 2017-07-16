package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.messageObject.DialogAction;
import com.ziprealty.hackathon.lex.messageObject.Message;
import com.ziprealty.hackathon.lex.messageObject.SessionAttributes;
import com.ziprealty.hackathon.pojo.Contact;

import static com.ziprealty.hackathon.lex.ResponseBuilder.getContactFromRequest;
import static com.ziprealty.hackathon.util.Constants.CLOSE;
import static com.ziprealty.hackathon.util.Constants.FULFILLED;
import static com.ziprealty.hackathon.util.Constants.PLAIN_TEXT;
import static com.ziprealty.hackathon.util.SessionAttributeBuilder.createSessionAttributesFromContact;

/**
 * Created by jamgale on 7/16/17.
 */
public class DisplayContactProcessor {

    public static void processDisplayContact(LexRequest lexRequest, LexResponse lexResponse) {

        Contact contact = getContactFromRequest(lexRequest);
        String  response = "Showing the contact page for " + contact.getFirstName() + " " + contact.getLastName() + ".";
        Message message = new Message(PLAIN_TEXT, response);
        SessionAttributes sessionAttributes = createSessionAttributesFromContact(contact);

        lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
        lexResponse.setSessionAttributes(sessionAttributes);
    }
}
