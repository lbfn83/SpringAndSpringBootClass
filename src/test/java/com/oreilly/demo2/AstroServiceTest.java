package com.oreilly.demo2;

import com.oreilly.demo2.json.Assignment;
import com.oreilly.demo2.json.AstroResult;
import com.oreilly.demo2.service.AstroService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AstroServiceTest {
    @Autowired
    private AstroService service;

    @Test
    void getAstronautsRT(){
        AstroResult result = service.getAstronautsRT();
        int number = result.getNumber();
        System.out.println("There are " + number + " people in space");
        List<Assignment> people = result.getPeople();
        people.forEach(System.out::println);

        assertAll(
                ()-> assertTrue(number >= 0),
                ()->assertEquals(number, people.size())
        );
    }
    @Test
    void getAstronautsWC(){
        AstroResult result = service.getAstronautsWC();
        int number = result.getNumber();
        System.out.println("There are " + number + " people in space");
        List<Assignment> people = result.getPeople();
        people.forEach(System.out::println);

        assertAll(
                ()-> assertTrue(number >= 0),
                ()->assertEquals(number, people.size())
        );
    }
}
