package com.locations.model;

public class Image {
    private String url;
    private String copyright_holder;
    private EType license_type;

    public Image() {
    }

    public Image(String url, String copyright_holder, EType license_type) {
        this.url = url;
        this.copyright_holder = copyright_holder;
        this.license_type = license_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCopyright_holder() {
        return copyright_holder;
    }

    public void setCopyright_holder(String copyright_holder) {
        this.copyright_holder = copyright_holder;
    }

    public EType getLicense_type() {
        return license_type;
    }

    public void setLicense_type(EType license_type) {
        this.license_type = license_type;
    }
}
