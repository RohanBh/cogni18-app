package com.cognizance.cognizance18.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class CentralStage{
  @SerializedName("Events")
  @Expose
  private List<Events> Events;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("id")
  @Expose
  private Integer id;
  public void setEvents(List<Events> Events){
   this.Events=Events;
  }
  public List<Events> getEvents(){
   return Events;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setId(Integer id){
   this.id=id;
  }
  public Integer getId(){
   return id;
  }
}