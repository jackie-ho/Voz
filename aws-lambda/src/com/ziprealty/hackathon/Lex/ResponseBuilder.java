package com.ziprealty.hackathon.Lex;

import com.ziprealty.hackathon.Jackson.JSONParser;
import com.ziprealty.hackathon.Lex.MessageObject.SQLResponse;
import com.ziprealty.hackathon.POJO.Contact;
import com.ziprealty.hackathon.POJO.Event;
import com.ziprealty.hackathon.zap.ApiRequestFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by jamgale on 7/15/17.
 */
public class ResponseBuilder {

    public static Contact getContactFromRequest(LexRequest lexRequest) {

        Contact contact;
        String sql;
        SQLResponse sqlResponse;
        String firstName;
        String lastName;

        ApiRequestFactory apiRequest = new ApiRequestFactory();

        String fullName = (String) lexRequest.getSlots().get("FullName");

        // if there are three names returned, hyphenate the last two
        String[] names = fullName.split(("\\s+"));
        if (names.length == 2) {
            firstName = names[0];
            lastName  = names[1];
        }
        else if (names.length == 3) {
            firstName = names[0];
            lastName = names[1] + "-" + names[2];
        }
        else{
            firstName = "NA";
            lastName  = "NA";
        }

        sql = "SELECT c.first_name, c.last_name, '(' || tn.area_code || ')' || tn.prefix || '-' || tn.suffix as TELEPHONE_NUMBER, cl.zip_score, c.login, c.customer_id FROM Customer c " +
                "JOIN client cl on cl.customer_id = c.customer_id " +
                "LEFT JOIN telephone_number tn on c.customer_id = tn.customer_id " +
                "JOIN client_agent ca on ca.customer_id = c.customer_id " +
                "WHERE LOWER(c.first_name) = LOWER('" + firstName + "') " +
                "AND LOWER(c.last_name) = LOWER('" + lastName + "') " +
                "AND ca.agent_id = 251610";

        sqlResponse = apiRequest.sendGet(sql, "1", "10");
        // if we get more than one item in the list, we should throw an error or ask to specify which person they mean, by the email address perhaps

        try {
            List<Contact> contactResponseList = JSONParser.parseJSONToContact(sqlResponse.getMessage());
            if (contactResponseList.isEmpty()) {
                return new Contact();
            } else {
                contact = contactResponseList.get(0);
            }

        }
        catch (IOException e) {
            return new Contact();
        }
        return contact;
    }

    public static Event getNextEvent() {
        Event nextEvent = new Event();


        return nextEvent;
    }



}
