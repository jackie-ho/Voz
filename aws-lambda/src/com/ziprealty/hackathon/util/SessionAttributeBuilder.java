package com.ziprealty.hackathon.util;

import com.ziprealty.hackathon.pojo.Contact;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamgale on 7/16/17.
 */
public class SessionAttributeBuilder {

    private SessionAttributeBuilder() {
    }

    public static Map<String, String>  createSessionAttributesFromContact(Contact contact) {
        Map<String, String> sessionAttributes = new HashMap<>();
        sessionAttributes.put("first_name", contact.getFirstName());
        sessionAttributes.put("last_name", contact.getLastName());
        sessionAttributes.put("customer_id", Integer.toString(contact.getCustomerId()));
        sessionAttributes.put("median_home_price", contact.getMedianPrice());
        sessionAttributes.put("client_type", contact.getClientType());
        sessionAttributes.put("telephone_number", contact.getTelephone());
        sessionAttributes.put("email", contact.getEmail());
        sessionAttributes.put("zip_score", contact.getZapScore());

        return sessionAttributes;
    }
}

