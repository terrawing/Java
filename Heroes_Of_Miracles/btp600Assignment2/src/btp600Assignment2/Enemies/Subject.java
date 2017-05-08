package btp600Assignment2.Enemies;

public interface Subject {
	public void registerObserverMinion(ObserverMinion o);
	public void removeObserverMinion(ObserverMinion o);
	public void notifyObserverMinions();
}
