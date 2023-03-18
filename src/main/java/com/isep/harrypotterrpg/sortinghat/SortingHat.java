package com.isep.harrypotterrpg.sortinghat;

import com.isep.harrypotterrpg.Character.wizard.atributs.House;

import java.util.Random;
public class SortingHat {


    public static House randHouse() {
        Random random = new Random();
        House[] house = House.values();
        House house_random = house[random.nextInt(house.length)];
        System.out.println("Le choipeaux vous a assigné à la maison" + house_random);
        return house_random;


    }




}
