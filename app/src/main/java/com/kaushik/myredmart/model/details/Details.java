
package com.kaushik.myredmart.model.details;


public class Details {

    private int prod_type;
    private String uri;
    private int status;
    private double is_new;
    private String storage_class;
    private String country_of_origin;

    public int getProd_type() {
        return prod_type;
    }

    public void setProd_type(int prod_type) {
        this.prod_type = prod_type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getIs_new() {
        return is_new;
    }

    public void setIs_new(double is_new) {
        this.is_new = is_new;
    }

    public String getStorage_class() {
        return storage_class;
    }

    public void setStorage_class(String storage_class) {
        this.storage_class = storage_class;
    }

    public String getCountry_of_origin() {
        return country_of_origin;
    }

    public void setCountry_of_origin(String country_of_origin) {
        this.country_of_origin = country_of_origin;
    }

}
