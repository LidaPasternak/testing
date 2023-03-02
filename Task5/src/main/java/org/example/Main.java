package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read json from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for xml.
public class Main {
    //mvn clean install exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="60"
    public static void main(String[] args) throws IOException {
        //json
        ObjectMapper mapper = new ObjectMapper();
        Person personJson = mapper.readValue(new File("input.json"), Person.class);
        System.out.println("Person reading from input.json: " + personJson.toString());
        FavoriteFood ff = new FavoriteFood();
        ff.setName("Burger");
        ff.setRating(9.5f);
        List<FavoriteFood> favoriteFoods = personJson.getFavoriteFoods();
        favoriteFoods.add(ff);
        personJson.setFavoriteFoods(favoriteFoods);
        System.out.println("Person with changed fields: " + personJson);
        try (FileWriter fileWriter = new FileWriter("output.json")) {
            mapper.writeValue(fileWriter, personJson);
        }

        //xml
        XmlMapper xmlMapper = new XmlMapper();
        File xmlFile = new File("input.xml");
        Person personXml = xmlMapper.readValue(xmlFile, Person.class);
        System.out.println("Person reading from input.xml: " + personXml);
        personXml.setFavoriteFoods(favoriteFoods);
        System.out.println("Person read from xml with changed fields: " + personXml);
        xmlMapper.writeValue(new File("output.xml"), personXml);


        //Stream:
        //a) Generate 10 random object using class from previous class
        //b) Sort it using any two fields using stream.
        //b) Filter it by any two fields custom filter.
        //c) Collect it to List with *main field(s).

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person("Person" + i, new Random().nextInt(Integer.parseInt(args[0])), new Random().nextBoolean()));
        }

        List<Person> sortedPersons = persons.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::isEmployed))
                .toList();

        List<Person> filteredPersons = sortedPersons.stream()
                .filter(person -> person.getAge() > 30 && person.isEmployed())
                .toList();

        List<String> result = filteredPersons.stream()
                .map(person -> person.getName() + ", " + person.getAge() + ", employed: " + person.isEmployed())
                .toList();

        System.out.println(result);
    }
}