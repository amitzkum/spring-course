package com.amitkr25.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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
