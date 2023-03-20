package com.isep.harrypotterrpg.core;
import com.isep.harrypotterrpg.Character.wizard.atributs.House;
import lombok.Getter;
import lombok.Setter;
public class Story {

    public enum StoryType {
        Intro,
        Developpement,
        ;

    }
    @Getter
    @Setter
    private String playerName;

    public Story (){

    }

    public String getString(StoryType st) {
        String ret = "";
        switch (st) {
            case Intro:
                ret = "Bienvenue ¤#playerName#¤ à l'école des sorciers" + "\n\r" +


                        "Maintenant que tu est un sorcier, afronte ce troll avec seulement 2 sorts";
                break;
            case Developpement:
                ret = "toto";
                break;
            default:
                ret = "Pas de texte trouvé !";
                break;


        }
        return ret.replace("¤#playerName#¤", this.playerName);
    }

    public String getHouseString(House h) {
        String ret = "";
        switch (h) {
            case GRIFFINDOR:
                ret = "Griffondor";
                break;
            case HUFFLEPUFF:
                ret = "toto";
                break;
            case SLITHERIN:
                ret = "toto1";
                break;
            case RAVENCLAW:
                ret = "toto2";
                break;
            default:
                ret = "Pas de texte trouvé !";
                break;


        }
        return ret;
    }

}


