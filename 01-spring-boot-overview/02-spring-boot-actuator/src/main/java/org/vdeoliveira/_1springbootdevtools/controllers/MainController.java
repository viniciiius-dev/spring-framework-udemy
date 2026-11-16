package org.vdeoliveira._1springbootdevtools.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String getDailyWorkout(){
        return "Hard run: 5k";
    }
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }
    @GetMapping("/testdevtools")
    public String getDevTools(){
        return "This is to return devtools";
    }

}
