package main.DAO;

import java.util.List;
import java.util.Optional;
import main.model.Day;
import main.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DayDaoImpl implements DayDao{

  @Autowired
  private final DayRepository dayRepository;

  public DayDaoImpl(DayRepository dayRepository) {
    this.dayRepository = dayRepository;
  }

  @Override
  public List<Day> getAllDays() {
    return dayRepository.findAll();
  }

  @Override
  public Day getDayByDate(String date) {
    Day day = dayRepository.findByDate(date);
    return day;
  }

  @Override
  public Day addDay(Day day) {
    return dayRepository.insert(day);
  }

  @Override
  public Day updateDay(Day newDay) {
    return dayRepository.save(newDay);
  }

  @Override
  public void deleteDay(Day day) {
    dayRepository.delete(day);
  }
}
