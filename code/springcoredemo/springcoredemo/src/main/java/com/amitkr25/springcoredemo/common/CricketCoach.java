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

    @Override
    public String getDailyWorkouts() {
        return "<h1>Practise fast bowling for 15 minutes :-)</h1>";
    }
}
