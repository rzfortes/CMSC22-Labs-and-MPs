//package lab7;

import java.util.Random;

/**
 * created by Ricafelle Fortes, 10/3/16.
 */

public class Magi extends Hero {
    
    private Random rand = new Random();
    String[] attacks = {"Lightning Storm", "WildFire", "Winter Storm", "Earth Gnome"};

    // because of sword
    private static final int BASE_ATTACK = 10;
    // because of armor
    private static final int ARMOR = 10;

    public Magi(String name, int level) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name, level + ARMOR, level);
    }
    
    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int attack() {
        int attackType = randInt(1, 4);
        
        switch (attackType) {
            case 1:
                // Quick Attack
                System.out.printf("\n%s will use Lightning Storm\n", super.getName());
                return BASE_ATTACK + (int)(0.100 * super.getHp());
            case 2:
                // Block
                // returns the same damage given by the monster
                System.out.printf("\n%s will use WildFire\n", super.getName());
                return BASE_ATTACK + (int)(0.300 * super.getHp());
            case 3:
                // Slash
                System.out.printf("\n%s will use Winter Storm\n", super.getName());
                return BASE_ATTACK + (int)(0.200 * super.getHp());
            case 4:
                // Quick Attack
                System.out.printf("\n%s will use Earth Gnome\n", super.getName());
                return BASE_ATTACK + (int)(0.250 * super.getHp());
            default:
                break;
        }
        
        return BASE_ATTACK + getLevel();
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
    
}