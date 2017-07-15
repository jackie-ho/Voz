package com.ziprealty.hackathon.Lex;

import java.util.Map;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexRequestFactory {

    public static LexRequest createLexRequest(Map<String, Object> input) {
        Map<String, Object> botMap = (Map<String, Object>) input.get("bot");
        String botName = (String) botMap.get("name");
        Map<String, Object> intentMap = (Map<String, Object>) input.get("currentIntent");
        String intentName = (String) intentMap.get("name");

        Map<String, Object> slots = (Map<String, Object>) intentMap.get("slots");

        // Set Request info

        LexRequest lexRequest = new LexRequest();
        lexRequest.setBotName(botName);
        lexRequest.setIntentName(intentName); // Set this to be specific to the intent -> like show content
        lexRequest.setSlots(slots);
        // use if/else to write different slots depending on the intent


        return lexRequest;
    }
}
