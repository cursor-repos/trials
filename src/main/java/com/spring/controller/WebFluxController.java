package com.spring.controller;

import java.time.Duration;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class WebFluxController {

    WebClient webClient = WebClient.create("https://restcountries.com/v3.1/");

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/flux")
    public Flux<String> flux() {
        return Flux.just("Hello", "World");
    }

    @GetMapping("/flux/stream")
    public Flux<String> fluxStream() {
        return Flux.just("Hello", "World").delayElements(Duration.ofSeconds(5));
    }
    @GetMapping(value = "/api1")
    public String fluxApi() {
        
        var resp = webClient.get()
        .uri("name/india")
        .retrieve()
        .bodyToFlux(new ParameterizedTypeReference<Map<String, Object>>() {});

       var t = "";
       return t;
        }
}