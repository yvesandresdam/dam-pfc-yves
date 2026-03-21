package yves.squaredstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LandingController {
    @GetMapping("/hello")
    public String hello(){
        return "SQUARED Hello World!";
    }
}
