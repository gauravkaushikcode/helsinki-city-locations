package com.locations.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationInfo {
    private double lat;
    private double lon;
    private Address address;

    public LocationInfo() {
    }

    public LocationInfo(double lat, double lon, Address address) {
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }

    @JsonProperty("lat")
    public double getLat() { return lat; }
    @JsonProperty("lat")
    public void setLat(double value) { this.lat = value; }

    @JsonProperty("lon")
    public double getLon() { return lon; }
    @JsonProperty("lon")
    public void setLon(double value) { this.lon = value; }

    @JsonProperty("address")
    public Address getAddress() { return address; }
    @JsonProperty("address")
    public void setAddress(Address value) { this.address = value; }
}
