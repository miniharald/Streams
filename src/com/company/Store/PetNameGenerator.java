package com.company.Store;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PetNameGenerator {

    private List<String> petNames = new ArrayList<>();
    private String[] animals = new String[]{"Cat", "Dog", "Rabbit", "Fish", "Bird"};

    public void readFromFile() {
        try {
            petNames = Files.lines(Paths.get("pet-names.txt"))
                            .flatMap( s ->
                            Stream.of(s.replaceAll("[^a-zA-Z]", " "))
                            )
                            .flatMap( s -> Stream.of(s.split(" "))
                            )
                            .filter(s -> s.length() > 0)
                            .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Something wrong while reading from file!");
            e.printStackTrace();
        }
    }

    String[] getAnimals() { return animals; }

    int generator(int max){ return ThreadLocalRandom.current().nextInt(0, max); }

    String giveAnAnimalName() {
            int i = generator(petNames.size() - 1);
            String name = petNames.get(i);
            petNames.remove(i);
            return name;
    }

    String giveAnAnimalAType() {
            int i = generator(animals.length - 1);
        return animals[i];
    }
}
