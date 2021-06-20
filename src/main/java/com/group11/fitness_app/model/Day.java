package com.group11.fitness_app.model;
import java.util.Arrays;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString

@Document(collation = "Project")
public class Day {

  @Id
  private String date;
  private Arrays[] activities;
  private Arrays[] segments;
  private int caloriesIdle;
  private String lastUpdate;

  public void setDate(String date) {
    this.date = date;
  }

  public void setActivities(Arrays[] activities) {
    this.activities = activities;
  }

  public void setSegments(Arrays[] segments) {
    this.segments = segments;
  }

  public void setCaloriesIdle(int caloriesIdle) {
    this.caloriesIdle = caloriesIdle;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getDate() {
    return date;
  }

  public Arrays[] getActivities() {
    return activities;
  }

  public Arrays[] getSegments() {
    return segments;
  }

  public int getCaloriesIdle() {
    return caloriesIdle;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  @Override
  public String toString() {
    return "Day{" +
        "date='" + date + '\'' +
        ", activities=" + Arrays.toString(activities) +
        ", segments=" + Arrays.toString(segments) +
        ", caloriesIdle=" + caloriesIdle +
        ", lastUpdate='" + lastUpdate + '\'' +
        '}';
  }

}
