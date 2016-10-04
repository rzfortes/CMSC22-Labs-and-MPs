//package lab7;

import java.util.Random;

/**
 * created by Ricafelle Fortes, 10/3/16.
 */

public class Archer extends Hero {
    
    private Random rand = new Random();
    String [] attacks = {"Arrow Mark", "Archer's Eye", "Arrows"};

    // because of sword
    private static final int BASE_ATTACK = 5;
    // because of armor
    private static final int ARMOR = 5;

    public Archer(String name, int level) {
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
                // Arrow Mark
                System.out.printf("\n%s will use Arrow Mark\n", super.getName());
                return (int)(BASE_ATTACK * (0.20));
            case 2:
                // Archer's Eye
                System.out.printf("\n%s will use Archer's Eye\n", super.getName());
                return (int)(BASE_ATTACK * (0.10));
            case 3:
                // Arrows
                System.out.printf("\n%s will use Slash\n", super.getName());
                return BASE_ATTACK + 36;
            default:
                break;
        }
        
        return BASE_ATTACK;
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
    
}
