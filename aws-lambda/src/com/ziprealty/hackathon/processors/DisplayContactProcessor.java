package com.ziprealty.hackathon.processors;

import com.ziprealty.hackathon.lex.LexRequest;
import com.ziprealty.hackathon.lex.LexResponse;
import com.ziprealty.hackathon.lex.response.DialogAction;
import com.ziprealty.hackathon.pojo.Contact;

import java.util.Map;

import static com.ziprealty.hackathon.api.ResponseBuilder.getContactFromRequest;
import static com.ziprealty.hackathon.util.Constants.CLOSE;
import static com.ziprealty.hackathon.util.Constants.FULFILLED;
import static com.ziprealty.hackathon.util.SessionAttributeBuilder.createSessionAttributesFromContact;

/**
 * Created by jamgale on 7/16/17.
 */
class DisplayContactProcessor {

    private DisplayContactProcessor(){

    }

    static void processDisplayContact(LexRequest lexRequest, LexResponse lexResponse) {

        Contact contact = getContactFromRequest(lexRequest);
        Map<String, String> sessionAttributes = createSessionAttributesFromContact(lexResponse.getSessionAttributes(), contact);

        lexResponse.setDialogAction(new DialogAction(CLOSE, FULFILLED, null));
        lexResponse.setSessionAttributes(sessionAttributes);
    }
}
