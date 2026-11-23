package org.desgraca._2componentscanning.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CricketCoach implements Coach{


    @Override
    public String getDailyWorkout() {
        return "15 pushups";
    }
}
