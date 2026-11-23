package org.desgraca._2componentscanning.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
