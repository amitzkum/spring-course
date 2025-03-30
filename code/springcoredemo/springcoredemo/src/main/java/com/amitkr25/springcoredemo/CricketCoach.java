package com.amitkr25.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkouts() {
        return "Practise fast bowling for 15 minutes!!!";
    }
}
