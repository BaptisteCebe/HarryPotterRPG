package com.isep.harrypotterrpg.core;
import com.isep.harrypotterrpg.Character.Action;
import com.isep.harrypotterrpg.Character.enemy.Boss;
import com.isep.harrypotterrpg.Character.wizard.Wizard;
import com.isep.harrypotterrpg.Character.wizard.atributs.House;
import com.isep.harrypotterrpg.Character.wizard.atributs.Pet;
import com.isep.harrypotterrpg.Character.wizard.spell.*;
import com.isep.harrypotterrpg.core.DispatcherParser;
import com.isep.harrypotterrpg.core.Story;
import com.isep.harrypotterrpg.sortinghat.SortingHat;


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
    public Game(){
        this.theDispatcherParser = new DispatcherParser();

    }

    public boolean isItAGraphicGame(){
        return this.theDispatcherParser.getIsGUI();
    }

    // Public Members
    public boolean playGame() { // play the whole game
        boolean ret = false;


        SortingHat theSortingHat = new SortingHat();
        House theHouse = theSortingHat.randHouse();
        Story theStory = new Story();
        Action.HeroAction playerAction;
        Pet thePet = theSortingHat.randPet();


        String playerName = this.theDispatcherParser.AKindOfDialogBox("Choix du nom", "Veuillez saisir le nom de votre sorcier (max:20 caractères).");
        theStory.setPlayerName(playerName);
        this.theDispatcherParser.DisplayString(theStory.getString(Story.StoryType.Intro));
        this.theDispatcherParser.DisplayString("Bienvenue à " + theStory.getHouseString(theHouse));
        this.theDispatcherParser.DisplayString("Vous avec comme animal pour vous acompagner au cous de cette aventure un : "+ theStory.getPetString(thePet));


        Wizard player = new Wizard(playerName, 60f,60f,20f, 50f, 80, 100f);
        Boss boss = new Boss("Troll",100f,100f,50f, 100f, 80f, 100f);

        Spell spell = new Spell("WINGARDIUM LEVIOSA", 10f,10f,10f,15f);

        Spell spell2 = new Spell("REPARO", 10f,10f,10f,15f);
        System.out.println("");
        this.theDispatcherParser.PlayerInfo("Voici vos stats",player);
        System.out.println("");

        this.theDispatcherParser.SpellInfo("Voixi les stats de votre premier sort", spell);
        System.out.println("");

        this.theDispatcherParser.SpellInfo("Voixi les stats de votre second sort", spell2);
        System.out.println("");

        this.theDispatcherParser.PlayerInfo("Voici les stats du Boss",boss);

        playerAction = theDispatcherParser.AskAction(player);
        System.out.println(playerAction);





        return ret;
    }
        // convert answer String to a number between 0 and max allowed
        //nbPlayerHeroes = Math.max(Math.min(Integer.parseInt(answer), this.nbMaxHeroes),1); //take the min between entered number and nb max hero and the max between 1 and previous number

    /*public boolean playGame() { // play the whole game
        boolean ret = false;

        this.nbMaxHeroes = 4;

        // ask the user how many heroes he wants (specifying the max)
        String answer = this.theDispatcherParser.AKindOfDialogBox("Nombre de héros ", "Veuillez saisir le nombre de héros souhaité (max:"+this.nbMaxHeroes+").");
        // convert answer String to a number between 0 and max allowed
        //nbPlayerHeroes = Math.max(Math.min(Integer.parseInt(answer), this.nbMaxHeroes),1); //take the min between entered number and nb max hero and the max between 1 and previous number

        this.initGame();
        this.initHeroes();
        while (this.curRound<=this.maxRounds && this.playerHeroes.size()>0){
            this.nbEnemies = this.nbPlayerHeroes;
            this.initEnemies();
            Collections.shuffle(this.playerHeroes); // shuffle the order of heroes
            Collections.shuffle(this.Enemies); // shuffle the order of enemies
            this.theDispatcherParser.DisplayCurrentOpponents(this.playerHeroes, this.Enemies, this.curRound);
            this.computeNotDeads();
            int currentHero = this.firstNotDeadHero;
            int currentEnemy = this.firstNotDeadEnemy;
            while (currentHero>-1 && currentEnemy>-1) {
                // currentHero attacks 1st not dead enemy (kill him or not)
                this.heroAttackEnemy(currentHero, currentEnemy);
                // is attacked enemy dead ? If yes remove it from list
                if(this.Enemies.get(currentEnemy).getLifePoints()<=0){
                    this.Enemies.remove(currentEnemy);
                    currentEnemy = this.GetNextEnemyAliveIndex(currentEnemy);
                }
                this.theDispatcherParser.DisplayCurrentOpponents(this.playerHeroes, this.Enemies, this.curRound);

                if (currentEnemy>-1) {
                    // current enemy attacks 1st not dead hero (kill him or not)
                    this.playerHeroes.get(currentHero).heroAttacked(this.Enemies.get(currentEnemy).getDamage());
                    if(this.playerHeroes.get(currentHero).getLifePoints()<=0){
                        this.playerHeroes.remove(currentHero);
                        currentHero = this.GetNextHeroAliveIndex(currentHero);
                    }
                    // currentEnemy ++ modulo nbEnemy ;
                    currentEnemy = this.GetNextEnemyAliveIndex(currentEnemy);
                    // currentHero++ modulo nbHero ;
                    currentHero = this.GetNextHeroAliveIndex(currentHero);
                }
                this.theDispatcherParser.DisplayCurrentOpponents(this.playerHeroes, this.Enemies, this.curRound);

            }
            this.ImproveHeroes();
            this.theDispatcherParser.DisplayCurrentOpponents(this.playerHeroes, this.Enemies, this.curRound);
            this.curRound++;
        }
        // Either all heros are dead or we passed final round
        if(this.playerHeroes.size()>0){
            this.theDispatcherParser.AKindOfDialogBox("End of game", "You won and passed the last round");
        }
        else {
            this.theDispatcherParser.AKindOfDialogBox("End of game", "You loose : no more heroes are alive ... Try again !");
        }
        return ret;
    }

    // Private Members

    private boolean ImproveHeroes(){
        boolean ret=false;
        for (int h=0;h<this.playerHeroes.size();h++) {
            String title = "Increase skills";
            String text = "";
            Hero thisHero = this.playerHeroes.get(h);
            switch(thisHero.getClass().getName()) {
                case "com.example.minirpgfinal.Warrior":
                    text="Do you want to increase [Damage] or [Lifepoints] of your com.example.minirpgfinal.Warrior?";
                    break;
                case "com.example.minirpgfinal.Mage":
                    text="Do you want to increase [Damage], [Lifepoints] or [Mana] of your com.example.minirpgfinal.Mage?";
                    break;
                case "com.example.minirpgfinal.Hunter":
                    text="Do you want to increase number of [Arrows], [Damage] or [Lifepoints] of your com.example.minirpgfinal.Hunter?";
                    break;
                case "com.example.minirpgfinal.Healer":
                    text="Do you want to increase [Mana] or [Lifepoints] of your com.example.minirpgfinal.Healer?";
                    break;
            }
            String answer = this.theDispatcherParser.AKindOfDialogBox(title,text).toLowerCase().trim();
            switch(answer) {
                case "damage":
                    thisHero.setDamage(thisHero.getDamage() * 2);
                    break;
                case "lifepoints":
                    thisHero.setLifePoints(thisHero.getLifePoints() * 2);
                    thisHero.setMaxLifePoints(thisHero.getMaxLifePoints() * 2);
                    break;
                case "mana":
                    thisHero.setMana(thisHero.getMana() * 2);
                    thisHero.setMaxMana(thisHero.getMaxMana() * 2);
                    break;
                case "arrows":
                    thisHero.setNbArrows(thisHero.getNbArrows() * 2);
                    thisHero.setNbMaxArrows(thisHero.getNbMaxArrows() * 2);
                    break;
            }
        }
        return ret;
    }

    private int GetNextHeroAliveIndex(int currentHero){
        int ret=-1;
        int currentToTest=currentHero;

        if (this.playerHeroes.size()>0) {
            while (ret == -1) {
                currentToTest = (currentToTest + 1) % this.playerHeroes.size();
                if (this.playerHeroes.get(currentToTest).getIsAlive()) {
                    ret = currentToTest;
                    break;
                }
                else if (currentToTest == currentHero)
                    break;
            }
        }
        return ret;
    }

    private int GetNextEnemyAliveIndex(int currentEnemy){
        int ret=-1;
        int currentToTest=currentEnemy;

        if (this.Enemies.size()>0){
            while (ret == -1){
                currentToTest = (currentToTest + 1) % this.Enemies.size();
                if (this.Enemies.get(currentToTest).getIsAlive()) {
                    ret = currentToTest;
                    break;
                } else if (currentToTest == currentEnemy)
                    break;
            }
        }
        return ret;
    }

    private boolean initGame() { // initialise com.example.minirpgfinal.Game
        return true;
    }
    private boolean heroAttackEnemy(int h, int e) { // this is the fight of hero h to enemy e
        boolean ret = false;
        Hero thisHero = this.playerHeroes.get(h); //thisHero h th hero
        Enemy thisEnemy = this.Enemies.get(e);
        GameParameters.HeroActionKind action = this.theDispatcherParser.AskAction(thisHero); //ask to the user which action depending on the hero
        switch(action){
            case EAT:
                thisHero.setNbFood(thisHero.getNbMaxFood()-1);
                thisHero.setLifePoints(Math.min(thisHero.getLifePoints()+10, thisHero.getMaxLifePoints()));
                ret = true;
                break;
            case DRINK:
                thisHero.setNbPotion(thisHero.getNbMaxPotion()-1);
                thisHero.setMana(Math.min(thisHero.getMana()+10, thisHero.getMaxMana()));
                ret = false;
                break;
            case ATTACK:
                switch (this.getClass().getName()){
                    case "com.example.minirpgfinal.Hunter":
                        thisHero.setNbArrows(thisHero.getNbArrows()-1);
                        break;
                    case "com.example.minirpgfinal.Mage":
                        thisHero.setMana(thisHero.getMana()-5);
                        break;
                }
                thisEnemy.heroAttacked(thisHero.getDamage());
                ret =  true;
                break;
            case DEFEND:
                thisHero.setMana(thisHero.getMana()-5);
                for (h=0; h<this.playerHeroes.size();h++){
                    Hero defendedHero = this.playerHeroes.get(h);
                    if (defendedHero.getLifePoints()>0){
                        defendedHero.setLifePoints(Math.min(defendedHero.getMaxLifePoints(), defendedHero.getLifePoints()+10));
                    }
                }
                ret = true;
                break;
            default:
                throw new IllegalStateException("Unexpected value of fight chosen by user: " + action);
        }

        return true;
    }
    private boolean computeNotDeads() { // find first not dead hero and enemy
        this.firstNotDeadEnemy = -1;
        this.firstNotDeadHero = -1;
        for (int i=0; i<this.playerHeroes.size();i++){ // compare length of list com.example.minirpgfinal.Hero
            Hero h=this.playerHeroes.get(i); //get the i th hero from the list
            if (h.getLifePoints() > 0) {
                this.firstNotDeadHero = i;
                break;
            }
        }
        for (int i=0; i<this.Enemies.size();i++){ // compare length of list Enemies
            Hero h=this.Enemies.get(i); //get the i th enemy from the list
            if (h.getLifePoints() > 0) {
                this.firstNotDeadEnemy = i;
                break;
            }
        }
        return true;
    }
    private boolean initHeroes() { // initialise list of instances of heroes
        for (int h = 0; h < this.nbPlayerHeroes; h++){
            String answer = this.theDispatcherParser.AKindOfDialogBox("Choix d'un héros", "Veuillez saisir le type de héros souhaité : com.example.minirpgfinal.Mage, com.example.minirpgfinal.Warrior, com.example.minirpgfinal.Healer, com.example.minirpgfinal.Hunter");
            System.out.println(answer);
            answer = answer.toLowerCase().trim(); // force the string in lower case because user could do enter upper case / lowercase mix/ trim removes leading or ending spaces
            switch(answer) {
                case "mage":
                    Mage theMage = new Mage(1.0f); //the hero chosen is added to playerHero. 1.0f <=> force type float of the number
                    this.playerHeroes.add(theMage);
                    break;
                case "warrior":
                    Warrior theWarrior = new Warrior(1.0f);
                    this.playerHeroes.add(theWarrior);
                    break;
                case "hunter":
                    Hunter theHunter = new Hunter(1.0f);
                    this.playerHeroes.add(theHunter);
                    break;
                case "healer":
                    Healer theHealer = new Healer(1.0f);
                    this.playerHeroes.add(theHealer); //add to the list HERO
                    break;
                default:
                    System.out.println("Ce type de héros n'existe pas !");
                    h--; // in this case we added nothing to the list so we have to do one more loop
                    break;
            }
        }
        this.theDispatcherParser.DisplayCurrentOpponents(this.playerHeroes, this.Enemies,0);
        return true;

    }
    private boolean initEnemies() { // initialise list of instances of heroes
        for (int h = 0; h < this.nbPlayerHeroes; h++){
            Enemy theEnemy = new Enemy(0.30f* (float)this.curRound);
            this.Enemies.add(theEnemy);
        }
        this.theDispatcherParser.DisplayCurrentOpponents(this.playerHeroes, this.Enemies,0);
        return true;
    }

    //private com.example.minirpgfinal.GameParameters.HeroActionKind RequestPlayerAction (com.example.minirpgfinal.Hero fighter) { // Function used during the fight to assess possible hero actions, and request user action to be done
    //    return true;
    //}

    private boolean playRound() { // heroes fight enemies
        return true;
    }
    private boolean playFight() { // detail of one hero one enemy fight
        return true;
    }
    private boolean quitGame() { // leave the game
        return true;
    }

    private boolean dumpGame() { // dump heroes and enemies status in console windows for testing debug purpose
        return true;
    }*/

}



