package com.oreilly.demo2.config;

import com.oreilly.demo2.json.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Greeting defaultGreeting()
    {
        return new Greeting("Hello, wonjae!");
    }
    @Bean
    public Greeting whatUpGreeting()
    {
        return new Greeting("What up?");
    }
}
