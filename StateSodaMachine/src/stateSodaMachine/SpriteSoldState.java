package stateSodaMachine;

public class SpriteSoldState implements State {
	SodaMachine sodaMachine;
	
	public SpriteSoldState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}

	@Override
	public void insertDollar() {
		System.out.println("Please wait, money is processing.");
		
	}

	@Override
	public void ejectDollar() {
		System.out.println("Money is already processing, cannot eject dollar.");
		
	}

	@Override
	public void pressColaButton() {
		System.out.println("Sprite button already pressed.");
		
	}

	@Override
	public void pressSpriteButton() {
		System.out.println("Sprite button already pressed.");
		
	}

	@Override
	public void dispense() {
		if(sodaMachine.getSpriteCount() > 0) {
			sodaMachine.releaseSpriteSoda();
			sodaMachine.setState(sodaMachine.getNoDollarState());
		}
		else {
			System.out.println("Sprite sold out.");
			if(sodaMachine.getColaCount() > 0)
				sodaMachine.setState(sodaMachine.getSpriteSoldOutNotColaState());
			else
				sodaMachine.setState(sodaMachine.getSoldOutState());
		}
		
	}

}
