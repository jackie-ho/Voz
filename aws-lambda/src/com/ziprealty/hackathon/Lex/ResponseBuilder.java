package com.ziprealty.hackathon.Lex;

import com.ziprealty.hackathon.Jackson.JSONParser;
import com.ziprealty.hackathon.Lex.MessageObject.SQLResponse;
import com.ziprealty.hackathon.POJO.Personnel;
import com.ziprealty.hackathon.zap.ApiRequestFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by jamgale on 7/15/17.
 */
public class ResponseBuilder {

    public static String buildResponseForDisplayContact(LexRequest lexRequest) {

        String response;
        String sql;
        SQLResponse sqlResponse;


        ApiRequestFactory apiRequest = new ApiRequestFactory();

        String fullName = (String) lexRequest.getSlots().get("FullName");

        // currently any more than firstname lastname names are not supported
        String firstName = fullName.split("\\s+")[0];
        String lastName = fullName.split("\\s+")[1];

        sql = "SELECT * FROM personnel WHERE LOWER(first_name) = LOWER('" + firstName + "') " +
                "AND LOWER(last_name) = LOWER('" + lastName + "') ";

        sqlResponse = apiRequest.sendGet(sql, "1", "10");
        // if we get more than one item in the list, we should throw an error or ask to specify which person he means, by the email address perhaps

        try {
            if (sqlResponse.getResponseCode() == 500) {
                response = "Error 500: " + sqlResponse.getMessage();
            } else {
                List<Personnel> personnelResponseList = JSONParser.parseJSONToPersonnel(sqlResponse.getMessage());
                if (personnelResponseList.isEmpty()) {
                    response = "No personnel found by that name";
                } else {
                    Personnel personnel = personnelResponseList.get(0);
                    response = String.format("You have searched for the contact page of: %s %s, ID: %s",
                            personnel.getFirstName(),
                            personnel.getLastName(),
                            personnel.getPersonnelId());
                }
            }
        }
        catch (IOException e) {
            response = e.getMessage();
        }
        return response;
    }

}
