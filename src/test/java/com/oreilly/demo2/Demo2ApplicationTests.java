package com.oreilly.demo2;

import static org.junit.jupiter.api.Assertions.*;

import com.oreilly.demo2.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;


@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    private ApplicationContext context;
    @Test
    void contextLoads() {
        assertNotNull(context);
        System.out.println(context.getClass().getName());
        int count = context.getBeanDefinitionCount();
        System.out.println("There are " + count +
                " beans in the spplication context");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(eachBean -> {System.out.println(eachBean);});
    }
//  @Component annotation in Greeting class will fail below test
    @Test
    void noGreetingInAppCtx(){
//        Below will throw exception when there is no annotation in Greeting class and so forth will fail the test
//        Greeting greeting = context.getBean(Greeting.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(Greeting.class));
    }

    @Test
    void getBeanTwice()
    {
        Greeting greeting1 = context.getBean("defaultGreeting",Greeting.class);
        Greeting greeting2 = context.getBean("whatUpGreeting",Greeting.class);
//        greeting1.setMessage("What up?");
        System.out.println(greeting1.getMessage());
        System.out.println(greeting2.getMessage());
//        assertSame(greeting1, greeting2);
    }
}
