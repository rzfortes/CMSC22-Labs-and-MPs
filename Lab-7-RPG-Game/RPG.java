package lab7;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * modified by Ricafelle Fortes and Christine Catubig on 10/2/16 - 10/3/16.
 *
 * created by nmenego on 9/29/16.
 */

public class RPG {

    private Random rand = new Random();

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Green", "Slimy", "Bloody", "Smelly"};
        String[] monsters = {"Ogre", "Elf", "Giant", "Teacher"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss
    public boolean coinToss() {
        return randInt(0, 1) == 1;
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
            int remHp = defender.takeDamage(damage);
            if (remHp <= 0) {
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
                return true;
            }
        } else {
            System.out.println("--> MISSED!");
        }
        return false;
    }
    
    // game...
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hero Name: ");
        String playerName = sc.nextLine();
        /*System.out.println("Enter your level: ");
        int heroLevel = sc.nextInt();*/
        int heroLevel = 50;

        RPG rpg = new RPG();
        RPGCharacter hero = new Swordsman(playerName, heroLevel); // TODO take parameters as input via STDIN
        RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), (heroLevel + 30), (heroLevel/2) );

        System.out.println("\t\t\t\t\t====== GAME START =====\n\n");
        System.out.printf("%s\n%s\n", hero, monster);

        // fight! for version 1, hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("== round " + ++count);
            // hero's turn
            boolean heroVsMonster = rpg.duel(hero, monster);
            if (heroVsMonster) break;

            // monster's turn
            boolean monsterVsHero = rpg.duel(monster, hero);
            if (monsterVsHero) break;

            System.out.printf("%s\n%s\n", hero, monster);
        }

        System.out.printf("%s\n%s\n", hero, monster);
    }
}
