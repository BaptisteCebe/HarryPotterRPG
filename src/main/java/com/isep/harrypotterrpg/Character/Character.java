package com.isep.harrypotterrpg.Character;

import lombok.Getter;
import lombok.Setter;


    public abstract class Character{
        @Getter
        @Setter
        private float lifePoints;

        @Getter
        @Setter
        private float damagePoints;
        @Getter
        @Setter
        private float defensePoints;
        @Getter
        @Setter
        private float precisionPoints;

        public Character(float lifePoints, float damagePoints, float defensePoints, float precisionPoints)
        {
            this.lifePoints = lifePoints;
            this.damagePoints = damagePoints;
            this.defensePoints = defensePoints;
            this.precisionPoints = precisionPoints;
        }
    }

