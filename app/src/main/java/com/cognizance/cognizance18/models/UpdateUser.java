package com.cognizance.cognizance18.models;

/**
 * Created by samagra on 12/1/18.
 */

public class UpdateUser {

    private String name;
    private String city;
    private String address;
    private String pincode;
    private String mobile;

    public UpdateUser(String name, String city, String address, String pincode, String mobile) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.pincode = pincode;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
