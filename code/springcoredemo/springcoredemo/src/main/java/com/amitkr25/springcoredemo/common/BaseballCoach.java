package com.amitkr25.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkouts() {
        return "<h1>Spend 30min in batting practise.</h1>";
    }
}
