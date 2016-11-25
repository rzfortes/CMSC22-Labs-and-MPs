package designpattern;

public class Troll extends Characters {

	Troll() {
		setWeapon(weapon);
	}

	@Override
	void fight() {
		super.getWeapon().useWeapon();
	}
	
}
