package com.cognizance.cognizance18.models;

/**
 * Created by samagra on 12/1/18.
 */

public class UserDetails {
    private String CogniId;
    private String address;
    private String city;
    private boolean centralRegistration;
    private String college;
    private String email;
    private boolean expanseRegistration;
    private int id;
    private String imageUrl;
    private  boolean isCompleted;
    private String mobile;
    private String name;
    private String pincode;
    private String referalCode;
    private String role;
    private String score;
    private String type;
    private String userdReferred;
    private boolean verified;
    private boolean workShopRegistration;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserDetails(String cogniId, String address,
                       String city, boolean centralRegistration,
                       String college, String email, boolean expanseRegistration,
                       int id, String imageUrl, boolean isCompleted,
                       String mobile, String name, String pincode,
                       String referalCode, String role, String score,
                       String type, String userdReferred, boolean verified,
                       boolean workShopRegistration) {
        CogniId = cogniId;
        this.address = address;
        this.city = city;
        this.centralRegistration = centralRegistration;
        this.college = college;
        this.email = email;
        this.expanseRegistration = expanseRegistration;
        this.id = id;
        this.imageUrl = imageUrl;
        this.isCompleted = isCompleted;
        this.mobile = mobile;
        this.name = name;
        this.pincode = pincode;
        this.referalCode = referalCode;
        this.role = role;
        this.score = score;
        this.type = type;
        this.userdReferred = userdReferred;
        this.verified = verified;
        this.workShopRegistration = workShopRegistration;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "CogniId='" + CogniId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCogniId() {
        return CogniId;
    }

    public void setCogniId(String cogniId) {
        CogniId = cogniId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCentralRegistration() {
        return centralRegistration;
    }

    public void setCentralRegistration(boolean centralRegistration) {
        this.centralRegistration = centralRegistration;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isExpanseRegistration() {
        return expanseRegistration;
    }

    public void setExpanseRegistration(boolean expanseRegistration) {
        this.expanseRegistration = expanseRegistration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getReferalCode() {
        return referalCode;
    }

    public void setReferalCode(String referalCode) {
        this.referalCode = referalCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserdReferred() {
        return userdReferred;
    }

    public void setUserdReferred(String userdReferred) {
        this.userdReferred = userdReferred;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isWorkShopRegistration() {
        return workShopRegistration;
    }

    public void setWorkShopRegistration(boolean workShopRegistration) {
        this.workShopRegistration = workShopRegistration;
    }

}
