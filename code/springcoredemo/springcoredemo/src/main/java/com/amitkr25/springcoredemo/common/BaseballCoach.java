package com.amitkr25.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("In Constructor of: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkouts() {
        return "<h1>Spend 30min in batting practise.</h1>";
    }
}
