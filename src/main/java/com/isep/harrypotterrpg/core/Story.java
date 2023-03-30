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
                ret = "Bienvenue ¤#playerName#¤ à l'école des sorciers" + "\n\r";
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
                ret = "GRIFFONDOR";
                break;
            case HUFFLEPUFF:
                ret = "POUFSOUFFLE";
                break;
            case SLITHERIN:
                ret = "SERPENTARD";
                break;
            case RAVENCLAW:
                ret = "SERDAIGLE";
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
            case CHOUETTE:
                ret = "CHOUETTE";
                break;
            case RAT:
                ret = "RAT";
                break;
            case CHAT:
                ret = "CHAT";
                break;
            case CRAPAUD:
                ret = "CRAPAUD";
                break;
            case DOBY:
                ret = "DOBY";
                break;
        }
        return ret;

    }
}


