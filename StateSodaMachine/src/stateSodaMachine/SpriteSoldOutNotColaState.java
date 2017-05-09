package stateSodaMachine;

public class SpriteSoldOutNotColaState implements State {
	SodaMachine sodaMachine;

	public SpriteSoldOutNotColaState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}

	@Override
	public void insertDollar() {
		System.out.println("You have inserted a dollar.");
		sodaMachine.setState(sodaMachine.getHaveDollarState());
	}

	@Override
	public void ejectDollar() {
		System.out.println("Cannot eject dollar, no dollar was inserted.");

	}

	@Override
	public void pressColaButton() {
		System.out.println("You have pressed the Cola button, but you need to insert a dollar.");

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
		return "has Sprite sold out. Waiting for a dollar to be inserted.";
	}
}
