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

    public static Map<String, String>  createSessionAttributesFromContact(Map<String, String> sessionAttributes, Contact contact, String i) {
        sessionAttributes.put(FIRST_NAME+i, contact.getFirstName());
        sessionAttributes.put(LAST_NAME+i, contact.getLastName());
        sessionAttributes.put("customer_id"+i, Integer.toString(contact.getCustomerId()));
        sessionAttributes.put("median_home_price"+i, contact.getMedianPrice());
        sessionAttributes.put("client_type"+i, contact.getClientType());
        sessionAttributes.put("telephone_number"+i, contact.getTelephone());
        sessionAttributes.put("email"+i, contact.getEmail());
        sessionAttributes.put("zip_score"+i, contact.getZapScore());

        return sessionAttributes;
    }
}

