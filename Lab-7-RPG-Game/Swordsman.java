
public class Swordsman extends Hero {

    // because of sword
    private static final int BASE_ATTACK = 5;
    // because of armor
    private static final int ARMOR = 5;

    public Swordsman(String name, int hp) {
        super(name, hp);
    }

    public int attack() {
        return BASE_ATTACK + getLevel();
    }

  /*  public int choiceOfAttack(int choice){
        if (choice == 1){

        }
    }*/

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}