package btp600Assignment2.Weapons;

public interface PowerUpStrategy { //Used to change the algorithm of this method at runtime, define the action.
	//Used to return directly what the weapon power up is, when a monster is defeated and the hero collects the power up
	public String displayPowerUp();
}
