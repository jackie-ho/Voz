package com.ziprealty.hackathon.Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.ziprealty.hackathon.POJO.Personnel;

import java.io.IOException;
import java.util.List;

/**
 * Created by jamgale on 7/15/17.
 */
public class JSONParser {

    public static List<Personnel> parseJSONToPersonnel(String jsonString) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();

        return objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, Personnel.class));
    }
}
