package com.amitkr25.springcoredemo.rest;

import com.amitkr25.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependencies
    private Coach myCoach;

    // using constructor injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach) {
        System.out.println("In Constructor of: " + getClass().getSimpleName());
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkouts();
    }
}
