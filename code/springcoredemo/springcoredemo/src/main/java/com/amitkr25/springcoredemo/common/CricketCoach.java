package com.amitkr25.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkouts() {
        return "<h1>Practise fast bowling for 15 minutes :-)</h1>";
    }
}
