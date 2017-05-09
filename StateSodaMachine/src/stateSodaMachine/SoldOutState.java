package stateSodaMachine;

public class SoldOutState implements State {
	SodaMachine sodaMachine;

	public SoldOutState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}

	@Override
	public void insertDollar() {
		System.out.println("Cannot insert dollar, the machine is sold out.");

	}

	@Override
	public void ejectDollar() {
		System.out.println("Cannot eject dollar, no dollar was inserted.");

	}

	@Override
	public void pressColaButton() {
		System.out.println("You have pressed the Cola button, but the machine is sold out.");

	}

	@Override
	public void pressSpriteButton() {
		System.out.println("You have pressed the Sprite button, but the machine is sold out.");

	}

	@Override
	public void dispense() {
		System.out.println("No soda dispensed.");

	}
	
	public String toString() {
		return "is sold out";
	}

}
