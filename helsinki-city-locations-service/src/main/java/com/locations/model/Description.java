package com.locations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class Description {
    private Object intro;
    private String body;
    private Image[] image;

    public Description() {
    }

    public Description(Object intro, String body, Image[] image) {
        this.intro = intro;
        this.body = body;
        this.image = image;
    }

    @JsonProperty("intro")
    public Object getIntro() { return intro; }
    @JsonProperty("intro")
    public void setIntro(Object value) { this.intro = value; }

    @JsonProperty("body")
    public String getBody() { return body; }
    @JsonProperty("body")
    public void setBody(String value) { this.body = value; }

    @JsonProperty("images")
    public Image[] getImages() { return image; }
    @JsonProperty("images")
    public void setImages(Image[] value) { this.image = value; }
}
