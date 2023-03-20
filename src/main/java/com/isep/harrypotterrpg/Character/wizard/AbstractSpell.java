package com.isep.harrypotterrpg.Character.wizard;
import lombok.Getter;
import lombok.Setter;


public abstract class AbstractSpell {

    @Getter
    @Setter
    private String nameSpell;
    @Getter
    @Setter
    private float damageSpell;
    @Getter
    @Setter
    private float healSpell;
    @Getter
    @Setter
    private float defenseSpell;
    @Getter
    @Setter
    private float precisionSpell;

    public AbstractSpell(String nameSpell, float damageSpell, float healSpell, float defenseSpell, float precisionSpell){
        this.nameSpell = nameSpell;
        this.damageSpell = damageSpell;
        this.healSpell = healSpell;
        this.defenseSpell = defenseSpell;
        this.precisionSpell = precisionSpell;
    }

}