package com.ziprealty.hackathon.Lex;

import java.util.Map;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexRequest {
    private String botName;
    private String intentName;
    private Map<String, Object> slots;

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public String getBotName() {
        return botName;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setSlots(Map<String,Object> slots) {
        this.slots = slots;
    }

    public Map<String, Object> getSlots() {
        return slots;
    }
}
