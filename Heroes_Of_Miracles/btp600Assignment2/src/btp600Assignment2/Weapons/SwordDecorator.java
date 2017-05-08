package btp600Assignment2.Weapons;

public abstract class SwordDecorator implements Weapon { //Everything weapon power up will start as a sword decorator
	protected Weapon decoratedWeapon;
	
	public SwordDecorator() {}
	
	public SwordDecorator(Weapon decoratedWeapon) {
		this.decoratedWeapon = decoratedWeapon;
	}
	
	public String displayWeapon() {
		return decoratedWeapon.displayWeapon();
	}
	
	public int displayAttackPower() {
		return decoratedWeapon.displayAttackPower();
	}
}
