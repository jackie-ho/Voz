package com.ziprealty.hackathon.util;

import com.ziprealty.hackathon.lex.messageObject.SessionAttributes;
import com.ziprealty.hackathon.pojo.Contact;

/**
 * Created by jamgale on 7/16/17.
 */
public class SessionAttributeBuilder {

    public static SessionAttributes createSessionAttributesFromContact(Contact contact) {
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

