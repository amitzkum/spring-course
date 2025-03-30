package com.amitkr25.springcoredemo.rest;

import com.amitkr25.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependencies
    private Coach myCoach;

    //define a constructor for DI
    @Autowired
    public DemoController(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkouts();
    }
}
