package com.ziprealty.hackathon.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jamgale on 7/16/17.
 */
public class Address {

    @JsonProperty("STREET_ADDRESS")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
