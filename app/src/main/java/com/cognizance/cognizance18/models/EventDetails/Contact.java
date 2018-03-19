package com.cognizance.cognizance18.models.EventDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Contact{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("phoneNo")
  @Expose
  private String phoneNo;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setPhoneNo(String phoneNo){
   this.phoneNo=phoneNo;
  }
  public String getPhoneNo(){
   return phoneNo;
  }
}