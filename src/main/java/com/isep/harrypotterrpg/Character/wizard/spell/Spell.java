package com.isep.harrypotterrpg.Character.wizard.spell;

public class Spell {
    //Attributes
    private String nameSpell;
    private float damageSpell;


    //Getters and Setters
    public String getNameSpell(){return nameSpell;}
    public void setNameSpell(String newName){nameSpell=newName;}

    public float getDamageSpell(){return damageSpell;}

    public void setDamageSpell(float newDamage){damageSpell=newDamage;}




    //Constructor

    //public Spell (String parName,float parDamage){
        //nameSpell= parName;
        //damageSpell= parDamage;

    }

    //Functions

    private Spell(String name, float damage) {
        public static Spell avadakedavra() {return new Spell("avadakedavra", 30f);}
        //J'a tenté, ca a pas marché

    }
}

/*public class Spell {
    private String name;
    private float damage;

    public Spell(String name, float damage) {
        this.name = name;
        this.damage = damage;
    }

    public static Spell avadakedavra() {
        return new Spell("avadakedavra", 30f);
    }
}*/



