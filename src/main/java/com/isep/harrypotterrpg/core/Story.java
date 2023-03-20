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
                ret = "Bienvenue à l'école des sorciers" +

                        "Aller hop au combat direct";
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


