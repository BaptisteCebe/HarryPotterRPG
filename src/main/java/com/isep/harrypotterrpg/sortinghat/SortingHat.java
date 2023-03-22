package com.isep.harrypotterrpg.sortinghat;

import com.isep.harrypotterrpg.Character.wizard.atributs.House;
import com.isep.harrypotterrpg.Character.wizard.atributs.Pet;

import java.util.Random;
public class SortingHat {

    public SortingHat(){};

    public  House randHouse() {
        Random random = new Random();
        House[] house = House.values();
        House house_random = house[random.nextInt(house.length)];
        return house_random;


    }


    public Pet randPet(){
        Random random = new Random();
        Pet[] pet = Pet.values();
        Pet pet_random = pet[random.nextInt(pet.length)];
        return pet_random;
    }

}
