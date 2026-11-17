package org.desgraca._1constructorinjection.controllers;

import org.desgraca._1constructorinjection.Coach;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach;

    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }
    @GetMapping
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
