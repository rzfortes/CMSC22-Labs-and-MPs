//package lab7;

import java.util.Random;

/**
 * modified by Ricafelle Fortes and Christine Catubig on 10/2/16 - 10/3/16.
 * created by nmenego on 9/29/16.
 */

public class Swordsman extends Hero {
    
    private Random rand = new Random();
    String [] attacks = {"Quick Attack", "Block", "Slash"};

    // because of sword
    private static final int BASE_ATTACK = 10;
    // because of armor
    private static final int ARMOR = 5;

    public Swordsman(String name, int level) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name, level + ARMOR, level);
    }
    
    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int attack() {
        int attackType = randInt(1, 3);
        
        switch (attackType) {
            case 1:
                // Quick Attack
                System.out.printf("\n%s will use Quick attack\n", super.getName());
                return (BASE_ATTACK + (int)(0.10 * super.getHp()));
            case 2:
                // Block
                // returns the same damage given by the monster
                System.out.printf("\n%s will use Block\n", super.getName());
                return (BASE_ATTACK + getLevel());
            case 3:
                // Slash
                System.out.printf("\n%s will use Slash\n", super.getName());
                return (BASE_ATTACK + (maxHp - super.getHp()));
            default:
                break;
        }
        
        return (BASE_ATTACK + getLevel());
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}