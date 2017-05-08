package btp600Assignment2.Characters;

import java.util.ArrayList;

import btp600Assignment2.BattleController;
import btp600Assignment2.NavigateController;
import btp600Assignment2.Weapons.Weapon;

public abstract class Character { //Template
	
	boolean characterMoves() { return false; }
	boolean characterOpensItemMenu() { return false; }
	
	boolean characterAttacks() { return false; }
	boolean characterRetreats() { return false; }
	boolean characterHeals() { return false; }
	
	public abstract String position();
	public abstract String weaponEquippedNames();
	public abstract int weaponEquippedAttackPower();
	public abstract ArrayList<Weapon> collectedPowerUps();
	public abstract int healthPoints();
	public abstract String characterName();
	public abstract void addWeaponPowerUp(Weapon powerUps);
	
	public abstract NavigateController navigationController();
	public abstract BattleController battleController();
}
