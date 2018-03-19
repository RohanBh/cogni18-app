package com.cognizance.cognizance18.models.EventDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class EventDescription {
  @SerializedName("message")
  @Expose
  private String message;
  @SerializedName("event")
  @Expose
  private EventD event;
  public void setMessage(String message){
   this.message=message;
  }
  public String getMessage(){
   return message;
  }
  public void setEvent(EventD event){
   this.event=event;
  }
  public EventD getEvent(){
   return event;
  }
}