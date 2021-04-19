package com.locations.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
@JsonFilter("DataFilter")
public class Data {

    private String id;
    private Name name;
    private EType sourceType;
    private String infoURL;
    private OffsetDateTime modifiedAt;
    private LocationInfo location;
    private Description description;
    private Tags[] tags;
    private OpeningHours openingHours;

    public Data() {
    }

    public Data(String id, Name name, EType sourceType, String infoURL, OffsetDateTime modifiedAt,
                LocationInfo location, Description description, Tags[] tags, OpeningHours openingHours) {
        this.id = id;
        this.name = name;
        this.sourceType = sourceType;
        this.infoURL = infoURL;
        this.modifiedAt = modifiedAt;
        this.location = location;
        this.description = description;
        this.tags = tags;
        this.openingHours = openingHours;
    }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("name")
    public Name getName() { return name; }
    @JsonProperty("name")
    public void setName(Name value) { this.name = value; }

    @JsonProperty("source_type")
    public EType getSourceType() { return sourceType; }
    @JsonProperty("source_type")
    public void setSourceType(EType value) { this.sourceType = value; }

    @JsonProperty("info_url")
    public String getInfoURL() { return infoURL; }
    @JsonProperty("info_url")
    public void setInfoURL(String value) { this.infoURL = value; }

    @JsonProperty("modified_at")
    public OffsetDateTime getModifiedAt() { return modifiedAt; }
    @JsonProperty("modified_at")
    public void setModifiedAt(OffsetDateTime value) { this.modifiedAt = value; }

    @JsonProperty("location")
    public LocationInfo getLocation() { return location; }
    @JsonProperty("location")
    public void setLocation(LocationInfo value) { this.location = value; }

    @JsonProperty("description")
    public Description getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(Description value) { this.description = value; }

    @JsonProperty("tags")
    public Tags[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(Tags[] value) { this.tags = value; }

    @JsonProperty("opening_hours")
    public OpeningHours getOpeningHours() { return openingHours; }
    @JsonProperty("opening_hours")
    public void setOpeningHours(OpeningHours value) { this.openingHours = value; }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
