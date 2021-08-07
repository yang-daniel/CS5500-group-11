package main.controller;



import main.app.service.DayService;
import main.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DayControllerWeb {

    @Autowired
    private DayService dayService;

    @ModelAttribute("day")
    public Day getDay(@RequestParam(name="date", required=false) String date) {
        return this.dayService.getDayByDate(date);
    }

    @GetMapping("/web/day")
    public String getDay() {
        // model.addAttribute("day", this.dayService.getDayByDate(date));
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
}
