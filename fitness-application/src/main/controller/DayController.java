package main.controller;


import java.util.List;
import main.app.service.DayService;
import main.model.Day;
import main.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/day")
@RestController
public class DayController {

  @Autowired
  private final DayService dayService;

  public DayController(DayService dayService) {
    this.dayService = dayService;
  }

  @GetMapping
  public List<Day> getAll() {
    return dayService.getAllDays();
  }

  @GetMapping(value = "{date}")
  public ResponseEntity<Day> getDayByDate(@PathVariable("date") String date) {
      Day myDate = dayService.getDayByDate(date);
      if (myDate == null) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(myDate, HttpStatus.OK);
  }


  @GetMapping(value = "{date}/steps")
  public int getDayByDateSteps(@PathVariable("date") String date) {
    List<Summary> summary = dayService.getDayByDate(date).getSummary();
    return summary.get(0).getSteps();
  }

  @GetMapping(value = "{date}/calories")
  public int getDayByDateCalories(@PathVariable("date") String date) {
    List<Summary> summary = dayService.getDayByDate(date).getSummary();
    return summary.get(0).getCalories();
  }

  @PostMapping
  public Day addDay(@RequestBody Day day) {
    return dayService.addDay(day);
  }

  @DeleteMapping(value = "{date}")
  public void deleteDay(@PathVariable String date) {
    dayService.deleteDay(date);
  }
}
