package com.ziprealty.hackathon.util;

import com.ziprealty.hackathon.pojo.Contact;

import java.util.HashMap;
import java.util.Map;

import static com.ziprealty.hackathon.util.Constants.FIRST_NAME;
import static com.ziprealty.hackathon.util.Constants.LAST_NAME;

/**
 * Created by jamgale on 7/16/17.
 */
public class SessionAttributeBuilder {

    private SessionAttributeBuilder() {
    }

    public static Map<String, String>  createSessionAttributesFromContact(Map<String, String> sessionAttributes, Contact contact) {
        sessionAttributes.put(FIRST_NAME, contact.getFirstName());
        sessionAttributes.put(LAST_NAME, contact.getLastName());
        sessionAttributes.put("customer_id", Integer.toString(contact.getCustomerId()));
        sessionAttributes.put("median_home_price", contact.getMedianPrice());
        sessionAttributes.put("client_type", contact.getClientType());
        sessionAttributes.put("telephone_number", contact.getTelephone());
        sessionAttributes.put("email", contact.getEmail());
        sessionAttributes.put("zip_score", contact.getZapScore());

        return sessionAttributes;
    }
}

