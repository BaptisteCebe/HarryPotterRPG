package com.isep.harrypotterrpg.core;

public class Story {

    public enum StoryType {
        Intro,
        Developpement,
        ;

    }

    public Story (){}

    public String getString(StoryType st) {
        String ret = "";
        switch (st) {
            case Intro:
                ret = "Combat contre le BASILIC:\n" +
                        "Stuff de base : Spells, Potions, Fuite\n" +
                        "Choix entre ces 3 propositions (4 pour Grinffondor abvec l'Epée)\n" +
                        "Si le sorcier choisi Spell :\n" +
                        "- Selectionne au choix avec les numéros 1 ou 2 ou 3 le Spell à utiliser (Le nombre de sorts disponibles augmente avec le fait de passer des niveaux,\n" +
                        "on en apprrend un de plus a chaque niveau que l'on passe)--> Inflige des dégats au boss en fonction des dégats du spell\n" +
                        "-CONTRAINTE, Le troll doit obligatoirement être tué avec Wingardium Leviosa. (A voir en terme de difficultée à implanter)";
                break;
            case Developpement:
                ret = "toto";
                break;
            default:
                ret = "Pas de texte trouvé !";
                break;


        }
        return ret;
    }

}


