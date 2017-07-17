package com.ziprealty.hackathon.lex;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.ziprealty.hackathon.lex.ContextSpoofer.spoofContext;
import static com.ziprealty.hackathon.util.Constants.*;

/**
 * Created by jamgale on 7/14/17.
 *
 * Tests creating a Lambda request, mocking the input from a Lex conversation
 */
public class LexLambdaHandlerTest {

    private static final String TEST_TELEPHONE_NUMBER = "(415) 419-7189";
    private Context testContext;
    private Map<String, Object> input;
    private Map<String, Object> botMap;
    private Map<String, Object> currentIntent;
    private Map<String, Object> slots;
    private Map<String, String> sessionAttributes = new HashMap<>();

    private LexLambdaHandler testLambdaHandler;

    @Before
    public void setUp(){
        testContext = spoofContext();

        testLambdaHandler = new LexLambdaHandler();

        input           = new HashMap<>();
        botMap          = new HashMap<>();
        currentIntent   = new HashMap<>();
        slots           = new HashMap<>();

        botMap.put("alias", "testRequestBot");
        botMap.put("name", "TestBotVoz");
    }


    @Test
    public void testDisplayContactWithMichelle_displaysMichellesData() {

        currentIntent.put("name", "DisplayContact");
        slots.put("FullName", "Michelle Martinez");
        currentIntent.put("slots", slots);

        input.put("bot", botMap);
        input.put("currentIntent", currentIntent);

        LexResponse lexResponse = testLambdaHandler.handleRequest(input, testContext);
        Map<String, String> sessionAttributes = lexResponse.getSessionAttributes();
        Assert.assertEquals(sessionAttributes.get("first_name"), "Michelle");
    }

    @Test
    public void testShowTodaysSchedule_returnsTranscript() {

        currentIntent.put("name", SHOW_TODAYS_SCHEDULE);
        input.put("bot", botMap);
        input.put("currentIntent", currentIntent);
        input.put("inputTranscript", "This is the transcript");

        LexResponse lexResponse = testLambdaHandler.handleRequest(input, testContext);
        String jsonResponse = lexResponse.getDialogAction().getMessage().getContent();
        System.out.println(jsonResponse);
        Assert.assertTrue(lexResponse.getSessionAttribute("schedule").equals(TODAY));
    }

    @Test
    public void testIllicitMoreInfoWhenToldCallAContact() {
        currentIntent.put("name", CALL_CONTACT);
        input.put("bot", botMap);
        input.put("currentIntent", currentIntent);
        input.put("inputTranscript", "Call a contact");
    }

    @Test
    public void testGetPhoneNumberWhenCallingAContact() {
        currentIntent.put("name", CALL_CONTACT);

        slots.put("FullName", "Michelle Martinez");
        currentIntent.put("slots", slots);
        input.put("bot", botMap);
        input.put("currentIntent", currentIntent);
        input.put("inputTranscript", "Call a contact");
        input.put(SESSION_ATTRIBUTES, sessionAttributes);


        input.put(INVOCATION_SOURCE, FULFILLMENT_CODE_HOOK);

        LexResponse lexResponse = testLambdaHandler.handleRequest(input, testContext);
        Assert.assertEquals(lexResponse.getSessionAttribute("telephone_number"), TEST_TELEPHONE_NUMBER);

    }

}
