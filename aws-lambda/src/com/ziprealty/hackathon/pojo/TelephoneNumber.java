package com.ziprealty.hackathon.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jamgale on 7/16/17.
 */
public class TelephoneNumber {

    @JsonProperty("TELEPHONE_NUMBER")
    private String telephoneNumber;


    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
