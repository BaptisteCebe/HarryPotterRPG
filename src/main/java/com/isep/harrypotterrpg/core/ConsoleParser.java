package com.isep.harrypotterrpg.core;


import com.isep.harrypotterrpg.Character.Action;
import com.isep.harrypotterrpg.Character.Character;
import com.isep.harrypotterrpg.Character.enemy.Boss;
import com.isep.harrypotterrpg.Character.wizard.AbstractSpell;
import com.isep.harrypotterrpg.Character.wizard.Wizard;
import com.isep.harrypotterrpg.Character.wizard.spell.Spell;
import com.isep.harrypotterrpg.sortinghat.SortingHat;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
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
        if(false) {
            System.out.println(description);
            System.out.println("Votre nom : " + w.getNameCharacter());
            System.out.println("Life points : " + w.getLifePoints());
            System.out.println("Damage points : " + w.getDamagePoints());
            System.out.println("Defense points : " + w.getDefensePoints());
            System.out.println("Precision points : " + w.getPrecisionPoints());
            System.out.println("");
        }
        else {
            System.out.println(description);
            System.out.println(w.getNameCharacter() + "\t\t\tHP: " + w.getLifePoints()+ ",\t\t\tDa: " + w.getDamagePoints()+",\t\t\tDe: "+w.getDefensePoints()+",\t\t\tPr: "+w.getPrecisionPoints());
            System.out.println("");

        }


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

    public Action.HeroAction AskAction(Wizard wizard){
        Action.HeroAction ret = Action.HeroAction.NONE;
        while(ret == Action.HeroAction.NONE){


            String text = "Hi , ";
            String title = "Choose the Action";
            if (wizard.HasThisCapacity(Action.HeroAction.Spell1) ){
                text += "'[1]Spell1', ";
            }
            if (wizard.HasThisCapacity(Action.HeroAction.Spell2) ){
                text += "'[2]Spell2', ";
            }
            if (wizard.HasThisCapacity(Action.HeroAction.Potion)){
                text += "'[3]Potions', ";
            }
            if (wizard.HasThisCapacity(Action.HeroAction.RunAway) ){
                text += "'[4]RunAway', ";
            }
            String userInput = AKindOfDialogBox(title, text).toLowerCase().trim();
            switch (userInput) {
                case "1":
                    System.out.println("Le joueur lance un sort");
                    ret = Action.HeroAction.Spell1;
                    break;

                case "2":
                    System.out.println("Le joueur lance un sort");
                    ret = Action.HeroAction.Spell2;
                    break;

                case "3":
                    System.out.println("Le joueur boit une potion");
                    ret = Action.HeroAction.Potion;
                    break;

                case "4":
                    System.out.println("Le joueur prend la fuite");
                    ret = Action.HeroAction.RunAway;
                    break;
                default:
                    ret = Action.HeroAction.NONE;
                    DisplayString("Choix de l'action, vous devez choisir une des actions proposées");
            }

        }


        return ret;


    }



}


