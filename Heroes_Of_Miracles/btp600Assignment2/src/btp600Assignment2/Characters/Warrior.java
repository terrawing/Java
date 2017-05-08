package btp600Assignment2.Characters;

import java.util.ArrayList;

import btp600Assignment2.BattleController;
import btp600Assignment2.Enemies.*;
import btp600Assignment2.Character;
import btp600Assignment2.NavigateController;
import btp600Assignment2.Position;
import btp600Assignment2.Weapons.Weapon;

public class Warrior extends Character {
	//needs return methods to display what it is
	private Weapon currentWeapon;
	private ArrayList<Weapon> collectedWeapons;
	private long currentHealthPoints = 100;
	private String name = "Damian";
	private boolean alive = true;
	private long teamNum = 1;
	private boolean boss = false;
	
	//receives the move commands, send for calc. and return the results
	private NavigateController navigateController; 
	private BattleController battleController;
	
	private Position currentPosition; //Maybe we need to use it, not necessary
	
	public Warrior() { //Each warrior has their own collection of weapon power ups 
		collectedWeapons = new ArrayList();
	}

	public String weaponEquippedNames() { //Returns the character's power ups currently equipped
		return currentWeapon.displayWeapon();
	}

	public ArrayList<Weapon> collectedPowerUps() { //Returns an arraylist of collected power ups by the character
		return collectedWeapons;
	}

	public long healthPoints() { //Returns the current health points of the character
		return currentHealthPoints;	
	}

	//Observer methods, don't really need it unless the hero is a summoner
	public void registerObserverMinion(ObserverMinion o) {}
	public void removeObserverMinion(ObserverMinion o) {}
	public void notifyObserverMinions() {}

	public boolean isEnemyOf(Character ch) { //Checks if the character is itself, otherwise it is an enemy.
		String characterType = (ch.getClass()).getSimpleName();
		if(characterType.equals("Warrior"))
			return false;
		else
			return true;
	}

	public void collectWeapon(Weapon w) { //character adds the power up here
		currentWeapon = w;
		collectedWeapons.add(w); //Add a weapon power up to the collection that the hero has collected
	}

	public boolean isAlive() { //default to be true, until killed
		return alive;
	}

	public void setIsAlive(boolean b) {
		if(b)
			alive = true;
		else
			alive = false;
	}

	public long getAttackPower() { //Returns the character's total power up attack power added together
		return currentWeapon.displayAttackPower();
	}

	public long getHealthIncreasement() { //Heal the warrior himself
		return 10;
	}

	public String getName() { //Returns the name of the character
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getType() {
		return characters.Warrior.toString();
	}

	public long getTeamNumber() {
		return teamNum;
	}

	public void setTeamNumber(long num) {
		teamNum = num;	
	}

	public Boolean isBoss() {
		return boss;
	}

	public void setIsBoss(boolean b) {
		boss = b;
	}

	public String powerUpDrop() { return null; }
}
