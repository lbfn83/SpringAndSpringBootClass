package com.oreilly.demo2;

import com.oreilly.demo2.json.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo2Application {


    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }
//    @Bean
//    public Greeting defaultGreeting()
//    {
//        return new Greeting("Hello, wonjae!");
//    }
}
