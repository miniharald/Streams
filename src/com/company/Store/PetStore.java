package com.company.Store;

import com.company.LivingThings.Person;
import com.company.LivingThings.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    private PetNameGenerator petNameGenerator;
    private List<Person> customers = new ArrayList<>();

    public PetStore(PetNameGenerator petNameGenerator) { this.petNameGenerator = petNameGenerator; }

    public List<Person> getCustomers() { return customers; }

    public void addCustomers(Person newCustomer) { customers.add(newCustomer); }

    public void buy() {
        int amountOfAnimalsBuyed;
        int max = petNameGenerator.getAnimals().length - 1;
        for(Person customer : customers) {
            do{
                amountOfAnimalsBuyed = petNameGenerator.generator(max);
                if(amountOfAnimalsBuyed > 0) {
                    customer.addPets(new Pet(petNameGenerator.giveAnAnimalName(), petNameGenerator.giveAnAnimalAType()));
                    amountOfAnimalsBuyed--;
                }
            } while (amountOfAnimalsBuyed > 0);
        }
    }
}
