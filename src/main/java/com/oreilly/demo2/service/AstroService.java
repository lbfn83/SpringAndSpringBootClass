package com.oreilly.demo2.service;

import com.oreilly.demo2.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.print.attribute.standard.Media;
import java.time.Duration;

@Service

public class AstroService {
    private final RestTemplate template;
    private final WebClient webClient;

//  The argument defined in a class with single constructor
//   Spring will autowire them automatically
    @Autowired
    public AstroService(RestTemplateBuilder rtBuilder, WebClient.Builder wcBuilder) {
        template = rtBuilder.build();
        this.webClient = wcBuilder.baseUrl("http://api.open-notify.org").build();
    }

    public AstroResult getAstronautsRT()
    {
        String url = "http://api.open-notify.org/astros.json";
        return template.getForObject(url, AstroResult.class);
    }

    public AstroResult getAstronautsWC() {
        return webClient.get().uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResult.class)
                .block(Duration.ofSeconds(2));
    }
}
