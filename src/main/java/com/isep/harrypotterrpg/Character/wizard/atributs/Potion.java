package com.isep.harrypotterrpg.Character.wizard.atributs;

import lombok.Getter;
import lombok.Setter;

public class Potion {

    //Attributess
    //Potion définie par un nom, un ajout d'attaque, un ajout de hp, un ajout de defense, ou un ajout de precision
    private String namePotion;
    private float damagePotion;
    @Getter
    @Setter
    private float healPotion;
    @Getter
    @Setter
    private float defensePotion;
    @Getter
    @Setter
    private float precisionPotion;

}



