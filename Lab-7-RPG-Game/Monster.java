
public class Monster extends Character{
    private int attackDamage;

    public Monster(String name, int hp, int attackDamage) {
    	super(name, hp);
    	this.attackDamage = attackDamage;
    }

    public int attack() {
        return attackDamage;
    }

}

