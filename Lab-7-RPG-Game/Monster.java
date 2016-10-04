//package lab7;

import java.util.Random;

/**
 * modified by Ricafelle Fortes and Christine Catubig on 10/2/16 - 10/3/16.
 * created by nmenego on 9/29/16.
 */

public class Monster extends RPGCharacter{
    private Random rand = new Random();
    private int attackDamage;
    String[] attacks = {"Quick Attack", "Poison", "Slap", "Slam", "Bite"};

    public Monster(String name, int hp, int attackDamage) {
        super(name, hp);
        this.attackDamage = attackDamage;
    }
    
    
    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    

    // bool if previous attack is slap or slam, if true, monsters deals bonus damage
    private boolean isSlapSlam = false;
    public int attack() {
        int attackType = randInt(1, 5);
        
        if(attackType == 1) {
            // Quick Attack
            // int chance is for the number of times the monster will attack, atleast 1 - 3 times
            System.out.printf("\n%s used Quick Attack\n", super.getName());
            int chance = randInt(1, 3);
            isSlapSlam = false;
            
            if(chance == 1) {
                return attackDamage;
            } else if (chance == 2) {
                return (attackDamage + (int)(0.25 * attackDamage));
            } else {
                return (attackDamage + (int)(0.50 * attackDamage));
            }
        } else if (attackType == 2) {
            // Poison
            System.out.printf("\n%s used Poison\n", super.getName());
            isSlapSlam = false;
            return (attackDamage + (int)(0.50 * super.getHp()));
        } else if (attackType == 3 || attackType == 4) {
            // Slap
            System.out.printf("\n%s used Slap or Slam\n", super.getName());
            if(isSlapSlam) {
                return (attackDamage + (int)(0.50 * attackDamage));
            } else {
                isSlapSlam = true;
                return attackDamage;
            }
            
        } else {
            // bite
            System.out.printf("\n%s used Bite\n", super.getName());
            isSlapSlam = false;
            return (attackDamage + (int)(0.50 * super.getHp()));
            
        }      
    }
}