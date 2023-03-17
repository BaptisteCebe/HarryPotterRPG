package com.isep.harrypotterrpg.core;

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
