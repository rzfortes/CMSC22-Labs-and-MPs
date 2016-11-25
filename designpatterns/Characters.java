package designpattern;

public abstract class Characters {
	
	WeaponBehavior weapon;
	
	abstract void fight();
	
	void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon;
	}
	
	WeaponBehavior getWeapon() {
		return weapon;
	}

}
