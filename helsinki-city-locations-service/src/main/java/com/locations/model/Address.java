package com.locations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    private String streetAddress;
    private String postalCode;
    private String locality;

    public Address() {
    }

    public Address(String streetAddress, String postalCode, String locality) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    @JsonProperty("street_address")
    public String getStreetAddress() { return streetAddress; }
    @JsonProperty("street_address")
    public void setStreetAddress(String value) { this.streetAddress = value; }

    @JsonProperty("postal_code")
    public String getPostalCode() { return postalCode; }
    @JsonProperty("postal_code")
    public void setPostalCode(String value) { this.postalCode = value; }

    @JsonProperty("locality")
    public String getLocality() { return locality; }
    @JsonProperty("locality")
    public void setLocality(String value) { this.locality = value; }
    @Override
    public String toString() {
        return "Address{" +
                "street_address=" + streetAddress +
                ", postal_code='" + postalCode + ", locality='"+ locality+ '\'' +
                '}';
    }
}
