package com.isep.harrypotterrpg.Character.wizard.atributs;
import com.isep.harrypotterrpg.Character.ActionPotion;
import com.isep.harrypotterrpg.Character.wizard.atributs.Potion;

import com.isep.harrypotterrpg.Character.Action;
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


    public Potion(String namePotion, float damagePotion, float healPotion, float defensePotion, float precisionPotion){
        this.namePotion = namePotion;
        this.damagePotion = damagePotion;
        this.healPotion = healPotion;
        this.defensePotion = defensePotion;
        this.precisionPotion = precisionPotion;
    }

    public boolean HasThisPotion(ActionPotion.HeroPotion potionKind) {
        boolean ret = false;
        switch (potionKind) {
            case damagePotion:
                ret = true;
                break;
            case healPotion:
                ret = true;
                break;
            case defensePotion:
                ret = true;
                break;
            case precisionPotion:
                ret = true;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + potionKind);
        }
        return ret;
    }
}




