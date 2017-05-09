package stateSodaMachine;

public class NoDollarState implements State {
	SodaMachine sodaMachine;

	public NoDollarState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}

	public void insertDollar() {
		System.out.println("You have inserted a dollar.");
		sodaMachine.setState(sodaMachine.getHaveDollarState());
	}

	@Override
	public void ejectDollar() {
		System.out.println("You have not inserted a dollar.");

	}

	@Override
	public void pressColaButton() {
		System.out.println("You have press the cola button but there is no dollar.");

	}

	@Override
	public void pressSpriteButton() {
		System.out.println("You have press the sprite button but there is no dollar.");

	}

	@Override
	public void dispense() {
		System.out.println("You will need to pay first.");

	}
	
	public String toString() {
		return "waiting for a dollar to be inserted.";
	}

}
