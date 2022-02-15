package com.oreilly.demo2.controllers;

import com.oreilly.demo2.json.Greeting;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestContollerFunctionalTest {

    @Test
    public void greetWithName(@Autowired TestRestTemplate template)
    {
        Greeting response = template.getForObject("/rest?name=Wonjae", Greeting.class);
        assertEquals( "Hello, Wonjae!", response.getMessage());
    }

    @Test
    public void greetWithoutName(@Autowired TestRestTemplate template){
        ResponseEntity<Greeting> entity= template.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        if(response != null)
        {
            assertEquals("Hello, World!", response.getMessage());
        }
    }



}
