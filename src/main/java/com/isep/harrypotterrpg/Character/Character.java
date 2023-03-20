package com.isep.harrypotterrpg.Character;

import lombok.Getter;
import lombok.Setter;


    public abstract class Character{
        @Getter
        @Setter
        private String nameCharacter;
        @Getter
        @Setter
        private float lifePoints;
        @Getter
        @Setter
        private float maxLifePoints;

        @Getter
        @Setter
        private float damagePoints;
        @Getter
        @Setter
        private float defensePoints;
        @Getter
        @Setter
        private float precisionPoints;
        @Getter
        @Setter
        private float maxPrecisionPoints;

        public Character(String nameCharacter,float lifePoints,float maxLifePoints, float damagePoints, float defensePoints, float precisionPoints, float maxPrecisionPoints)
        {
            this.nameCharacter = nameCharacter;
            this.lifePoints = lifePoints;
            this.maxLifePoints = maxLifePoints;
            this.damagePoints = damagePoints;
            this.defensePoints = defensePoints;
            this.precisionPoints = precisionPoints;
            this.maxPrecisionPoints = maxPrecisionPoints;
        }
     }


