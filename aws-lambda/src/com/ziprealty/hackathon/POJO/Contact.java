package com.ziprealty.hackathon.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jamgale on 7/15/17.
 */
public class Contact {

    @JsonProperty("CUSTOMER_ID")
    private int customerId;

    @JsonProperty("FIRST_NAME")
    private String firstName;


    @JsonProperty("LAST_NAME")
    private String lastName;

    @JsonProperty("ZIP_SCORE")
    private String zapScore;

    @JsonProperty("LOGIN")
    private String email;

    @JsonProperty("TELEPHONE_NUMBER")
    private String telephone;

    @JsonProperty("CLIENT_TYPE")
    private String clientType;

    @JsonProperty("MEDIAN_HOME_PRICE")
    private String medianPrice;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZapScore() {
        return zapScore;
    }

    public void setZapScore(String zapScore) {
        this.zapScore = zapScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        switch (clientType) {
            case "1":
                this.clientType = "Buyer";
                break;
            case "2":
                this.clientType = "Seller";
                break;
            case "3":
                this.clientType = "Buyer & Seller";
                break;
            case "4":
                this.clientType = "Renter";
                break;
            default:
                this.clientType = "UNKNOWN";
        }
    }

    public String getMedianPrice() {
        return medianPrice;
    }

    public void setMedianPrice(String medianPrice) {
        this.medianPrice = medianPrice;
    }

}
