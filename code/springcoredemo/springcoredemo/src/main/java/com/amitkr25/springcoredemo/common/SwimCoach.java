package com.amitkr25.springcoredemo.common;

import org.springframework.context.annotation.Bean;

// not using the @Component annotation. Will be using the @Bean annotation instead
public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println("In Constructor of class: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkouts() {
        return "Swim 1000m as warmup!";
    }
}
