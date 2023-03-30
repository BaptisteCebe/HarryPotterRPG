package com.isep.harrypotterrpg.core;


import com.isep.harrypotterrpg.Character.Action;
import com.isep.harrypotterrpg.Character.ActionPotion;
import com.isep.harrypotterrpg.Character.Character;
import com.isep.harrypotterrpg.Character.enemy.Boss;
import com.isep.harrypotterrpg.Character.wizard.AbstractSpell;
import com.isep.harrypotterrpg.Character.wizard.Wizard;
import com.isep.harrypotterrpg.Character.wizard.atributs.Potion;
import com.isep.harrypotterrpg.Character.wizard.atributs.Potion;
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
            System.out.println(w.getNameCharacter() + "\t\t\tPoints de vie: " + w.getLifePoints()+ ",\t\t\tDégats: " + w.getDamagePoints()+",\t\t\tDéfense: "+w.getDefensePoints()+",\t\t\tPrécision: "+w.getPrecisionPoints());
            System.out.println("");

        }


        return true;
    }



    public boolean SpellInfo(String description, AbstractSpell x){
        if(false) {
            System.out.println(description);
            System.out.println("SpellName : " + x.getNameSpell());
            System.out.println("Spell damage : " + x.getDamageSpell());
            System.out.println("Spell heal : " + x.getHealSpell());
            System.out.println("Spell defense : " + x.getDefenseSpell());
            System.out.println("Spell precision : " + x.getPrecisionSpell());
        }
        else {
            System.out.println(description);
            System.out.println(x.getNameSpell() + "\t\t\tPoints de vie: " + x.getHealSpell() + "\t\t\tDégats: " + x.getDamageSpell() + "\t\t\tDéfense: " + x.getDefenseSpell() + "\t\t\tPrécision: " + x.getPrecisionSpell());
            System.out.println("");
        }
        return true;


    }

    public Action.HeroAction AskAction(Wizard wizard){
        Action.HeroAction ret = Action.HeroAction.NONE;
        while(ret == Action.HeroAction.NONE){


            String text = "Actions : ";
            String title = "Que souhaitez vous utiliser ?";
            if (wizard.HasThisCapacity(Action.HeroAction.Spell1) ){
                text += "[1] Spell 1, ";
            }
            if (wizard.HasThisCapacity(Action.HeroAction.Spell2) ){
                text += "[2] Spell 2, ";
            }
            if (wizard.HasThisCapacity(Action.HeroAction.Potion)){
                text += "[3] Potions, ";
            }
            if (wizard.HasThisCapacity(Action.HeroAction.RunAway) ){
                text += "[4] Fuite, ";
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

        /*public ActionPotion.HeroPotion AskPotion(Potion potion)    {
            ActionPotion.HeroPotion ret = ActionPotion.HeroPotion.NONE;
            while(ret == ActionPotion.HeroPotion.NONE){

                String text = "Hi , ";
                String title = "Choose the Potion";
                if (potion.HasThisPotion(ActionPotion.HeroPotion.healPotion) ){
                    text += "'[1]Heal Potion', ";
                }
                if (potion.HasThisPotion(ActionPotion.HeroPotion.damagePotion) ){
                    text += "'[2]damage Potion', ";
                }
                if (potion.HasThisPotion(ActionPotion.HeroPotion.defensePotion)){
                    text += "'[3]Potion de défense', ";
                }
                if (potion.HasThisPotion(ActionPotion.HeroPotion.precisionPotion) ){
                    text += "'[4]Potion de précision', ";
                }
                String userInput = AKindOfDialogBox(title, text).toLowerCase().trim();
                switch (userInput) {
                    case "1":
                        System.out.println("Le joueur lance un sort");
                        ret = ActionPotion.HeroPotion.healPotion;
                        break;

                    case "2":
                        System.out.println("Le joueur lance un sort");
                        ret = ActionPotion.HeroPotion.damagePotion;
                        break;

                    case "3":
                        System.out.println("Le joueur boit une potion");
                        ret = ActionPotion.HeroPotion.defensePotion;
                        break;

                    case "4":
                        System.out.println("Le joueur prend la fuite");
                        ret = ActionPotion.HeroPotion.precisionPotion;
                        break;
                    default:
                        ret = ActionPotion.HeroPotion.NONE;
                        DisplayString("Choix de l'action, vous devez choisir une des actions proposées");
                }

            }*/
            return ret;

        }



}




