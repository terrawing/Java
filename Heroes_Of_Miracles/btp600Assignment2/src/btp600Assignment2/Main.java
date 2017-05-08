package btp600Assignment2;

import btp600Assignment2.Characters.*;
import btp600Assignment2.Enemies.*;
import btp600Assignment2.Weapons.*;

public class Main {

	public static void main(String[] args) {
		Character hero = new Warrior();
		System.out.println(hero.getName());
		System.out.println(hero.healthPoints());
		System.out.println(hero.getType());
		System.out.println(hero.isEnemyOf(hero));
		System.out.print("\n");
		
		
		Weapon weapon = new Sword(); //This one is default and a must have, uses decorator
		//so something like this to decorate with power up "weapon = new Fire(weapon);" or "Weapon weapon = new Fire(new LifeSteal(new Sword()));"
		hero.collectWeapon(weapon); //character needs a method to add a powerup/weapon
		System.out.println(hero.weaponEquippedNames()); //character needs a method to know which powerup he is using
		System.out.println(hero.getAttackPower());
		System.out.println(hero.collectedPowerUps().size()); //Returns an ArrayList of collected weapons from enemies killed. Character should have a collection of weapons he owns, so user can pick and choose to equip		
		System.out.print("\n");
		
		Character dragonKnight = new DragonKnight();
		System.out.println(dragonKnight.getName());
		System.out.println(dragonKnight.healthPoints());
		System.out.println(dragonKnight.getAttackPower());
		System.out.println(dragonKnight.powerUpDrop()); //randomly weapon power up drop assigned
		System.out.println(dragonKnight.isEnemyOf(hero));
		System.out.print("\n");
		
		Character dragon = new Dragon();
		System.out.println(dragon.getName());
		System.out.println(dragon.healthPoints());
		System.out.println(dragon.getAttackPower());
		System.out.println(dragon.isEnemyOf(hero));
		System.out.print("\n");
		
		Character drake = new Drake(dragon);
		((Dragon) dragon).spawnsDrakes(45); //Calculate a hp threshold and use that hp instead of this number
		System.out.println(drake.getName());
		System.out.println(drake.healthPoints());
		System.out.println(drake.getAttackPower());
		System.out.println(drake.isEnemyOf(hero));
		System.out.print("\n");
	}

}
