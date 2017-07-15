package com.ziprealty.hackathon;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.ziprealty.hackathon.Lex.LexResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamgale on 7/14/17.
 *
 * Tests creating a Lambda request, mocking the input from a Lex conversation
 */
public class LexLambdaHandlerTest {

    private Context testContext;
    private Map<String, Object> input;
    private Map<String, Object> botMap;
    private Map<String, Object> currentIntent;
    private Map<String, Object> slots;

    private LexLambdaHandler testLambdaHandler;

    @Before
    public void setUp(){
        testContext = getContext();

        testLambdaHandler = new LexLambdaHandler();

        input           = new HashMap<>();
        botMap          = new HashMap<>();
        currentIntent   = new HashMap<>();
        slots           = new HashMap<>();

        botMap.put("alias", "testRequestBot");
        botMap.put("name", "TestBotVoz");
    }

    @Test
    public void testRequestReturnsBenBurnsidesPersonnelData() {


        currentIntent.put("name", "TestGetString");
        slots.put("dessert", "Creme Brulee");
        currentIntent.put("slots", slots);

        input.put("bot", botMap);
        input.put("currentIntent", currentIntent);


        LexResponse lexResponse = testLambdaHandler.handleRequest(input, testContext);
        String jsonResponse = lexResponse.getDialogAction().getMessage().getContent();
        System.out.println(jsonResponse);
        Assert.assertTrue(jsonResponse.contains("185667"));

    }

    @Test
    public void testDisplayContactWithBenBurnside_displaysBenBurnsidePersonnelData() {

        currentIntent.put("name", "DisplayContact");
        slots.put("FullName", "Ben Burnside");
        currentIntent.put("slots", slots);

        input.put("bot", botMap);
        input.put("currentIntent", currentIntent);

        LexResponse lexResponse = testLambdaHandler.handleRequest(input, testContext);
        String jsonResponse = lexResponse.getDialogAction().getMessage().getContent();
        System.out.println(jsonResponse);
        Assert.assertTrue(jsonResponse.contains("Ben"));

    }

    private Context getContext() {
        Context context = new Context() {
            @Override
            public String getAwsRequestId() {
                return "120304";
            }

            @Override
            public String getLogGroupName() {
                return null;
            }

            @Override
            public String getLogStreamName() {
                return null;
            }

            @Override
            public String getFunctionName() {
                return "LexLambdaHandler";
            }

            @Override
            public String getFunctionVersion() {
                return "$LATEST";
            }

            @Override
            public String getInvokedFunctionArn() {
                return null;
            }

            @Override
            public CognitoIdentity getIdentity() {
                return null;
            }

            @Override
            public ClientContext getClientContext() {
                return null;
            }

            @Override
            public int getRemainingTimeInMillis() {
                return 0;
            }

            @Override
            public int getMemoryLimitInMB() {
                return 0;
            }

            @Override
            public LambdaLogger getLogger() {
                return null;
            }
        };
        return context;
    }
}
