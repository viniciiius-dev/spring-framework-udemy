package org.desgraca._2componentscanning.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{


    @Override
    public String getDailyWorkout() {
        return "15 pushups";
    }
}
