package com.cognizance.cognizance18.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Events{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("tagline")
  @Expose
  private String tagline;
  @SerializedName("id")
  @Expose
  private Integer id;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setTagline(String tagline){
   this.tagline=tagline;
  }
  public String getTagline(){
   return tagline;
  }
  public void setId(Integer id){
   this.id=id;
  }
  public Integer getId(){
   return id;
  }
}