package com.isep.harrypotterrpg.Character.wizard.spell;
import com.isep.harrypotterrpg.Character.wizard.AbstractSpell;
import lombok.Getter;
import lombok.Setter;

public class Spell extends AbstractSpell{

    public Spell(String nameSpell, float damageSpell, float healSpell, float defenseSpell, float precisionSpell) {
        super(nameSpell, damageSpell, healSpell, defenseSpell, precisionSpell);
    }
}

