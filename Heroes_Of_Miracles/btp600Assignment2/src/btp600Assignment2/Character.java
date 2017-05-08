package btp600Assignment2;

import java.util.ArrayList;
import btp600Assignment2.Enemies.Subject;
import btp600Assignment2.Weapons.Weapon;

public abstract class Character implements Subject { //Template; implements Subject so the observer can use the Template character
	
	public abstract boolean isEnemyOf(Character ch);
	public abstract void collectWeapon(Weapon w);
	public abstract boolean isAlive();
	public abstract void setIsAlive(boolean b);
	public abstract long getAttackPower();
	public abstract long getHealthIncreasement();
	public abstract String getName();
	public abstract void setName(String n);
	
	public enum characters { //Not sure how you want the enum
		Warrior {
			public String getType() {
				return "Warrior";
			}
		},
		Dragon {
			public String getType() {
				return "Dragon";
			}
		},
		DragonKnight {
			public String getType() {
				return "Dragon Knight";
			}
		},
		Drakes {
			public String getType() {
				return "Drake";
			}
		}
	}	
	public abstract String getType(); 
	
	public abstract long getTeamNumber();
	public abstract void setTeamNumber(long num);
	public abstract Boolean isBoss();
	public abstract void setIsBoss(boolean b);
	
	public abstract long healthPoints();
	public abstract ArrayList<Weapon> collectedPowerUps();
	public abstract String weaponEquippedNames();
	public abstract String powerUpDrop();
}
