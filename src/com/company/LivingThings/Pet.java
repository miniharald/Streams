package com.company.LivingThings;

public class Pet {
    private String name;
    private String typeOfAnimal;

    public Pet(String name, String typeOfAnimal) {
        this.name = name;
        this.typeOfAnimal = typeOfAnimal;
    }

    public String getName() { return name; }

    String getTypeOfAnimal() { return typeOfAnimal; }

    @Override
    public String toString() { return typeOfAnimal + ": " + name; }
}
