package org.desgraca._2componentscanning.config;


import org.desgraca._2componentscanning.common.Coach;
import org.desgraca._2componentscanning.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
