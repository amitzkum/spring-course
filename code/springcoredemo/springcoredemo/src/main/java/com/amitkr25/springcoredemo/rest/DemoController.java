package com.amitkr25.springcoredemo.rest;

import com.amitkr25.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependencies
    private Coach myCoach;
    private Coach anotherCoach;

    // using constructor injection
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach coach,
            @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In Constructor of: " + getClass().getSimpleName());
        myCoach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkouts();
    }

    // check if beans are same or not
    // singleton true
    // prototype false
    @GetMapping("/check")
    public String check() {
        return "Comparing beans myCoach == anotherCoach: " + (this.myCoach == this.anotherCoach);
    }
}
