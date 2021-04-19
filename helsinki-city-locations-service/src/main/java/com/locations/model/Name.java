package com.locations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {
    private String fi;
    private String en;
    private String sv;
    private Object zh;

    public Name() {
    }

    public Name(String fi, String en, String sv, Object zh) {
        this.fi = fi;
        this.en = en;
        this.sv = sv;
        this.zh = zh;
    }

    @JsonProperty("fi")
    public String getFi() { return fi; }
    @JsonProperty("fi")
    public void setFi(String value) { this.fi = value; }

    @JsonProperty("en")
    public String getEn() { return en; }
    @JsonProperty("en")
    public void setEn(String value) { this.en = value; }

    @JsonProperty("sv")
    public String getSv() { return sv; }
    @JsonProperty("sv")
    public void setSv(String value) { this.sv = value; }

    @JsonProperty("zh")
    public Object getZh() { return zh; }
    @JsonProperty("zh")
    public void setZh(Object value) { this.zh = value; }
    @Override
    public String toString() {
        return "Name {" +
                "id=" + fi +
                ", name='" + en + '\'' +
                '}';
    }
}
