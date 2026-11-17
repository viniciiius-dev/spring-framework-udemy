package org.desgraca._1constructorinjection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{


    @Override
    public String getDailyWorkout() {
        return "15 pushups";
    }
}
