package com.isep.harrypotterrpg.core;



import com.isep.harrypotterrpg.Character.Character;
import com.isep.harrypotterrpg.Character.wizard.Wizard;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class GUIParser implements InputOutputParser{
    public GUIParser(){
    }

    // output interface members
    public boolean DisplayCurrentOpponents(int roundNb){
        String str="";
        str += "roundNb :"+ roundNb+ "\n\r";
        str += "-----------------------------------"+ "\n\r";
        str += "Heroes"+ "\n\r";
        str += "-----------------------------------"+ "\n\r";

         str += ""+ "\n\r";

        str += "-----------------------------------"+ "\n\r";
        str += "Enemies"+ "\n\r";
        str += "-----------------------------------"+ "\n\r";
       str += ""+ "\n\r";

        Dialog<ButtonType> confirmDialog = new Dialog<>();
        confirmDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
        confirmDialog.setTitle("Etat des troupes");
        confirmDialog.setContentText(str);
        confirmDialog.showAndWait();
        return true;

    }

    public String AKindOfDialogBox(String title, String text){

        Optional<String> result;
        String answer="";
        result = showTheDialog(title, text, "");
        if (result.isPresent()) {
            System.out.println("The user's answer is: " + result.get());
            answer = result.get();
        } else
        {
            System.out.println("The user cancelled the dialog.");
            answer="";
        }
        return answer;
    }

    public boolean DisplayString( String str){
        return true;

    }

    public boolean PlayerInfo(String description,Character w){
        System.out.println("Voixi vos stats");
        System.out.println(w.getLifePoints());
        return true;
    }


    public Optional<String> showTheDialog(String dlgTitle, String dlgQuestion, String dlgDefaultAnswer){
        TextInputDialog dialog = new TextInputDialog(dlgDefaultAnswer);
        dialog.setTitle(dlgTitle);
        dialog.initStyle(StageStyle.DECORATED);
        //dialog.setBackground(new BackgroundFill( Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY));
        dialog.setHeaderText(dlgQuestion);
        dialog.setContentText("Answer:");

        // Show the dialog and get the user's response
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("The user's answer is: " + result.get());
        } else {
            System.out.println("The user cancelled the dialog.");
        }
        return result;
    }
}
