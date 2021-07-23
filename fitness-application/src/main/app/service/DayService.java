package main.app.service;

import java.util.List;
import main.DAO.DayDaoImpl;
import main.client.MongoDBClient;
import main.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayService {

  private final DayDaoImpl dayDao;

  @Autowired
  public DayService(DayDaoImpl dayDao) {
    this.dayDao = dayDao;
  }

  public List<Day> getAllDays() {
    return dayDao.getAllDays();
  }
  public Day getDayByDate(String date) {
    return dayDao.getDayByDate(date);
  }

  public Day addDay(Day date) {
    return dayDao.addDay(date);
  }

  public Day updateDay (Day date) {
    return dayDao.updateDay(date);
  }

  public void deleteDay(String date) {
    Day day = dayDao.getDayByDate(date);
    dayDao.deleteDay(day);
  }

//  private final MongoDBClient dayDao;
//
//  public DayService(MongoDBClient dayDao) {
//    this.dayDao = dayDao;
//  }
}
