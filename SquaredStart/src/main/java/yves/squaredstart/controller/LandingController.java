package yves.squaredstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class LandingController {
    @GetMapping("")
    public String landingPage(Model model) {
        return "landingPage";
    }
}
