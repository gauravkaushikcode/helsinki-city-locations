package com.locations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpeningHours {
    private Hours[] hours;
    private String openinghoursException;

    public OpeningHours() {
    }

    public OpeningHours(Hours[] hours, String openinghoursException) {
        this.hours = hours;
        this.openinghoursException = openinghoursException;
    }

    @JsonProperty("hours")
    public Hours[] getHours() { return hours; }
    @JsonProperty("hours")
    public void setHours(Hours[] value) { this.hours = value; }

    @JsonProperty("openinghours_exception")
    public String getOpeninghoursException() { return openinghoursException; }
    @JsonProperty("openinghours_exception")
    public void setOpeninghoursException(String value) { this.openinghoursException = value; }
    @Override
    public String toString() {
        return "OpeningHours{" +
                "Hours=" + hours +
                ", openinghoursException='" + openinghoursException + '\'' +
                '}';
    }
}
