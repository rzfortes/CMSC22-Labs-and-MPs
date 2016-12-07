package designpattern;

public class CharacterTester {
	
	public static void main(String[] args) {
		WeaponBehavior knife = new KnifeBehavior();
		WeaponBehavior bows = new BowandArrowBehavior();
		WeaponBehavior sword = new SwordBehavior();
		WeaponBehavior axe = new AxeBehavior();
		Characters king = new King(knife);
		Characters Queen = new Queen();
		Characters Troll = new Troll();
		Characters knight = new Knight();
		
		king.fight();
		Queen.setWeapon(axe);
		Queen.fight();
		king.setWeapon(bows);
		king.fight();
		Troll.setWeapon(axe);
		Troll.fight();
		king.setWeapon(knife);
		king.fight();
		king.setWeapon(sword);
		king.fight();
		knight.setWeapon(knife);
		knight.fight();
	}

}
