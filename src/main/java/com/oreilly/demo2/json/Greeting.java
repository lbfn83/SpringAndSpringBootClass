package com.oreilly.demo2.json;

import org.springframework.stereotype.Component;

// simplest POJO
//@Component
public class Greeting {
    private String message;

    // For deserialisation purposes this class must have a zero-arg constructor
//    otherwise, in functional testing in REST will give you error => JSON parse error: Cannot construct instance of `com.oreilly.demo2.json.Greeting`
    public Greeting()
    {
        this.message = "";
    }
    public Greeting(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }

//    This part is not going to be visible in client computer via HTTP request and response
//    They are always looking at getter
    @Override
    public String toString()
    {
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }

}
