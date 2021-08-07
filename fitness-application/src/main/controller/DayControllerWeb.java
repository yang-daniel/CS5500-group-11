package main.controller;



import main.app.service.DayService;
import main.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DayControllerWeb {

    @Autowired
    private DayService dayService;

    @GetMapping("/web/day")
    public String getAllDays(@RequestParam( name="date", required=false, defaultValue="World") String date, Model model) {

        List<Day> day = dayService.getAllDays();

        if(day.isEmpty()){

            //model.addAttribute("name", "No Match");
            model.addAttribute("name", dayService.getAllDays());
        }
        else {
            //model.addAttribute("name", date);

            model.addAttribute("name", dayService.getAllDays());
            //model.addAttribute("name", day.get().getDate());
        }

        return "day";
    }
}
