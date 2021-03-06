package main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

import java.util.List;
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
  private List<Summary> summary;
  private List<Segments> segments;
  private int caloriesIdle;
  private String lastUpdate;

  public Day(@JsonProperty("_id") String id, @JsonProperty("date") String date,
      @JsonProperty("summary") List<Summary> summary, @JsonProperty("segments") List<Segments> segments,
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

  public void setSummary(List<Summary> summary) {
    this.summary = summary;
  }

  public void setSegments(List<Segments> segments) {
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

  public List<Summary> getSummary() {
    return summary;
  }

  public List<Segments> getSegments() {
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
        ", activities=" + summary.toString() +
        ", segments=" + segments.toString() +
        ", caloriesIdle=" + caloriesIdle +
        ", lastUpdate='" + lastUpdate + '\'' +
        '}';
  }

}
