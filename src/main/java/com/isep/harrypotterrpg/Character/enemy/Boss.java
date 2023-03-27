package com.isep.harrypotterrpg.Character.enemy;
import com.isep.harrypotterrpg.Character.Character;
import com.isep.harrypotterrpg.core.ConsoleParser;

public class Boss extends Character {



    public static void ListBoss() {

        String[] bossnames = new String[]
                {"Troll", "Basillic", "Détraqueurs", "Voldemort et Peter Pettigrow", "Dolores Ombrage", "Mangemorts", "Voldemort et Bellatrix Lestrange"};

        float[][] bossstats = {
                {100, 50, 60, 80, 100,100},
                {110, 55, 55, 82,110, 101},
                {120, 65, 60, 84,120, 102},
                {130, 50, 50, 50,130, 103},
                {130, 50, 50, 50,140, 104},
                {130, 50, 50, 50, 150,105},
                {130, 50, 50, 50,160, 106},


        };
        for (int i = 0; i < bossnames.length; ++i){
            System.out.println("1) "+bossnames[i]);
            String str="";
            for (int j=0; j<bossstats[0].length; ++j)
                str += (bossstats[i][j] + " ");
            System.out.println("2) "+str);
            Boss theBoss = new Boss(bossnames[i], bossstats[i]);
            ConsoleParser cp = new ConsoleParser();
            cp.BossInfo("3) Boss info", theBoss);


        }
    }

    public Boss(String nameCharacter,float lifePoints,float damagePoints, float defensePoints, float precisionPoints,float maxLifePoints, float maxPrecisionPoints){
        super (nameCharacter,lifePoints,damagePoints, defensePoints, precisionPoints, maxLifePoints, maxPrecisionPoints);
    }

    public Boss(String bossnames,float[] bossdata){
        super (bossnames, bossdata[0],bossdata[1],bossdata[2],bossdata[3], bossdata[4], bossdata[5]);
    }



}