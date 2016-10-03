
public abstract class Hero extends Character {
    private int level;
    public int choice;

    public Hero(String name, int hp) {
        super(name, hp);
        //this.level = level;
    }

   // public abstract int choiceOfAttack(int choice);

    // getters and setters
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}