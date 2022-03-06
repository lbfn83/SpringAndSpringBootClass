package com.oreilly.demo2.service;

import com.oreilly.demo2.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroService {
    private final RestTemplate template;

//  The argument defined in a class with single constructor
//   Spring will autowire them automatically
    @Autowired
    public AstroService(RestTemplateBuilder rtBuilder) {
        template = rtBuilder.build();
    }

    public AstroResult getAstronauts()
    {
        String url = "http://api.open-notify.org/astros.json";
        return template.getForObject(url, AstroResult.class);
    }
}
