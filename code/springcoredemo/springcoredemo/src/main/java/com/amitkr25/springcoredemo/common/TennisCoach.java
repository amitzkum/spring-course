package com.amitkr25.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkouts() {
        return "Practise back hand volly for 45min.";
    }
}
