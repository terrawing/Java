package stateSodaMachine;

public class ColaSoldState implements State {
	SodaMachine sodaMachine;

	public ColaSoldState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}

	
	public void insertDollar() {
		System.out.println("Please wait, money is processing.");

	}

	public void ejectDollar() {
		System.out.println("Money is already processing, cannot eject dollar.");

	}

	@Override
	public void pressColaButton() {
		System.out.println("Cola button already pressed.");

	}

	@Override
	public void pressSpriteButton() {
		System.out.println("Cola button already pressed.");

	}

	@Override
	public void dispense() {
		if(sodaMachine.getColaCount() > 0) {
			sodaMachine.releaseColaSoda();
			sodaMachine.setState(sodaMachine.getNoDollarState());
		}
		else {
			System.out.println("Cola sold out.");
			if(sodaMachine.getSpriteCount() > 0)
				sodaMachine.setState(sodaMachine.getColaSoldOutNotSpriteState());
			else
				sodaMachine.setState(sodaMachine.getSoldOutState());
		}
	}

}
