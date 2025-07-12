package com.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SyncController {

    WebClient webClient = WebClient.create("https://restcountries.com/v3.1/");
    RestTemplate restTemplate = new RestTemplate();
    RestClient restClient = RestClient.builder().baseUrl("https://restcountries.com/v3.1/").build();

    ObjectMapper mapper = new ObjectMapper();
    JsonNode root;

    @GetMapping(value = "/api1")
    public String fluxApi() {

        String result = "";
        List<String> ls = new ArrayList<>();
        Mono<String> resp = webClient.get().
                uri("currency/dollar")
                .retrieve()
                .bodyToMono(String.class);

        try {
            root = mapper.readTree(resp.block().toString());
            if (root.isArray()) {
                for (JsonNode entry : root) {
                    ls.add(entry.get("name").get("common").textValue());
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        ls.stream().forEach(System.out::println);

        return result;
    }

    @GetMapping(value = "/api2")
    public String restClientApi() {

        String result = "";
        List<String> ls = new ArrayList<>();

        String resp = restClient.get().uri("currency/dollar").retrieve().body(String.class);

        try {
            root = mapper.readTree(resp);
            if (root.isArray()) {
                for (JsonNode entry : root) {
                    ls.add(entry.get("name").get("common").textValue());
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        ls.stream().forEach(System.out::println);

        return result;
    }

    @GetMapping(value = "/api3")
    public String restTemplateApi() {

        String result = "";
        List<String> ls = new ArrayList<>();

        String resp = restTemplate.getForObject("https://restcountries.com/v3.1/currency/dollar", String.class);

        try {
            root = mapper.readTree(resp);
            if (root.isArray()) {
                for (JsonNode entry : root) {
                    ls.add(entry.get("name").get("common").textValue());
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        ls.stream().forEach(System.out::println);

        return result;
    }


}
