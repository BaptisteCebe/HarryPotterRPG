package com.isep.harrypotterrpg.core;



import java.util.List;

public interface InputOutputParser {

    // output interface members
    public boolean DisplayCurrentOpponents(int roundNb);     // used to display opponents
    public String AKindOfDialogBox(String title, String text);                      // used either Console or GUI to ask a value

    // input interface members

}
