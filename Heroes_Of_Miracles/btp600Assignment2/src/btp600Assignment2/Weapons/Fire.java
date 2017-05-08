package btp600Assignment2.Weapons;

public class Fire extends SwordDecorator implements PowerUpStrategy {
	
	public Fire() {}

	public Fire(Weapon decoratedWeapon) { //Derived Constructor used to add on the decorator over the weapon, one after another.
		super(decoratedWeapon);
		System.out.println("Equipping the fire power up to your weapon...");
	}

	public String displayWeapon() { //Returns the current power up decorated over the weapon.
		return decoratedWeapon.displayWeapon() + "(Fire)";		
	}

	public int displayAttackPower() { //Returns the current power up attack power added to the weapon attack power.
		return decoratedWeapon.displayAttackPower() + 3;		
	}

	public String displayPowerUp() { //Returns the type of power up directly when the monster is defeated.
		return "Fire";
	}
}
