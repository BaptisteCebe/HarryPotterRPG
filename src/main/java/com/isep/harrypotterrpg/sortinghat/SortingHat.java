package com.isep.harrypotterrpg.sortinghat;

import java.util.Random;
public class SortingHat {


    public static String choisirMaison() {
        String[] maisons = {"Gryffindor", "Ravenclaw", "Hufflepuff", "Slytherin"};
        Random rand = new Random();
        int index = rand.nextInt(maisons.length);
        return maisons[index];
    }

    public static void main(String[] args) {
        String maisonChoisie = choisirMaison();
        System.out.println("La maison choisie est : " + maisonChoisie);
    }
}
