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

        public Character(float lifePoints, float damagePoints)
        {
            this.lifePoints = lifePoints;
            this.damagePoints = damagePoints;
        }
    }

