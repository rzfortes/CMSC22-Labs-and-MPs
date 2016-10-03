import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RPG {
    
    private Random rand = new Random();

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // coin toss
    public boolean coinToss() {
        return randInt(0, 1) == 1 ? true : false;
    }

     public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // pause the game for awhile for dramatic effect!
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed
    public boolean duel(Character attacker, Character defender, int level) {
        int damage = attacker.attack();
        System.out.println("--> " + attacker.getName() + " attacked " + defender.getName());
        sleep(2000); // if you can, use clear screen after dueling

        if (coinToss()) {

            int remHp = defender.takeDamage(damage);
            if (remHp <= 0) {
                System.out.printf("\n\n    \t\t%s killed %s!\n", attacker.getName(), defender.getName());
                
                return true;
                
            }
        } else {
            System.out.println("--> MISSED!\n");
        }
        return false;
    }


    public static Character initializeMonster(int level){
        String name = "";
        int hp = 0, attackDamage = 0;
        switch(level){
            case 1:
                name = new String("Green Elf");
                hp = 25;
                attackDamage = 5; // if dali nga mamatay si hero, minusi lang ang hp or ang attackDamage
                break;
            case 2:
                name = new String("Smelly Giant");
                hp = 30;
                attackDamage = 10;
                break;
            case 3:
                name = new String("Bloody Ogre");
                hp = 35;
                attackDamage = 15;
                break;
            case 4:
                name = new String("Fiery Demon");
                hp = 45;
                attackDamage = 20;
                break;
            case 5:
                name = new String("The Boss");
                hp = 60;
                attackDamage = 30;
                break;
            default:
                break;
        }
        Character monster =  new Monster(name, hp, attackDamage);
        return monster;
    }

    // game...
    public static void main(String[] args) {

        RPG rpg = new RPG();
        String name = "";
        int level = 1;
        int heroHp = 30;

        // default character for hero is swordsman
        // i just really need something to initialize hero becuase mureklamo si compiler
        Character hero = new Swordsman("Swordsman", heroHp);
        
        System.out.println("Hero please enter your name!         ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();

        //ask for character
        int x = 0;
        while(x > 3 || x < 1){
            System.out.println(name + " choose your character.\n 1. Swordsman \n 2. Mage\n 3. Archer\n");
            sc = new Scanner(System.in);
            x = sc.nextInt();

            switch(x){
                case 1:
                    hero = new Swordsman(name, heroHp); // TODO take parameters as input via STDIN        
                    break;
                case 2:
                    hero = new Mage(name, heroHp);
                    break;
                case 3:
                    hero = new Archer(name, heroHp);
                    break;
                default:
                    System.out.println("Cannot find character. Please choose again!\n");
                    break;
            }
        }
        int monsHp = 50;
        System.out.println("monsterHP = " + monsHp);
        Character monster = initializeMonster(level); // different monster each level         

        // hero will always attack first.
        boolean heroVsMonster = false;
        boolean monsterVsHero = false;
        int turn = 1;
        while (!monsterVsHero) {
            if(level == 5){
                System.out.println("Wonderful! You have reached level 5.\n");
            }
            System.out.printf("================= LEVEL %d ================\n", level);
            System.out.println();

            System.out.println("    " + hero.getName() + "\t\t||   " + monster.getName());
            System.out.println("HP:"+ hero.getHp() + "\t\t|| HP:" + monster.getHp());
            System.out.println("\n");

            if(turn % 2 != 0){
                heroVsMonster = rpg.duel(hero, monster, level);
                if(heroVsMonster){
                    System.out.println("\n\t\tLEVEL UP!\n\n");
                    hero.setHp(heroHp+5);
                    level++;
                    monster = initializeMonster(level);
                }else if (heroVsMonster && level == 5){

                    System.out.println("Congratulations! You have defeated THE BOSS!!!");

                    System.out.println("    (_v_)       ");                   
                    System.out.println("     _|_        ");                       
                    System.out.println("     | |        ");                    
                    System.out.println("|-----+-----|   ");               
                    System.out.println("|  MONSTER  |   ");              
                    System.out.println("| DESTROYER |   ");              
                    System.out.println(" '---------'    ");                 
                    System.out.println("  |       |     ");                
                    System.out.println("   '.   .'      ");                 
                    System.out.println("     | |        ");                    
                    System.out.println("    .' '.       ");             
                    System.out.println("   _|___|_      ");                  
                    System.out.println("  [#######]     ");              

                    System.out.println("\n\nGame Over\n\n\n");
                }
            }else{
                monsterVsHero = rpg.duel(monster, hero, level);
            }


            System.out.println("========================================\n\n\n\n\n\n\n\n\n");
            
            turn++;     
        }
    }
}