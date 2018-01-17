package com.cognizance.cognizance18.models;

/**
 * Created by arihant on 7/1/18.
 */

public class SignUpUser extends User {

    private String mobile;
    private String name;
    private String type;

    public SignUpUser(String email, String password, String mobile, String name, String type) {
        super(email, password);
        this.mobile = mobile;
        this.name = name;
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
