package com.ziprealty.hackathon.Lex.MessageObject;

/**
 * Created by jamgale on 7/15/17.
 *
 * shares session attributes across conversations
 * say we load up Ben Burnside's profile page and say call a contact
 *
 * We can pass Ben's details and ask if you want to call him
 */
public class SessionAttributes {

    private String zipScore;
    private String lastContactDate;
    private String lrSourceName;
    private String clientType;
    private String medianHomePrice;
    private String clientId;
    private String contactRelationDescId;
    private String customerId;
    private String lastName;
    private String firstName;
    private String clientAgentId;

    public String getZipScore() {
        return zipScore;
    }

    public void setZipScore(String zipScore) {
        this.zipScore = zipScore;
    }

    public String getLastContactDate() {
        return lastContactDate;
    }

    public void setLastContactDate(String lastContactDate) {
        this.lastContactDate = lastContactDate;
    }

    public String getLrSourceName() {
        return lrSourceName;
    }

    public void setLrSourceName(String lrSourceName) {
        this.lrSourceName = lrSourceName;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getMedianHomePrice() {
        return medianHomePrice;
    }

    public void setMedianHomePrice(String medianHomePrice) {
        this.medianHomePrice = medianHomePrice;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getContactRelationDescId() {
        return contactRelationDescId;
    }

    public void setContactRelationDescId(String contactRelationDescId) {
        this.contactRelationDescId = contactRelationDescId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getClientAgentId() {
        return clientAgentId;
    }

    public void setClientAgentId(String clientAgentId) {
        this.clientAgentId = clientAgentId;
    }

}

