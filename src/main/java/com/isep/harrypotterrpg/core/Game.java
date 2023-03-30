package com.isep.harrypotterrpg.core;
import com.isep.harrypotterrpg.Character.Action;
import com.isep.harrypotterrpg.Character.ActionPotion;
import com.isep.harrypotterrpg.Character.enemy.Boss;
import com.isep.harrypotterrpg.Character.wizard.Wizard;
import com.isep.harrypotterrpg.Character.wizard.atributs.House;
import com.isep.harrypotterrpg.Character.wizard.atributs.Pet;
import com.isep.harrypotterrpg.Character.wizard.atributs.Potion;
import com.isep.harrypotterrpg.Character.wizard.spell.*;
import com.isep.harrypotterrpg.sortinghat.SortingHat;

import java.util.Scanner;


public class Game {

    // Attributes

    final int maxRounds = 7; // max round before boss
    private int curRound = 1; // current round

    private int nbMaxHeroes; // max playable heroes


    //private List<Hero> playerHeroes = new ArrayList<>(); // define list of hero instances of the player

    //private List<Enemy> Enemies = new ArrayList<>(); // define list of enemy instances
    //private int nbEnemies; // nb enemies


    private DispatcherParser theDispatcherParser;


    // Constructor function
    public Game() {
        this.theDispatcherParser = new DispatcherParser();

    }

    public boolean isItAGraphicGame() {
        return this.theDispatcherParser.getIsGUI();
    }

    // Public Members
    public boolean playGame() { // play the whole game
        boolean ret = false;


        SortingHat theSortingHat = new SortingHat();
        House theHouse = theSortingHat.randHouse();
        Story theStory = new Story();
        Action.HeroAction playerAction = null;
        Pet thePet = theSortingHat.randPet();
        Scanner scanner = new Scanner(System.in);



        String playerName = this.theDispatcherParser.AKindOfDialogBox("Choix du nom", "Veuillez saisir le nom de votre sorcier (max:20 caractères).");
        theStory.setPlayerName(playerName);
        this.theDispatcherParser.DisplayString(theStory.getString(Story.StoryType.Intro));
        System.out.println("");
        this.theDispatcherParser.DisplayString("Le choipeau vous a assigné a la maison " + theStory.getHouseString(theHouse));
        System.out.println("");
        this.theDispatcherParser.DisplayString("Vous avec comme animal pour vous acompagner au cous de cette aventure un : " + theStory.getPetString(thePet));


        Wizard player = new Wizard(playerName, 100f, 10f, 10f, 50f, 100f, 100f);
        Spell spell1 = new Spell("WINGARDIUM LEVIOSA", 20f, 0f, 0f, 0f);
        Spell spell2 = new Spell("REPARO", 20f, 10f, 10f, 15f);

        Potion healpotion = new Potion("Heal Potion", 0f, 50f, 0f, 0f);
        Potion damagepotion = new Potion("Damage Potion", 20f, 0f, 0f, 0f);
        Potion defensepotion = new Potion("Damage Potion", 0f, 0f, 20f, 0f);
        Potion precisionpotion = new Potion("Damage Potion", 0f, 0f, 0f, 10f);

        int currentLevel = 0;
        boolean playerIsAlive =true;
        Bosses bosses = new Bosses();

        while (currentLevel< bosses.bossnames.length && playerIsAlive)
        {
            String theCurrentBossName = bosses.bossnames[currentLevel];
            float[] theCurrentBossStats = bosses.bossstats[currentLevel];
            // Boss boss = new Boss("Troll", 100f, 100f, 50f, 100f, 80f, 100f);
            Boss boss = new Boss(theCurrentBossName, theCurrentBossStats[0], theCurrentBossStats[1], theCurrentBossStats[2], theCurrentBossStats[3], theCurrentBossStats[4], theCurrentBossStats[5]);


            System.out.println("");
            this.theDispatcherParser.PlayerInfo("Voici vos statistiques", player);
            System.out.println("");

            this.theDispatcherParser.SpellInfo("Voici les stats de votre premier sort", spell1);
            System.out.println("");

            this.theDispatcherParser.SpellInfo("Voici les stats de votre second sort", spell2);
            System.out.println("");

            this.theDispatcherParser.PlayerInfo("Voici les stats du Boss que vous affrontez", boss);
            while (player.getLifePoints() > 0 && boss.getLifePoints() > 0) {

                System.out.println("Le combat commence");

                Action.HeroAction newPlayerAction = theDispatcherParser.AskAction(player);
                if (newPlayerAction == Action.HeroAction.Spell1) {
                    boss.setLifePoints(boss.getLifePoints() - (spell1.getDamageSpell() + player.getDamagePoints()));
                    this.theDispatcherParser.DisplayString("Le boss a " + boss.getLifePoints() + "hp");
                }

                if (newPlayerAction == Action.HeroAction.Spell2) {
                    boss.setLifePoints(boss.getLifePoints() - (spell2.getDamageSpell() + player.getDamagePoints()));
                    this.theDispatcherParser.DisplayString("Le boss a " + boss.getLifePoints() + "hp");
                }

                if (newPlayerAction == Action.HeroAction.Potion) {

                    player.setLifePoints(player.getLifePoints() + healpotion.getHealPotion());
                    this.theDispatcherParser.DisplayString("Vous avez " + player.getLifePoints() + "hp");
                }

                System.out.println("");
                System.out.println("Le boss attaque à son tour");
                System.out.println("Vous recevez des dégats");
                player.setLifePoints(player.getLifePoints() - (boss.getDamagePoints()/(player.getDefensePoints()*0.15f)));
                this.theDispatcherParser.DisplayString("Vous avez " + player.getLifePoints() + "hp");
                System.out.println("");

            }


            if (player.getLifePoints() > 0 && boss.getLifePoints() <= 0)
            {
                this.theDispatcherParser.DisplayString("Fin du niveau, vous passez au niveau suivant");
                currentLevel += 1;
            }
            else
            {
                this.theDispatcherParser.DisplayString("Fin de partie, vous êtes morts");
                playerIsAlive=false;
            }
            if(playerIsAlive)
            {
                // reset player stat
                player.setLifePoints(player.getMaxLifePoints());
                // improve selectif
                String improveChoice = this.theDispatcherParser.AKindOfDialogBox("Choix de l'amélioration", "Souhaitez améliorer : [1]HP, [2]Damage, [3]Defense, [4]Precision");
                if (improveChoice.equals("1"))
                {
                    player.setMaxLifePoints(player.getMaxLifePoints() * 1.5f);
                    player.setLifePoints(player.getMaxLifePoints());
                    spell1.setDamageSpell(spell1.getDamageSpell() * 1.5f);
                    spell2.setDamageSpell(spell2.getDamageSpell() * 1.5f);
                }
                else if (improveChoice.equals("2"))
                {
                    player.setDamagePoints(player.getDamagePoints() * 1.5f);
                }

                else if (improveChoice.equals("3"))
                {
                    player.setDefensePoints(player.getDefensePoints() * 1.5f);
                }

                else if (improveChoice.equals("4"))
                {
                    player.setPrecisionPoints(player.getPrecisionPoints() * 1.5f);
                }
            }
        }
        if (player.getLifePoints() > 0)
        {
            this.theDispatcherParser.AKindOfDialogBox("Fin de partie", "Vous avez gagné !");
        }
        else
        {
            this.theDispatcherParser.AKindOfDialogBox("Fin de partie", "Vous êtes morts, réessayez !");
        }
        return ret;
    }

}



