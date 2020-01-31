package com.company.LivingThings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

public class Person {
    private String name;
    private int age;
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addPets(Pet newPet) { pets.add(newPet); }

    public String getName() { return name; }

    public int getPetsSize() { return pets.size(); }

    public String toString() {
        if(pets.size() > 1) {
            return String.format("%s (%d) owns the animals: %s", name, age, pets.stream()
                    .collect(groupingBy(Pet::getTypeOfAnimal))
                    .entrySet()
                    .stream().map(o -> "[" + o.getKey() + ":" + o.getValue().stream().map(Pet::getName).collect(Collectors.joining(", ")) + "]")
                    .collect(Collectors.joining(" ")));
        } else if (pets.size() == 1) {
            return String.format("%s (%d) owns the %s: %s", name, age, pets.get(0).getTypeOfAnimal(), pets.get(0).getName());
        }
        return String.format("%s (%d) doesn't own any animal", name, age);
    }
}
