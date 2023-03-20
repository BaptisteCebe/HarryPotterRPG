package com.isep.harrypotterrpg.core;

import com.isep.harrypotterrpg.Character.Character;
import com.isep.harrypotterrpg.Character.wizard.AbstractSpell;

import com.isep.harrypotterrpg.Character.wizard.Wizard;
import com.isep.harrypotterrpg.Character.wizard.spell.Spell;
import com.isep.harrypotterrpg.sortinghat.SortingHat;

import java.util.List;

public class DispatcherParser implements InputOutputParser{

    private boolean isGUI=false; // will store if GUI was chosen
    private ConsoleParser theConsoleParser = new ConsoleParser(); // will store instance of a consoleParser
    private GUIParser theGUIParser = new GUIParser(); // will store instance of a com.example.minirpgfinal.GUIParser

    public boolean getIsGUI(){return isGUI;}

    public DispatcherParser(){
        var ret = theConsoleParser.AKindOfDialogBox("Mode d'IHM", "Voulez vous une interface graphique [G]UI ou [C]onsole ?");
        if (ret.equals("G"))
            isGUI = true;
        else
            isGUI=false;
        System.out.println(isGUI);
    }

    // output interface members
    public boolean DisplayCurrentOpponents( int roundNb){

        boolean ret=false;
        if (isGUI)
            ret = theGUIParser.DisplayCurrentOpponents( roundNb);
        else
            ret = theConsoleParser.DisplayCurrentOpponents( roundNb);
        return true;
    }

    public boolean DisplayString( String str){

        boolean ret=false;
        if (isGUI)
            ret = theGUIParser.DisplayString( str);
        else
            ret = theConsoleParser.DisplayString( str);
        return true;
    }


    public boolean PlayerInfo(String description, Character w){

        boolean ret=false;
        if (isGUI)
            ret = theGUIParser.PlayerInfo(description,w);
        else
            ret = theConsoleParser.PlayerInfo(description,w);
        return true;
    }

    public boolean SpellInfo(String description, AbstractSpell x){

        boolean ret=false;
        if (isGUI)
            ret = theGUIParser.SpellInfo(description,x);
        else
            ret = theConsoleParser.SpellInfo(description,x);
        return true;
    }



    public String AKindOfDialogBox(String title, String text){

        String answer="";
        if (isGUI)
            answer = theGUIParser.AKindOfDialogBox(title, text);
        else
            answer = theConsoleParser.AKindOfDialogBox(title, text);


        return answer;
    }




    // input interface members



}
