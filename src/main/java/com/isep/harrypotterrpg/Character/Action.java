package com.isep.harrypotterrpg.Character;



public class Action {
        // different possible actions of hero (depending it is a warrior, healer ...
        // each subclasses of heroes will use this enum to mention its capacities to game (fight engine)
        public enum HeroAction{
            Spell1,
            Spell2,
            Potion,
            RunAway,
            NONE
        }
    }

