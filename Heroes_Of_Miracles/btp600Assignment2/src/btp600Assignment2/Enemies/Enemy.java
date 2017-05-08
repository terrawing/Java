package btp600Assignment2.Enemies;

public abstract class Enemy implements Subject { //Template; implements Subject so the observer can use the Template enemy
	public abstract String position();
	public abstract int healthPoints();
	public abstract int enemyAttackPower();
	public abstract String enemyName();
	public abstract String powerUpDrop();
	
	public boolean enemyBoss() { return false; }
}
