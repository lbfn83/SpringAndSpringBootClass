package com.oreilly.demo2.controllers;

import com.oreilly.demo2.json.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/rest")
    // Define method that will return Greeting instance / Restful way!
    public Greeting greet(@RequestParam(value = "name" ,required = false, defaultValue = "World") String name){
        return new Greeting("Hello, " + name + "!");
    }
}
