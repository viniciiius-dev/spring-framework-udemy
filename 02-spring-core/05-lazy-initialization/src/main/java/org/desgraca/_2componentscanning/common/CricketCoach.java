package org.desgraca._2componentscanning.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "15 pushups";
    }
}
