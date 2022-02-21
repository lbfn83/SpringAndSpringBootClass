package com.oreilly.demo2.json;
import org.springframework.stereotype.Service;
import com.oreilly.demo2.json.LoginForm;

@Service
public class ExampleService {
    public boolean fakeAuthenticate(LoginForm lf) {
        return true;
    }
}
