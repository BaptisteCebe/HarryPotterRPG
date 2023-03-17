package com.isep.harrypotterrpg.core;


import java.util.List;
import java.util.Scanner;

public class ConsoleParser implements InputOutputParser {

    public ConsoleParser(){
    }

    // output interface members
    public boolean DisplayCurrentOpponents( int roundNb)
    {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("roundNb :"+ roundNb);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("Heroes");
        System.out.println("------------------------------------------------------------------------------------------------------------------");


        System.out.println("");

        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("Enemies");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        System.out.println("");

        return true;
    }

    public String AKindOfDialogBox(String title, String text){
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println(title);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println(text);
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        String answer = sc.nextLine();
        return answer;
    }

}


