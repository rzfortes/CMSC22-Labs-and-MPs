
public class Mage extends Hero {

    // because of sword
    private static final int BASE_ATTACK = 5;
    // because of armor
    private static final int ARMOR = 5;

    public Mage(String name, int hp) {
        // a Mage will have +ARMOR for HP because of ARMOR
        super(name, hp);
    }

    public int attack() {
        return BASE_ATTACK + getLevel();
    }
/*
    public int getHp(){
        return super.getHp();
    }
*/
    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}