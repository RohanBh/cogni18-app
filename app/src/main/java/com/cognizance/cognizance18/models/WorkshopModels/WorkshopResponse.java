package com.cognizance.cognizance18.models.WorkshopModels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class WorkshopResponse {
  @SerializedName("workshops")
  @Expose
  private List<Workshops> workshops;
  @SerializedName("message")
  @Expose
  private String message;
  public void setWorkshops(List<Workshops> workshops){
   this.workshops=workshops;
  }
  public List<Workshops> getWorkshops(){
   return workshops;
  }
  public void setMessage(String message){
   this.message=message;
  }
  public String getMessage(){
   return message;
  }
}