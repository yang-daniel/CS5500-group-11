package main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;

public class Segments {
  @Id
  private String id;
  private String type;
  private String startTime;
  private String endTime;
  private Object place;
  private ArrayList<Object> activities;
  private String lastUpdate;



  public Segments(@JsonProperty("_id") String id, @JsonProperty("type") String type,
      @JsonProperty("startTime")  String startTime, @JsonProperty("endTime") String endTime,
      @JsonProperty("place") Object place, @JsonProperty("activities") ArrayList<Object> activities,
      @JsonProperty("lastUpdate") String lastUpdate) {
    this.id = id;
    this.type = type;
    this.startTime = startTime;
    this.endTime = endTime;
    this.place = place;
    this.activities = activities;
    this.lastUpdate = lastUpdate;
  }

  public Segments(){};

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Object getPlace() {
    return place;
  }

  public void setPlace(Object place) {
    this.place = place;
  }

  public ArrayList<Object> getActivities() {
    return activities;
  }

  public void setActivities(ArrayList<Object> activities) {
    this.activities = activities;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  @Override
  public String toString() {
    return "Segments{" +
        "id='" + id + '\'' +
        ", type='" + type + '\'' +
        ", startTime='" + startTime + '\'' +
        ", endTime=" + endTime +
        ", place=" + place +
        ", activities=" + activities +
        ", lastUpdate=" + lastUpdate +
        '}';
  }
}

