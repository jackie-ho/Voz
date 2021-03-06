package com.ziprealty.hackathon.lex;

import java.util.Map;

import static com.ziprealty.hackathon.util.Constants.*;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexRequestFactory {

    public static LexRequest createLexRequest(Map<String, Object> input) {

        LexRequest lexRequest = new LexRequest();

        try {
            Map<String, Object> botMap = (Map<String, Object>) input.get("bot");
            String botName = (String) botMap.get("name");

            Map<String, Object> intentMap = (Map<String, Object>) input.get(CURRENT_INTENT);
            String intentName = (String) intentMap.get("name");

            Map<String, Object> slots = (Map<String, Object>) intentMap.get("slots");
            String inputTranscript = (String) input.get(INPUT_TRANSCRIPT);

            String invocationSource = (String) input.get(INVOCATION_SOURCE);

            Map<String, String> sessionAttributes = (Map<String, String>) input.get(SESSION_ATTRIBUTES);

            String confirmationStatus = (String) input.get(CONFIRMATION_STATUS);

            // Set Request info

            lexRequest.setBotName(botName);
            lexRequest.setIntentName(intentName); // Set this to be specific to the intent -> like show content
            lexRequest.setSlots(slots);
            lexRequest.setInputTranscript(inputTranscript);
            lexRequest.setInvocationSource(invocationSource);
            lexRequest.setSessionAttributes(sessionAttributes);
            lexRequest.setConfirmationStatus(confirmationStatus);

        }
        catch (Exception e) {
            lexRequest.setHasError(true);
            lexRequest.setErrorMessage(e.getMessage());
        }

        return lexRequest;
    }
}
