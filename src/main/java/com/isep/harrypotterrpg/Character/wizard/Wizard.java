package com.isep.harrypotterrpg.Character.wizard;
import com.isep.harrypotterrpg.Character.Action;
import com.isep.harrypotterrpg.Character.Character;
import com.isep.harrypotterrpg.Character.Action;
import lombok.Getter;
import lombok.Setter;
public class Wizard extends Character {

    public Wizard(String nameCharacter,float lifePoints,float maxLifePoints,float damagePoints, float defensePoints, float precisionPoints, float maxPrecisionPoints){
        super (nameCharacter,lifePoints,maxLifePoints,damagePoints, defensePoints, precisionPoints, maxPrecisionPoints);

    }


    public boolean HasThisCapacity(Action.HeroAction actionKind){
        boolean ret= false;
        switch(actionKind){
            case Spell1:
                ret = true;
                break;
            case Spell2:
                ret =  true;
                break;
            case Potion:
                ret = true;
                break;
            case RunAway:
                ret = true;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + actionKind);
        }
        return ret;

    }
}


/*pseudo code:

Démarrage de la console : 2 choix
GUI Parser ou Console Parser
-Pour console,

1) Choix du nom du Sorcier
Apres selection du nom du sorcier, en random :
-choix de la maison en random (buffs qui vont avec le choix de cette maison)
-choix de la baguette en radom, taille + core (Si le core est le même que celui de voldemort, ajouter un effet nefaste pour le joueur)
-Choix du pet en randomn (voir enum class Pet)
-Attribution de spells (2 spells de base)

Sorcier devra avoir des statistiques de base, points d'attaque, points de défense, points de précison, et points de vie ainsi que points de vie max
(cap a ne pas dépasser)
Le sorcier meurt quand il a 0 hp ou moins

Entre chaque niveaux du rpg, le sorcier augmente ses statitiques afin de permettre une progression

*Ajout du texte pour romancer l'histoire entre chaque élément


Monde séparé en 7 niveaux.
Entre chaque niveau, "cours" obligatoire pour apprendre un nouveau spell pour le heros. Spell obligatoire pour affronter le boss de chaque niveau

NIVEAU 1

Sort de base obligatoire pour le sorcier : WINGARDIUM LEVIOSA
Combat contre le troll :
Stuff de base : Spells, Potions, Fuite (Je verrai si je peux utiliser la fuite pour une raison valable).
Choix entre ces 3 propositions
Si le sorcier choisi Spell :
-Selectionne au choix avec les numéros 1 ou 2 le Spell à utiliser --> Inflige des dégats au boss en fonction des dégats du spell
-CONTRAINTE, Le troll doit obligatoirement être tué avec Wingardium Leviosa. (A voir en terme de difficultée à implanter)

Si le sorcier choisi Potions:
-Choix entre 4 potions différentes : Heal, Defense, Précision, Damage. Augemnte les statistiques du Sorcier en fonction de la potion choisie
-Potion de Heal ne peux pas être utlisée si le Sorcier est Max HP

Le Sorcier meurt si le Troll le fais descendre en dessous de 0 HP

NIVEAU 2

Sort de base obligatoire pour le sorcier : ACCIO (à apprendre lors du "cours" entre les 2 combats de boss)
Equipement à ajouter pour la famille Griffondor : à ajouter dans le menu des choix d'actions pour Griffondor : Epée de Griffondor
Combat contre le BASILIC:
Stuff de base : Spells, Potions, Fuite
Choix entre ces 3 propositions (4 pour Grinffondor abvec l'Epée)
Si le sorcier choisi Spell :
- Selectionne au choix avec les numéros 1 ou 2 ou 3 le Spell à utiliser (Le nombre de sorts disponibles augmente avec le fait de passer des niveaux,
on en apprrend un de plus a chaque niveau que l'on passe)--> Inflige des dégats au boss en fonction des dégats du spell


Si le sorcier choisi Potions:
-Choix entre 4 potions différentes : Heal, Defense, Précision, Damage. Augemnte les statistiques du Sorcier en fonction de la potion choisie
-Potion de Heal ne peux pas être utlisée si le Sorcier est Max HP

Le Sorcier meurt si le Troll le fais descendre en dessous de 0 HP

 */