package com.ziprealty.hackathon;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.ziprealty.hackathon.Lex.LexResponse;
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


    @Test
    public void testRequestSucceeds() {



        Context testContext = getContext();

        Map<String, Object> input           = new HashMap<>();
        Map<String, Object> botMap          = new HashMap<>();
        Map<String, Object> currentIntent   = new HashMap<>();
        Map<String, Object> slots           = new HashMap<>();


        botMap.put("alias", "testRequestBot");
        botMap.put("name", "TestBotVoz");

        currentIntent.put("name", "TestGetString");
        slots.put("dessert", "Creme Brulee");
        currentIntent.put("slots", slots);

        input.put("bot", botMap);
        input.put("currentIntent", currentIntent);

        LexLambdaHandler testLambdaHandler = new LexLambdaHandler();

        LexResponse lexResponse = testLambdaHandler.handleRequest(input, testContext);
        System.out.println(lexResponse.getDialogAction().getMessage().getContent());

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
