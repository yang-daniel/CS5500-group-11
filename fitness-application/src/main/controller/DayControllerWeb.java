package main.controller;



import main.app.service.DayService;
import main.client.IMongoDBClient;
import main.client.MongoDBClient;
import main.model.Day;
import main.model.Summary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
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

    @GetMapping("/web/day/{date}")
    public String getDay(@PathVariable("date") String date, Model model) {
        model.addAttribute("day", this.dayService.getDayByDate(date));
        // System.out.println("Day Controller: " + date);

        // Take the request and fill this.days;
        // this.days = dayService.getDayByDate(date);
        // System.out.println("Day has " + this.days.getCaloriesIdle() + " calories");

        // List<Day> day = dayService.getAllDays();

        // if(day.isEmpty()){

        //     //model.addAttribute("name", "No Match");
        //     model.addAttribute("name", dayService.getAllDays());
        // }
        // else {
        //     //model.addAttribute("name", date);

        //     model.addAttribute("name", dayService.getAllDays());
        //     //model.addAttribute("name", day.get().getDate());
        // }

        return "day";
    }

    @GetMapping("web/day/{date}/rewards")
    public String getRewards(@PathVariable("date") String date, Model model) {
        model.addAttribute("day", this.dayService.getDayByDate(date));

        
        return "rewards";
    }

    @GetMapping("web/day/{date}/steps")
    public String getSteps(@PathVariable("date") String date, Model model) {
        model.addAttribute("day", this.dayService.getDayByDate(date));
        return "steps";
    }

    @GetMapping("web/day/{date}/calories")
    public String getCalories(@PathVariable("date") String date, Model model) {
        Day d = this.dayService.getDayByDate(date);
        model.addAttribute("day", d);
        model.addAttribute("listsum", d.getSummary());

        List<Day> listsum = new ArrayList<>();
        if (date.length() == 8) {
            String mthYear = date.substring(0, 6);
            for (int i = 1; i < 32; i++ ) {
                String mthDate = mthYear;
                if (i < 10) {
                    mthDate += ("0" + i);
                } else {
                    mthDate += i;
                }
                Day mthD = this.dayService.getDayByDate(mthDate);
                if (mthD != null) {
                    listsum.add(mthD);
                } else {
                    System.out.println(mthDate);
                }
            }
        }
        model.addAttribute("monthSum", listsum);
        return "calories";
    }
}
