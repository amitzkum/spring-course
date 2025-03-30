package com.amitkr25.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkouts() {
        return "Run a hard 5k.";
    }
}
