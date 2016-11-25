package designpattern;

public class Queen extends Characters {
	
	Queen() {
		setWeapon(weapon);
	}

	@Override
	void fight() {
		super.getWeapon().useWeapon();
	}

	
}
