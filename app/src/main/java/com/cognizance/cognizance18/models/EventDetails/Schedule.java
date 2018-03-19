package com.cognizance.cognizance18.models.EventDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Schedule{
  @SerializedName("time")
  @Expose
  private String time;
  @SerializedName("day")
  @Expose
  private Integer day;
  public void setTime(String time){
   this.time=time;
  }
  public String getTime(){
   return time;
  }
  public void setDay(Integer day){
   this.day=day;
  }
  public Integer getDay(){
   return day;
  }
}