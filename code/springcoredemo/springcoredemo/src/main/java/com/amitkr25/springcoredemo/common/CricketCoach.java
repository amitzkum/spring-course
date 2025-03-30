package com.amitkr25.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In Constructor of: " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In PostConstruct method of " + getClass().getSimpleName() + " beans lifecycle.");
    }

    //define destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In PreDestroy method of " + getClass().getSimpleName() + " beans lifecycle.");
    }


    @Override
    public String getDailyWorkouts() {
        return "<h1>Practise fast bowling for 15 minutes :-)</h1>";
    }
}
