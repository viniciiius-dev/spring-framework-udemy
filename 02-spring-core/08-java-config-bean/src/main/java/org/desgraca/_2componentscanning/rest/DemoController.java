package org.desgraca._2componentscanning.rest;

import org.desgraca._2componentscanning.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach;

    public DemoController(@Qualifier("aquatic") Coach myCoach) {
        this.myCoach = myCoach;
    }
    @GetMapping
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
