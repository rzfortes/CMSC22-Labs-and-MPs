//package lab7;

/**
 * modified by Ricafelle Fortes and Christine Catubig on 10/2/16 - 10/3/16.
 * created by nmenego on 9/29/16.
 */

public abstract class RPGCharacter {
    public static int maxHp;

    private String name;
    private int hp;

    public RPGCharacter(String name, int hp) {
        this.name = name;
        this.hp = hp;
        maxHp = hp;
    }

    // implement in subclass
    public abstract int attack();

    // checks to see if character is still alive
    public boolean isAlive() {
        return hp > 0;
    }

    // may be overriden in subclass, damage is dependent on hero type
    public int takeDamage(int damage) {
        hp -= damage;
        return hp;
    }

    // getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "RPGCharacter{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}