package stateSodaMachine;

public class HaveDollarState implements State {
	SodaMachine sodaMachine;
	
	public HaveDollarState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}
	
	public void insertDollar() {
		System.out.println("You can not insert another dollar.");
	}
	
	public void ejectDollar() {
		System.out.println("Your dollar have been returned.");
		sodaMachine.setState(sodaMachine.getNoDollarState());
	}
	
	public void dispense() {
		System.out.println("No can dispensed");
	}

	public void pressColaButton() {
		System.out.println("You press the Soda button.");
		sodaMachine.setState(sodaMachine.getColaSoldState());
	}

	public void pressSpriteButton() {
		System.out.println("You press the Sprite button.");
		sodaMachine.setState(sodaMachine.getSpriteSoldState());	
	}
}
