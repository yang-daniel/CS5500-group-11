package main.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DayControllerWeb {




    @GetMapping("/web/day")
    public String getAllDays(@RequestParam(name="date", required=false, defaultValue="World") String date, Model model) {
        model.addAttribute("name", date);
        return "day";
    }
}
