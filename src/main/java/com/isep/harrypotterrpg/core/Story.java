package com.isep.harrypotterrpg.core;
import com.isep.harrypotterrpg.Character.wizard.atributs.House;
import com.isep.harrypotterrpg.Character.wizard.atributs.Pet;
import lombok.Getter;
import lombok.Setter;

import java.util.spi.AbstractResourceBundleProvider;

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
                ret = "GRINFFINDOR";
                break;
            case HUFFLEPUFF:
                ret = "RAVENCLAW";
                break;
            case SLITHERIN:
                ret = "HUFFLEPUFF";
                break;
            case RAVENCLAW:
                ret = "SLITHERIN";
                break;
            default:
                ret = "Pas de texte trouvé !";
                break;


        }
        return ret;
    }

    public String getPetString(Pet p){
        String ret = "";
        switch (p) {
            case OWL:
                ret = "OWL";
                break;
            case RAT:
                ret = "RAT";
                break;
            case CAT:
                ret = "CAT";
                break;
            case TOAD:
                ret = "TOAD";
                break;
            case DOBY:
                ret = "DOBY";
                break;
            case DWARF:
                ret = "DWARF";
                break;
        }
        return ret;

    }
}


