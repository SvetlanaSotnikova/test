package org.azzure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;

/**
 * Hello world!
 */
public class App {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] words = {"hi, planet"};
        String message = Joiner.on(", ").join(words);
        System.out.println(message);

        Person person = new Person("Stas", 20);
        try {
            String jString = mapper.writeValueAsString(person);
            System.out.println("serializate Json: " + jString);

            Person desPerson = mapper.readValue(jString, Person.class);
            System.out.println("deserialize Json: " + desPerson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
