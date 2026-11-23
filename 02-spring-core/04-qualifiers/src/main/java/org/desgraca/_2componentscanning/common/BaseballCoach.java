package org.desgraca._2componentscanning.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "30 minutes in batting practice";
    }
}
