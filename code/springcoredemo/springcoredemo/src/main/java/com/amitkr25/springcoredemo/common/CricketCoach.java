package com.amitkr25.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkouts() {
        return "<h1>Practise fast bowling for 15 minutes :-)</h1>";
    }
}
