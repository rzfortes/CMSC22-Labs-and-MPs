package lab7;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * modified by Ricafelle Fortes and Christine Catubig on 10/2/16 - 10/3/16.
 * created by nmenego on 9/29/16.
 */

public class RPG {
    
    private Random rand = new Random();

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss
    public boolean coinToss() {
        return randInt(1, 10) == 10;
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
    public boolean duel(RPGCharacter attacker, RPGCharacter defender) {
        int damage = attacker.attack();
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        sleep(2000);

        if (coinToss()) {
            System.out.println("--> MISSED!");
        } else {
            int remHp = defender.takeDamage(damage);
            if (remHp <= 0) {
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
                return true;
            }
        }
        return false;
    }
    
    //heroLevel = hp ng hero
    //if heroLevel = 1, ang hp = 1 * 10;
    public RPGCharacter getCharacterType(String playerName, int heroLevel, int type){
        RPGCharacter hero = new Swordsman(playerName, (heroLevel));
        
        while(type <= 3 && type >= 1){

            switch(type){
                case 1:
                    hero = new Swordsman(playerName, heroLevel); // TODO take parameters as input via STDIN
                    type = 0;
                    break;
                case 2:
                    hero = new Magi(playerName, (heroLevel + 10));
                    type = 0;
                    break;
                case 3:
                    hero = new Archer(playerName, (heroLevel + 5));
                    type = 0;
                    break;
                default:
                    System.out.println("Cannot find character. Please choose again!\n");
                    break;
            }
            
        }
        return hero;
    }

    public static RPGCharacter initializeMonster(int level){
        String name = "";
        int hp = 0, attackDamage = 0;
        switch(level){
            case 1:
                name = new String("Green Elf");
                hp = 35;
                attackDamage = 5; 
                break;
            case 2:
                name = new String("Smelly Giant");
                hp = 40;
                attackDamage = 10;
                break;
            case 3:
                name = new String("Bloody Ogre");
                hp = 45;
                attackDamage = 20;
                break;
            case 4:
                name = new String("Fiery Demon");
                hp = 55;
                attackDamage = 25;
                break;
            case 5:
                name = new String("The Boss");
                hp = 65;
                attackDamage = 30;
                break;
            default:
                break;
        }
        RPGCharacter monster =  new Monster(name, hp, attackDamage);
        return monster;
    }
    
    // game...
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Hero Name: ");
        String playerName = sc.nextLine();
        int heroLevel = 25;
        
        System.out.println("\n\n" + playerName + " choose your character.\n 1. Swordsman \n 2. Magi\n 3. Archer\n");
        sc = new Scanner(System.in);
        int x = sc.nextInt();
        RPG rpg = new RPG();
        RPGCharacter hero;
        int count = 1; // count stands for level / rounds
        
        if(x >= 1 || x <=3) {
            hero = rpg.getCharacterType(playerName, 10, x);
        } else {
            throw new IllegalArgumentException("Invalid input. Please choose again!\n");
        }        
        
        RPGCharacter monster = initializeMonster(count);
        
        //ask for character
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\t\t\t\t\t====== GAME START =====\n\n");
        System.out.printf("\n%s\n%s\n", hero, monster);

        // fight! for version 1, hero will always attack first.
        //int count = 1; 
        System.out.println("\t\t\t== level " + count);
        while (count <= 5) {
            
            if(count == 5) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("\n\t\t\t\t\tHERO VS THE BOSS");
            }
            // hero's turn
            boolean heroVsMonster = rpg.duel(hero, monster);
            if (heroVsMonster) {
                rpg.sleep(2000);
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                if(count == 5) {
                    System.out.println("\nCongratulations! You have defeated THE BOSS!!!\n");

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
                    break;
                }
                
                ++count;
                System.out.println("== level " + count + "==");
                //hero = rpg.getCharacterType(playerName, heroLevel, x);
                hero.setHp(heroLevel+10);
                monster = initializeMonster(count);
                System.out.printf("\n%s\n%s\n", hero, monster);
                
            }

            // monster's turn
            boolean monsterVsHero = rpg.duel(monster, hero);
            if (monsterVsHero) {
                System.out.println("\n\nYou lose!!!\n");
                System.out.println("\nGame Over\n\n\n");
                break;
            }

            System.out.printf("\n%s\n%s\n", hero, monster);
            
        }

        System.out.printf("\n%s\n%s\n", hero, monster);
    }
}
