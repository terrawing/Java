package btp600Assignment2.Enemies;

import java.util.ArrayList;

import btp600Assignment2.BattleController;
import btp600Assignment2.Character;
import btp600Assignment2.EnemyPosition;
import btp600Assignment2.NavigateController;
import btp600Assignment2.Position;
import btp600Assignment2.Weapons.PowerUpContext;
import btp600Assignment2.Weapons.Weapon;

public class Dragon extends Character implements Subject {
	//needs return methods to display what it is
	private long currentHealthPoints = 200;
	private String name = "Rimescale of the Flame";
	private long enemyAttackPower = 9;
	private boolean alive = true;
	private boolean boss = true;
	
	private ArrayList<ObserverMinion> observerMinions;
	private long drakeHealthPoints = 0; //set something by default
	
	private EnemyPosition currentPosition;

	public Dragon() { //A collection of observers
		observerMinions = new ArrayList<ObserverMinion>();
	}

	public long healthPoints() {	//Returns the health points of the dragon
		return currentHealthPoints;
	}

	public long getAttackPower() { //Returns the attack power of the dragon
		return enemyAttackPower;		
	}

	public String getName() { //Returns the name of the dragon
		return name;		
	}
	
	/* ********************* Observer methods here *********************************** */
	public void registerObserverMinion(ObserverMinion o) { //Method to add observers for the dragon
		observerMinions.add(o);
	}

	public void removeObserverMinion(ObserverMinion o) { //Method to remove observers for the dragon, if necessary
		int i = observerMinions.indexOf(o);
		if(i >= 0)
			observerMinions.remove(i);
	}

	public void notifyObserverMinions() { //Method to notify observers of changes from the dragon, when needed
		for(int i = 0; i < observerMinions.size(); i++) {
			ObserverMinion observerMinion = (ObserverMinion) observerMinions.get(i);
			observerMinion.update(drakeHealthPoints, 3); //maybe need the position too?
		}
	}
	
	//When the boss is below a health point threshold, it will summon drakes base on its current health points.
	//Notify the observer minions
	public void spawnsDrakes(int hp) { 
		drakeHealthPoints = hp;
		notifyObserverMinions();
	}

	public boolean isEnemyOf(Character ch) {
		String characterType = (ch.getClass()).getSimpleName();
		if(characterType.equals("Warrior"))
			return true;
		else
			return false;
	}

	public boolean isAlive() {
		// TODO Auto-generated method stub
		return alive;
	}

	public void setIsAlive(boolean b) {
		if(b)
			alive = true;
		else
			alive = false;	
	}

	public long getHealthIncreasement() {
		return 0;
	}

	public void setName(String n) {
		name = n;
	}

	public String getType() {
		return characters.Dragon.toString();
	}

	public Boolean isBoss() {
		return boss;
	}

	public void setIsBoss(boolean b) {
		boss = b;
	}

	public long getTeamNumber() { return 0; }	
	public void setTeamNumber(long num) {}
	public ArrayList<Weapon> collectedPowerUps() { return null; }
	public String weaponEquippedNames() { return null; }
	public void collectWeapon(Weapon w) {}
	public String powerUpDrop() { return null; }
}
