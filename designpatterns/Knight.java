package designpattern;

public class Knight extends Characters {

	Knight() {
		setWeapon(weapon);
	}

	@Override
	void fight() {
		super.getWeapon().useWeapon();
	}
	
}
