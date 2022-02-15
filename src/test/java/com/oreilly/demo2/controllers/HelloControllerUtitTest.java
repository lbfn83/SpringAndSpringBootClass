package com.oreilly.demo2.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;
import org.springframework.validation.support.BindingAwareModelMap;

public class HelloControllerUtitTest {
    @Test
    public void sayHello()
    {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("world", model);
        assertAll(
                ()->assertEquals("world", model.getAttribute("user")),
                ()->assertEquals("hello", result)
        );
    }
}
