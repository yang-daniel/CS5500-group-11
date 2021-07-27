package main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Summary {
  @Id
  private String id;
  private String activity;
  private String group;
  private double duration;
  private double distance;
  private int steps;
  private int calories;

  public Summary(@JsonProperty("_id") String id, @JsonProperty("activity") String activity,
      @JsonProperty("group")  String group, @JsonProperty("duration") double duration,
      @JsonProperty("distance") double distance, @JsonProperty("steps") int steps,
      @JsonProperty("calories") int calories) {
    this.id = id;
    this.activity = activity;
    this.group = group;
    this.duration = duration;
    this.distance = distance;
    this.steps = steps;
    this.calories = calories;
  }

  public Summary(){};

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getActivity() {
    return activity;
  }
  public void setActivity(String activity) {
    this.activity = activity;
  }
  public String getGroup() {
    return group;
  }
  public void setGroup(String group) {
    this.group = group;
  }
  public double getDuration() {
    return duration;
  }
  public void setDuration(double duration) {
    this.duration = duration;
  }
  public double getDistance() {
    return distance;
  }
  public void setDistance(double distance) {
    this.distance = distance;
  }
  public int getSteps() {
    return steps;
  }
  public void setSteps(int steps) {
    this.steps = steps;
  }
  public int getCalories() {
    return calories;
  }
  public void setCalories(int calories) {
    this.calories = calories;
  }

  @Override
  public String toString() {
    return "Summary{" +
        "id='" + id + '\'' +
        ", activity='" + activity + '\'' +
        ", group='" + group + '\'' +
        ", duration=" + duration +
        ", distance=" + distance +
        ", steps=" + steps +
        ", calories=" + calories +
        '}';
  }
}
