package com.amitkr25.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("In Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkouts() {
        return "Practise back hand volly for 45min.";
    }
}
