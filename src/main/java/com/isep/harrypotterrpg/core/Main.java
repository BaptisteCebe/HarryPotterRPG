package com.isep.harrypotterrpg.core;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.util.Optional;

public class Main extends Application {
    static Game theGame = new Game();              // create instance of class Game

    public static void main(String[] args) {
        //we need to put the choice between console and GUI
        System.out.println("Game Start!");
        if(theGame.isItAGraphicGame())
        {
            System.out.println("Before launch !");
            launch(args);
            System.out.println("After launch !");
        }
        else
        {
            theGame.playGame();                     // call public member that launches the game
        }
        System.out.println("Game Stop!");
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a scene
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 480);

        // Set the scene and show the stage
        primaryStage.setMaximized(true);
        primaryStage.setTitle("miniRPG");
        scene.setFill(Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
        theGame.playGame();                     // call public member that launches the game
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
