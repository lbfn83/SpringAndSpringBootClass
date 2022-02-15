package com.oreilly.demo2.json;

// simplest POJO
public class Greeting {
    private final String message;

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

    @Override
    public String toString()
    {
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }

}
