package com.ziprealty.hackathon.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jamgale on 7/15/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Personnel implements Serializable {

    @JsonProperty("PERSONNEL_ID")
    private int personnelId;

    @JsonProperty("FIRST_NAME")
    private String firstName;


    @JsonProperty("LAST_NAME")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(int personnelId) {
        this.personnelId = personnelId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
