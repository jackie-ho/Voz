package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.response.DialogAction;
import com.ziprealty.hackathon.lex.response.Message;
import com.ziprealty.hackathon.pojo.Contact;

import java.util.List;
import java.util.Map;

import static com.ziprealty.hackathon.api.ResponseBuilder.getContacts;
import static com.ziprealty.hackathon.util.Constants.CLOSE;
import static com.ziprealty.hackathon.util.Constants.FULFILLED;
import static com.ziprealty.hackathon.util.Constants.PLAIN_TEXT;
import static com.ziprealty.hackathon.util.SessionAttributeBuilder.createSessionAttributesFromContact;

/**
 * Created by jamgale on 7/16/17.
 */
public class ContactPageProcessor {

    private ContactPageProcessor(){
    }

    public static void processContactPage(LexRequest lexRequest, LexResponse lexResponse) {

        List<Contact> contactList = getContacts();
        Map<String, String> sessionAttributes = lexResponse.getSessionAttributes();
        for (int i = 0; i < contactList.size(); i++) {
            sessionAttributes = createSessionAttributesFromContact(sessionAttributes, contactList.get(i), Integer.toString(i));
        }
        Message message = new Message(PLAIN_TEXT, "Showing contact page");
        lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, message));
        lexResponse.setSessionAttributes(sessionAttributes);

    }
}
