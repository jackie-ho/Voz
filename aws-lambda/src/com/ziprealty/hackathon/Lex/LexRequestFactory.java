package com.ziprealty.hackathon.Lex;

import java.util.Map;

import static com.ziprealty.hackathon.util.Constants.DISPLAY_CONTACT_INTENT;
import static com.ziprealty.hackathon.util.Constants.INPUT_TRANSCRIPT;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexRequestFactory {

    public static LexRequest createLexRequest(Map<String, Object> input) {

        LexRequest lexRequest = new LexRequest();

        try {
            Map<String, Object> botMap = (Map<String, Object>) input.get("bot");
            String botName = (String) botMap.get("name");

            Map<String, Object> intentMap = (Map<String, Object>) input.get("currentIntent");
            String intentName = (String) intentMap.get("name");

            Map<String, Object> slots = (Map<String, Object>) intentMap.get("slots");
            String inputTranscript = (String) input.get(INPUT_TRANSCRIPT);

            // Set Request info

            lexRequest.setBotName(botName);
            lexRequest.setIntentName(intentName); // Set this to be specific to the intent -> like show content
            lexRequest.setSlots(slots);
            lexRequest.setInputTranscript(inputTranscript);

        }
        catch (Exception e) {
            lexRequest.setHasError(true);
            lexRequest.setErrorMessage(e.getMessage());
        }

        return lexRequest;
    }
}
