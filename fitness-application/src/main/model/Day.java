package main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Getter
//@Setter
//@ToString
//
@Document(collection = "Project")
public class Day {
  @Id
  private String id;
  private String date;
  //create summary and segment classes and instead of Arrays[], use List<summary/segments>
  private Arrays[] summary;
  private Arrays[] segments;
  private int caloriesIdle;
  private String lastUpdate;

  public Day(@JsonProperty("_id") String id, @JsonProperty("date") String date,
      @JsonProperty("summary") Arrays[] summary, @JsonProperty("segments") Arrays[] segments,
      @JsonProperty("caloriesIdle") int caloriesIdle, @JsonProperty("lastUpdate") String lastUpdate) {
    this.id = id;
    this.date = date;
    this.summary = summary;
    this.segments = segments;
    this.caloriesIdle = caloriesIdle;
    this.lastUpdate = lastUpdate;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setSummary(Arrays[] summary) {
    this.summary = summary;
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

  public Arrays[] getSummary() {
    return summary;
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
        ", activities=" + Arrays.toString(summary) +
        ", segments=" + Arrays.toString(segments) +
        ", caloriesIdle=" + caloriesIdle +
        ", lastUpdate='" + lastUpdate + '\'' +
        '}';
  }

}
