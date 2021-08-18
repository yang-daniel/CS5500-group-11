package main.controller;



import main.app.service.DayService;
import main.client.IMongoDBClient;
import main.client.MongoDBClient;
import main.model.Day;
import main.model.Summary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class DayControllerWeb {

    @Autowired
    private DayService dayService;

    // @Autowired

    // @ModelAttribute("day")
    // public Day getDaySecond(@RequestParam(name="date", required=false, defaultValue = "") String date) {
    //     return this.dayService.getDayByDate(date);
    // }

    // @ModelAttribute("month")
    // public Day getMonthYear(@RequestParam(name="month", required=false, defaultValue = "") String date) {
    //     if (date != null) {
    //         return this.dayService.getDayByDate(date + "01");
    //     }
    //     return this.dayService.getDayByDate(date);
    // 

    @GetMapping("/web/day")
    public String getDay(Model model) {
        return "day";
    }




    @GetMapping("web/day/{date}/rewards")
    public String getRewards(@PathVariable("date") String date, Model model) {
        Day d = this.dayService.getDayByDate(date);
        model.addAttribute("day", d);

        try {
            model.addAttribute("listsum", d.getSummary());
        } catch (Exception e) {
            model.addAttribute("listsum", "No data for input");
        }

        List<Day> listsum = new ArrayList<>();
        List<List<Object>> dpointsInt = new ArrayList<List<Object>>();
        if (date.length() == 8) {
            int dayCals = 0;
            for (Summary s : d.getSummary()) {
                dayCals += s.getCalories();
            }
            dayCals += d.getCaloriesIdle();

            String mthYear = date.substring(0, 6);
            String month = mthYear.substring(4,6);
            String year = mthYear.substring(0, 4);
            for (int i = 1; i < 32; i++ ) {
                String mthDate = mthYear;
                if (i < 10) {
                    mthDate += ("0" + i);
                } else {
                    mthDate += i;
                }
                Day mthD = this.dayService.getDayByDate(mthDate);
                if (mthD != null) {
                    int totalCals = 0;
                    for (Summary s : mthD.getSummary()) {
                        totalCals += s.getCalories();
                    }
                    totalCals += mthD.getCaloriesIdle();
                    listsum.add(mthD);
                    List<Object> map = new ArrayList<Object>();
                    String graphDate = month + "/" + i + "/" + year;
                    map.add(graphDate);
                    map.add(totalCals * 2);
                    map.add(dayCals * 2);
                    dpointsInt.add(map);
                }
            }
        }
        model.addAttribute("monthSum", listsum);
        model.addAttribute("monthDataPoints", dpointsInt);
        return "rewards";
    }

    @GetMapping("web/day/{date}/steps")
    public String getSteps(@PathVariable("date") String date, Model model) {
        Day d = this.dayService.getDayByDate(date);
        model.addAttribute("day", d);

        try {
            model.addAttribute("listsum", d.getSummary());
        } catch (Exception e) {
            model.addAttribute("listsum", "No data for input");
        }

        List<Day> listsum = new ArrayList<>();
        List<List<Object>> dpointsInt = new ArrayList<List<Object>>();
        if (date.length() == 8) {
            int dayCals = 0;
            for (Summary s : d.getSummary()) {
                dayCals += s.getCalories();
            }
            dayCals += d.getCaloriesIdle();

            String mthYear = date.substring(0, 6);
            String month = mthYear.substring(4,6);
            String year = mthYear.substring(0, 4);
            for (int i = 1; i < 32; i++ ) {
                String mthDate = mthYear;
                if (i < 10) {
                    mthDate += ("0" + i);
                } else {
                    mthDate += i;
                }
                Day mthD = this.dayService.getDayByDate(mthDate);
                if (mthD != null) {
                    int totalCals = 0;
                    for (Summary s : mthD.getSummary()) {
                        totalCals += s.getCalories();
                    }
                    totalCals += mthD.getCaloriesIdle();
                    listsum.add(mthD);
                    List<Object> map = new ArrayList<Object>();
                    String graphDate = month + "/" + i + "/" + year;
                    map.add(graphDate);
                    map.add(totalCals);
                    map.add(dayCals);
                    dpointsInt.add(map);
                }
            }
        }
        model.addAttribute("monthSum", listsum);
        model.addAttribute("monthDataPoints", dpointsInt);
        return "steps";
    }

    @GetMapping("web/day/{date}/calories")
    public String getCalories(@PathVariable("date") String date, Model model) throws ParseException {
        Day d = this.dayService.getDayByDate(date);
        model.addAttribute("day", d);

        try {
            model.addAttribute("listsum", d.getSummary());
        } catch (Exception e) {
            model.addAttribute("listsum", "No data for input");
        }

        List<Day> listsum = new ArrayList<>();
        List<List<Object>> dpointsInt = new ArrayList<List<Object>>();
        if (date.length() == 8) {
            int dayCals = 0;
            for (Summary s : d.getSummary()) {
                dayCals += s.getCalories();
            }
            dayCals += d.getCaloriesIdle();

            String mthYear = date.substring(0, 6);
            String month = mthYear.substring(4,6);
            String year = mthYear.substring(0, 4);
            for (int i = 1; i < 32; i++ ) {
                String mthDate = mthYear;
                if (i < 10) {
                    mthDate += ("0" + i);
                } else {
                    mthDate += i;
                }
                Day mthD = this.dayService.getDayByDate(mthDate);
                if (mthD != null) {
                    int totalCals = 0;
                    for (Summary s : mthD.getSummary()) {
                        totalCals += s.getCalories();
                    }
                    totalCals += mthD.getCaloriesIdle();
                    listsum.add(mthD);
                    List<Object> map = new ArrayList<Object>();
                    String graphDate = month + "/" + i + "/" + year;
                    map.add(graphDate);
                    map.add(totalCals);
                    map.add(dayCals);
                    dpointsInt.add(map);
                }
            }
        }
        model.addAttribute("monthDataPoints", dpointsInt);
        model.addAttribute("monthSum", listsum);
        return "calories";
    }


    private String formatDateFancy(String date) {
        if (date.length() != 8) {
            return "";
        }

        return date.substring(4, 6) + "/" + date.substring(6,8) + "/" + date.substring(0, 4);
    }
}
