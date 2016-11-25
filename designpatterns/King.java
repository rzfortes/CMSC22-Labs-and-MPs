package designpattern;

public class King extends Characters {
	
	King(WeaponBehavior weapon) {
		setWeapon(weapon);
	}

	@Override
	void fight() {
		super.getWeapon().useWeapon();
	}

}
