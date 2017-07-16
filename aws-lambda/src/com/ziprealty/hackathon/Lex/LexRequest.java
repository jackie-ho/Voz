package com.ziprealty.hackathon.lex;

import java.util.Map;

/**
 * Created by jamgale on 7/14/17.
 */
public class LexRequest {
    private String botName;
    private String intentName;
    private Map<String, Object> slots;
    private boolean hasError;
    private String errorMessage;
    private String inputTranscript;
    private String invocationSource;

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

    public boolean hasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getInputTranscript() {
        return inputTranscript;
    }

    public void setInputTranscript(String inputTranscript) {
        this.inputTranscript = inputTranscript;
    }

    public String getInvocationSource() {
        return invocationSource;
    }

    public void setInvocationSource(String invocationSource) {
        this.invocationSource = invocationSource;
    }
}
