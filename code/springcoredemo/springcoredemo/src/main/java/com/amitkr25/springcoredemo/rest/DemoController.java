package com.amitkr25.springcoredemo.rest;

import com.amitkr25.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependencies
    // no need for setter or constructor
    @Autowired //field injection
    private Coach myCoach;

    // using setter injection instead of Constructor Injection
//    @Autowired
//    public void setCoach(Coach coach) {
//        myCoach = coach;
//    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkouts();
    }
}
