package com.javas.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> ls = new ArrayList<>();

        try {
            JsonNode node = mapper.readTree(new File("src/main/java/com/javas/json/t1.json"));
            System.out.println(node.get("department"));

            JsonNode employees = node.get("employees");
            for(JsonNode emp : employees){
               // System.out.println(emp.get("name"));
                System.out.printf("%s - %s %n",emp.get("id"),emp.get("name"));
                ls.add(emp);
            }

            Employee e1 = mapper.treeToValue(ls.get(0), Employee.class);
            System.out.println(e1.role);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
