package com.locations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EType {
    private long id;
    private String name;

    public EType() {
    }

    public EType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }
}
