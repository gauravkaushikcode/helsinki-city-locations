package com.locations.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Hours {
    private long weekdayID;
    private String opens;
    private String closes;
    private boolean open24H;

    public Hours() {
    }

    public Hours(long weekdayID, String opens, String closes, boolean open24H) {
        this.weekdayID = weekdayID;
        this.opens = opens;
        this.closes = closes;
        this.open24H = open24H;
    }

    @JsonProperty("weekday_id")
    public long getWeekdayID() { return weekdayID; }
    @JsonProperty("weekday_id")
    public void setWeekdayID(long value) { this.weekdayID = value; }

    @JsonProperty("opens")
    @JsonFormat(pattern = "HH:mm:ss")
    public String getOpens() {
        return opens; }
    @JsonProperty("opens")
    @JsonFormat(pattern = "HH:mm:ss")
    public void setOpens(String value) {
        this.opens = value; }

    @JsonProperty("closes")
    public String getCloses() {
        return closes; }

    @JsonProperty("closes")
    @JsonFormat(pattern = "HH:mm:ss")
    public void setCloses(String value){
                this.opens = value; }
    @JsonProperty("open24h")
    public boolean getOpen24H() { return open24H; }
    @JsonProperty("open24h")
    public void setOpen24H(boolean value) { this.open24H = value; }

    @Override
    public String toString() {
        return "Hours{" +
                "weekday=" + weekdayID +
                ", closes='" + closes + '\'' +
                '}';
    }
}
