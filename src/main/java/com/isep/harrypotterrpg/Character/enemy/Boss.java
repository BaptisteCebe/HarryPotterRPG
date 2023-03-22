package com.isep.harrypotterrpg.Character.enemy;
import com.isep.harrypotterrpg.Character.Character;
public class Boss extends Character {

    public Boss(String nameCharacter,float lifePoints,float maxLifePoints,float damagePoints, float defensePoints, float precisionPoints, float maxPrecisionPoints){
        super (nameCharacter,lifePoints,maxLifePoints,damagePoints, defensePoints, precisionPoints, maxPrecisionPoints);
    }

    public Boss(String bossnames,float[] bossdata){
        super (bossnames, bossdata[0],bossdata[1],bossdata[2],bossdata[3], bossdata[4], bossdata[5]);
    }

}