package com.isep.harrypotterrpg.core;
import com.isep.harrypotterrpg.Character.enemy.Boss;
import com.isep.harrypotterrpg.core.ConsoleParser;


public class ArrayList {

    public static void main (String []args ) {

        String[] bossnames = new String[]
                {"Troll", "Basillic", "Détraqueurs", "Voldemort et Peter Pettigrow", "Dolores Ombrage", "Mangemorts", "Voldemort et Bellatrix Lestrange"};

        float[][] bossstats = {
                {100, 100, 50, 50, 80, 100},
                {110, 110, 55, 55, 82, 101},
                {120, 120, 65, 60, 84, 102},
                {130, 130, 50, 50, 50, 103},
                {130, 130, 50, 50, 50, 104},
                {130, 130, 50, 50, 50, 105},
                {130, 130, 50, 50, 50, 106},


        };
        for (int i = 0; i < bossnames.length; ++i){
            System.out.println("1) "+bossnames[i]);
            String str="";
            for (int j=0; j<bossstats[0].length; j++)
                str += (bossstats[i][j] + " ");
            System.out.println("2) "+str);
            Boss theBoss = new Boss(bossnames[i], bossstats[i]);
            ConsoleParser cp = new ConsoleParser();
            cp.PlayerInfo("3) player info", theBoss);


        }
    }
}

        /*String[] boss = new String[7];
        boss[1]= "Troll";
        boss[2]= "Basilic";
        boss[3]= "Détraqueurs";
        boss[4]= "Voldemort et Peter Pettigrow";
        boss[5]= "Dolores Ombrage";
        boss[6]= "Mangemorts";
        boss[7]= "Voldemort et Bellatrix Lestrange";*/

