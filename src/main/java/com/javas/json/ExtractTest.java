package com.javas.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ExtractTest {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(new File("src/main/java/com/javas/json/t1.json"));
            var ls1 = getEmployeesWithSkill(root.get("employees"), "Java");
            System.out.println(ls1.toString());

            var r2 = getMostCommonSkill(root.get("employees"));
            System.out.println(r2 );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getEmployeesWithSkill(JsonNode root, String skill){
        List<String> ls = new ArrayList<>();
        List<String> ls1 = new ArrayList<>();

        for(JsonNode e1: root){
                ls1 = StreamSupport.stream(e1.get("skills").spliterator(), false)
                        .map(JsonNode::asText)
                        .collect(Collectors.toList());
                if(ls1.contains(skill)){
                    ls.add(e1.get("name").asText());
                }
        }
        return ls;
    }

    public static String getMostCommonSkill(JsonNode root){
        Map<String, Integer> hm = new HashMap<>();
        for(JsonNode e1: root){
            StreamSupport.stream(e1.get("skills").spliterator(), false)
                    .map(JsonNode::asText)
                    .forEach( e -> hm.put(e, hm.getOrDefault(e, 0) + 1));
        }
        System.out.println(hm.entrySet());

        hm.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(2)
                    .forEach(System.out::println);

        return "";
    }
}
