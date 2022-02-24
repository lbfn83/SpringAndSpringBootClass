package com.oreilly.demo2.controllers;
import com.oreilly.demo2.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

@Controller("wonjaeController")
@RequestMapping("/post")
public class ExamplePostController {

    private static Logger log = LoggerFactory.getLogger(ExamplePostController.class);


    @Autowired
    ExampleService exampleService;


    @PostMapping("/request")
    public ResponseEntity postController(@RequestBody LoginForm loginForm) {

        log.debug("POST received - serializing LoginForm: " + loginForm.getPassword() + " " + loginForm.getUsername());
        exampleService.fakeAuthenticate(loginForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/response")
    @ResponseBody
    public ResponseTransfer postResponseController(@RequestBody LoginForm loginForm) {

        /*Log debug was not really showing Anything. Belows are to check if each functionality is enabled or not*/
//        System.out.println(log.isDebugEnabled());
//        System.out.println(log.isTraceEnabled());
//        System.out.println(log.isWarnEnabled());
        log.debug("POST received - serializing LoginForm: " + loginForm.getPassword() + " " + loginForm.getUsername());
        return new ResponseTransfer("Thanks For Posting!!!");
    }

    @PostMapping(value = "/content", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseJsonContent(@RequestBody LoginForm loginForm) {
        log.debug("POST received - serializing LoginForm: " + loginForm.getPassword() + " " + loginForm.getUsername());
        return new ResponseTransfer("JSON Content!");
    }

    @PostMapping(value = "/content", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseXmlContent(@RequestBody LoginForm loginForm) {
        log.debug("POST received - serializing LoginForm: " + loginForm.getPassword() + " " + loginForm.getUsername());
        return new ResponseTransfer("XML Content!");
    }
}