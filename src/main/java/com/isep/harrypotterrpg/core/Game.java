package com.isep.harrypotterrpg.core;
import com.isep.harrypotterrpg.Character.Action;
import com.isep.harrypotterrpg.Character.Character;
import com.isep.harrypotterrpg.Character.enemy.Boss;
import com.isep.harrypotterrpg.Character.wizard.Wizard;
import com.isep.harrypotterrpg.Character.wizard.atributs.House;
import com.isep.harrypotterrpg.Character.wizard.atributs.Pet;
import com.isep.harrypotterrpg.Character.wizard.spell.*;
import com.isep.harrypotterrpg.core.ArrayList;
import com.isep.harrypotterrpg.core.DispatcherParser;
import com.isep.harrypotterrpg.core.Story;
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
        this.theDispatcherParser.DisplayString("Bienvenue à " + theStory.getHouseString(theHouse));
        this.theDispatcherParser.DisplayString("Vous avec comme animal pour vous acompagner au cous de cette aventure un : " + theStory.getPetString(thePet));


        Wizard player = new Wizard(playerName, 60f, 60f, 20f, 50f, 80, 100f);
        Boss boss = new Boss("Troll", 100f, 100f, 50f, 100f, 80f, 100f);

        Spell spell = new Spell("WINGARDIUM LEVIOSA", 10f, 10f, 10f, 15f);

        Spell spell2 = new Spell("REPARO", 10f, 10f, 10f, 15f);
        System.out.println("");
        this.theDispatcherParser.PlayerInfo("Voici vos stats", player);
        System.out.println("");

        this.theDispatcherParser.SpellInfo("Voixi les stats de votre premier sort", spell);
        System.out.println("");

        this.theDispatcherParser.SpellInfo("Voixi les stats de votre second sort", spell2);
        System.out.println("");

        this.theDispatcherParser.PlayerInfo("Voici les stats du Boss", boss);
        while (player.getLifePoints() > 0 && boss.getLifePoints() > 0) {

            System.out.println("Le combat commence");
            System.out.println("Que voulez vous faire");
            playerAction = theDispatcherParser.AskAction(player);





        }



        if (player.getLifePoints() > 0 && boss.getLifePoints() < 0) {
            this.theDispatcherParser.AKindOfDialogBox("Fin de partie", "Vous passez au niveau suivant");
        } else {
            this.theDispatcherParser.AKindOfDialogBox("Fin de partie", "You loose : no more heroes are alive ... Try again !");
        }
        return ret;
    }

    }



