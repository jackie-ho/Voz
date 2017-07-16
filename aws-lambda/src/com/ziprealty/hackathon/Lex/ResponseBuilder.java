package com.ziprealty.hackathon.lex;

import com.ziprealty.hackathon.jackson.JSONParser;
import com.ziprealty.hackathon.lex.messageObject.SQLResponse;
import com.ziprealty.hackathon.pojo.Contact;
import com.ziprealty.hackathon.pojo.Event;
import com.ziprealty.hackathon.pojo.TelephoneNumber;
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
        String firstName = extractFirstName(lexRequest);
        String lastName = extractSurname(lexRequest);



        ApiRequestFactory apiRequest = new ApiRequestFactory();

        sql = "SELECT c.first_name, c.last_name, " +
                "CASE '(' || tn.area_code || ')' || tn.prefix || '-' || tn.suffix " +
                "WHEN '()-' then null " +
                "ELSE '(' || tn.area_code || ')' || tn.prefix || '-' || tn.suffix " +
                "END as TELEPHONE_NUMBER,  " +
                "cl.zip_score, c.login, c.customer_id, cl.median_home_price, ca.client_type " +
                "FROM Customer c " +
                "JOIN client cl on cl.customer_id = c.customer_id " +
                "LEFT JOIN telephone_number tn on c.customer_id = tn.customer_id AND tn.is_active = 1 AND tn.is_primary = 1 " +
                "JOIN client_agent ca on ca.customer_id = c.customer_id " +
                "WHERE LOWER(c.first_name) = LOWER('" + firstName + "') " +
                "AND LOWER(c.last_name) = LOWER('" + lastName + "') " +
                "AND ca.agent_id = 251610 ";

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

    private static String extractSurname(LexRequest lexRequest) {
        String fullName = (String) lexRequest.getSlots().get("FullName");
        // if there are three names returned, hyphenate the last two
        String[] names = fullName.split(("\\s+"));

        if (names.length == 2) {
            return names[1];
        } else if (names.length == 3) {
            return names[1] + "-" + names[2];
        }
        return "NA";
    }

    private static String extractFirstName(LexRequest lexRequest) {
        String fullName = (String) lexRequest.getSlots().get("FullName");

        // if there are three names returned, hyphenate the last two
        String[] names = fullName.split(("\\s+"));
        return names[0];
    }

    public static Event getNextEventFromRequest(LexRequest lexRequest) {
        Event nextEvent = new Event();

        
        return nextEvent;
    }

    public static String getPhoneNumberFromRequest(LexRequest lexRequest) {
        String firstName = extractFirstName(lexRequest);
        String lastName = extractSurname(lexRequest);

        ApiRequestFactory apiRequestFactory = new ApiRequestFactory();

        String sql = String.format("SELECT " +
                     "CASE '(' || tn.area_code || ')' || tn.prefix || '-' || tn.suffix " +
                     "WHEN '()-' then null " +
                     "ELSE '(' || tn.area_code || ')' || tn.prefix || '-' || tn.suffix " +
                     "END as TELEPHONE_NUMBER " +
                     "from telephone_number tn " +
                     "join customer c on c.customer_id = tn.customer_id " +
                     "where lower(c.first_name) = lower('%s') AND lower(c.last_name) = lower('%s')", firstName, lastName);

        SQLResponse sqlResponse = apiRequestFactory.sendGet(sql, "1", "10");

        try {
            List<TelephoneNumber> telephoneNumbers = JSONParser.parseJSONToTelephoneNumber(sqlResponse.getMessage());
            if (telephoneNumbers.isEmpty()) {
                return null;
            } else {
                return telephoneNumbers.get(0).getTelephoneNumber();
            }
        }
        catch (IOException e) {
            return "";
        }
    }



}
