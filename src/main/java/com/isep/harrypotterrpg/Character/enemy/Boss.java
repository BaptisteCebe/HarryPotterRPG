package com.isep.harrypotterrpg.Character.enemy;
import com.isep.harrypotterrpg.Character.Character;
public class Boss extends Character {

    public Boss(String nameCharacter,float lifePoints,float maxLifePoints,float damagePoints, float defensePoints, float precisionPoints, float maxPrecisionPoints){
        super (nameCharacter,lifePoints,maxLifePoints,damagePoints, defensePoints, precisionPoints, maxPrecisionPoints);
    }
}