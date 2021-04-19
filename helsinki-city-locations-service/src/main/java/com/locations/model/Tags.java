package com.locations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tags {
    private String id;
    private String name;

    public Tags() {
    }

    public Tags(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

}
