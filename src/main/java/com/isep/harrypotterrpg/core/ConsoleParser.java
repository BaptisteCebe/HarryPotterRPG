package com.isep.harrypotterrpg.core;


import com.isep.harrypotterrpg.Character.Character;
import com.isep.harrypotterrpg.Character.wizard.AbstractSpell;
import com.isep.harrypotterrpg.Character.wizard.Wizard;
import com.isep.harrypotterrpg.Character.wizard.spell.Spell;
import com.isep.harrypotterrpg.sortinghat.SortingHat;

import java.util.List;
import java.util.Scanner;

public class ConsoleParser implements InputOutputParser {

    public ConsoleParser(){
    }

    // output interface members
    public boolean DisplayCurrentOpponents( int roundNb)
    {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("roundNb :"+ roundNb);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("Heroes");
        System.out.println("------------------------------------------------------------------------------------------------------------------");


        System.out.println("");

        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("Enemies");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        System.out.println("");

        return true;
    }

    public String AKindOfDialogBox(String title, String text){
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println(title);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println(text);
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        String answer = sc.nextLine();
        return answer;
    }

    public boolean DisplayString( String str){
        System.out.println(str);
        return true;

    }

    public boolean PlayerInfo(String description, Character w){
        System.out.println(description);
        System.out.println("Life points : " + w.getLifePoints());
        System.out.println("Damage points : " + w.getLifePoints());
        System.out.println("Damage points : " + w.getDefensePoints());
        System.out.println("Damage points : " + w.getPrecisionPoints());
        System.out.println("");
        return true;
    }

    public boolean SpellInfo(String description, AbstractSpell x){
        System.out.println(description);
        System.out.println("SpellName : " + x.getNameSpell());
        System.out.println("Spell damage : " + x.getDamageSpell());
        System.out.println("Spell heal : " + x.getHealSpell());
        System.out.println("Spell defense : " + x.getDefenseSpell());
        System.out.println("Spell precision : " + x.getPrecisionSpell());
        return true;


    }



}


