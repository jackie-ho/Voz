package com.ziprealty.hackathon;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;

import java.util.Scanner;

import static org.apache.http.util.TextUtils.isEmpty;

/**
 * Created by jamgale on 7/14/17.
 */
public class TestLexRequestClass {

    private static final java.lang.String ELICIT = "Elicit";
    private static final String READY_FOR_FULFILLMENT = "ReadyForFulfillment";

    static public void main(String[] args) {
        AmazonLexRuntime client = AmazonLexRuntimeClientBuilder.standard().withRegion(Regions.US_EAST_1).build();

        PostTextRequest textRequest = new PostTextRequest();
        // Set Params
        textRequest.setBotAlias("testRequestBot");
        textRequest.setBotName("TestBotVoz");
        textRequest.setUserId("testuser");
        textRequest.setInputText("ask me a question");

        Scanner sc = new Scanner(System.in);
        while(true) {
            String requestText = sc.nextLine().trim();
            if(isEmpty(requestText)) {
                break;
            }
            textRequest.setInputText(requestText);
            PostTextResult textResult = client.postText(textRequest);
            if(textResult.getDialogState().startsWith(ELICIT)) {
                System.out.println(textResult.getMessage());
            }
            else if (textResult.getDialogState().equals(READY_FOR_FULFILLMENT)) {
                System.out.println(String.format("%s, %s", textResult.getIntentName(), textResult.getSlots()));
            }
            else {
                System.out.println(textResult.toString());
            }
        }
        System.out.println("Finished, bye");

    }
}
