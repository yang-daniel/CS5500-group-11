package main.controller;


import java.util.List;
import main.app.service.DayService;
import main.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
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
  public Day getDayByDate(@PathVariable("date") String date) {
    return dayService.getDayByDate(date);
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
