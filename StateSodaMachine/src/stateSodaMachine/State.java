package stateSodaMachine;

public interface State {
	public void insertDollar();
	public void ejectDollar();
	public void pressColaButton();
	public void pressSpriteButton();
	public void dispense();
}
