package com.locations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HelsinkiInfo {
    private Data[] data;

    public HelsinkiInfo() {
    }

    public HelsinkiInfo(Data[] data) {
        this.data = data;
    }
    @JsonProperty("data")
    public Data[] getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(Data[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HelsinkiInfo{" +
                "data=" + getData() +
                '}';
    }
}
