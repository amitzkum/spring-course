package com.amitkr25.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("In Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkouts() {
        return "Run a hard 5k.";
    }
}
