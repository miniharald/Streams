package com.company;

import com.company.LivingThings.Person;
import com.company.Store.PetNameGenerator;
import com.company.Store.PetStore;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Program {
    private PetNameGenerator petNameGenerator = new PetNameGenerator();
    private PetStore petStore = new PetStore(petNameGenerator);

    Program() {
        petNameGenerator.readFromFile();
        loadCustomers();
        petStore.buy();
        printResults();
    }

    private void loadCustomers() {
        petStore.addCustomers(new Person("Alexander", 35));
        petStore.addCustomers(new Person("Kristina", 34));
        petStore.addCustomers(new Person("Mats", 57));
        petStore.addCustomers(new Person("Ann-Louise", 56));
        petStore.addCustomers(new Person("Joachim", 31));
        petStore.addCustomers(new Person("Birgitta", 75));
        petStore.addCustomers(new Person("Cecilia", 51));
        petStore.addCustomers(new Person("Elias", 20));
        petStore.addCustomers(new Person("Noah", 18));
        petStore.addCustomers(new Person("Linus", 29));
        petStore.addCustomers(new Person("Christoffer", 35));
        petStore.addCustomers(new Person("Max", 34));
        petStore.addCustomers(new Person("Emil", 34));
        petStore.addCustomers(new Person("Martina", 33));
        petStore.addCustomers(new Person("Fredrik", 34));
        petStore.addCustomers(new Person("Erik", 30));
        petStore.addCustomers(new Person("Charlotte", 52));
        petStore.addCustomers(new Person("Mari", 37));
        petStore.addCustomers(new Person("Tommy", 38));
        petStore.addCustomers(new Person("Hanna", 32));
    }

    private void printResults() {
        System.out.println("Results 1:");
        List<Person> res1 = petStore.getCustomers().stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
        res1.forEach(System.out::println);

        System.out.println("\nResults 2:");
        List<Person> res2 = petStore.getCustomers().stream()
                .sorted((Comparator.comparing(Person::getName)))
                .collect(Collectors.toList());
        res2.forEach(System.out::println);

        System.out.println("\nResults 3:");
        List<Person> res3 = petStore.getCustomers().stream()
                .sorted(Comparator.comparing(Person::getPetsSize))
                .filter(s -> s.getPetsSize() > 0)
                .collect(Collectors.toList());
        res3.forEach(System.out::println);
    }
}
