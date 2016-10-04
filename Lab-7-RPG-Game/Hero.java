//package lab7;

//import java.util.Random;

/**
 * modified by Ricafelle Fortes and Christine Catubig on 10/2/16 - 10/3/16.
 * created by nmenego on 9/29/16.
 */

public abstract class Hero extends RPGCharacter {
    
    private int level;

    public Hero(String name, int hp, int level) {
        super(name, hp);
        this.level = level;
    }

    // getters and setters
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}