package btp600Assignment2.Enemies;

import java.util.ArrayList;
import java.util.Random;

import btp600Assignment2.BattleController;
import btp600Assignment2.Character;
import btp600Assignment2.EnemyPosition;
import btp600Assignment2.NavigateController;
import btp600Assignment2.Position;
import btp600Assignment2.Weapons.*;

public class DragonKnight extends Character {
	//needs return methods to display what it is
	private long currentHealthPoints = 100;
	private String name = "Dragon Knight";
	private long enemyAttackPower = 4;
	private boolean alive = true;
	private boolean boss = false;
	
	private PowerUpContext weaponPowerUpDrop;
	
	private EnemyPosition currentPosition;
	
	public DragonKnight() { //When a dragon knight is created, it will randomly assign a power up. When user defeats it, they will be able to clam it.
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		weaponPowerUpDrop = generateRandomPowerUp(randomNum);
	}
	
	public PowerUpContext generateRandomPowerUp(int randomNum) { //Returns a context (behavior) of a power up
		switch(randomNum) {
		case 1:
			return new PowerUpContext(new Fire());
			
		case 2:
			return new PowerUpContext(new LifeSteal());
			
		default:
			return new PowerUpContext(new Ice());
			
		}
	}
	
	public String powerUpDrop() { //Returns the name of the power up drop
		return weaponPowerUpDrop.displayPowerUp();
	}

	public long healthPoints() { //Returns the health points of dragon knight
		return currentHealthPoints;
	}

	public String getName() { //Returns the name of dragon knight
		return name;
	}

	public long getAttackPower() { //Returns the attack power of dragon knight
		return enemyAttackPower;	
	}

	//Observer methods, don't really need it unless the enemy is the boss
	public void registerObserverMinion(ObserverMinion o) {}
	public void removeObserverMinion(ObserverMinion o) {}
	public void notifyObserverMinions() {}

	public boolean isEnemyOf(Character ch) {
		String characterType = (ch.getClass()).getSimpleName();
		if(characterType.equals("Warrior"))
			return true;
		else
			return false;
	}

	public boolean isAlive() {
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
		return characters.DragonKnight.toString();
	}

	public Boolean isBoss() {
		return boss;
	}

	public void setIsBoss(boolean b) {
		boss = b;
	}

	public long getTeamNumber() { return 0; }
	public void collectWeapon(Weapon w) {}
	public void setTeamNumber(long num) {}
	public ArrayList<Weapon> collectedPowerUps() { return null; }
	public String weaponEquippedNames() { return null; }
}
