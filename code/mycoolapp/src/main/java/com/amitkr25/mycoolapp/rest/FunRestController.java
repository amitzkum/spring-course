package com.amitkr25.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @Value("${coach.experience}")
    private String yearsExpOfCoah;

    // expose "/teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return ("Team " + teamName + "'s coach is " + coachName + ". And he has " + yearsExpOfCoah + " years of experience as a coach!");
    }

    // expose "/" endpoint to return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "<h1>Hello World</h1>";
    }

    // expose "/workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "<h1>Run a hard 5k!</h1>";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "<h1>Today is your Lucky Day!</h1>";
    }
}
