package main.DAO;

import java.util.List;
import main.model.Day;

public interface DayDao {
  public List<Day> getAllDays();
  public Day getDayByDate(String date);
  public Day addDay(Day day);
  public Day updateDay(Day day);
  public void deleteDay(Day day);
}
