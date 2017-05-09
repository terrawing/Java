package stateSodaMachine;

public class SodaMachine {
	State soldOutState;
	State haveDollarState;
	State noDollarState;
	State colaSoldState;
	State spriteSoldState;
	State colaSoldOutNotSpriteState;
	State spriteSoldOutNotColaState;
	State state = soldOutState;

	int colaCount = 0;
	int spriteCount = 0;
	
	public SodaMachine(int numberCola, int numberSprite) {
		soldOutState = new SoldOutState(this);
		haveDollarState = new HaveDollarState(this);
		noDollarState = new NoDollarState(this);
		colaSoldState = new ColaSoldState(this);
		spriteSoldState = new SpriteSoldState(this);
		colaSoldOutNotSpriteState = new ColaSoldOutNotSpriteState(this);
		spriteSoldOutNotColaState = new SpriteSoldOutNotColaState(this);
		
		this.colaCount = numberCola;
		this.spriteCount = numberSprite;
		if(numberCola > 0 || numberSprite > 0) {
			state = noDollarState;
		}
		
	}
	
	public void insertDollar() {
		state.insertDollar();
	}
	
	public void ejectDollar() {
		state.ejectDollar();
	}
	
	public void pushButton(int buttonNumber) {
		if(buttonNumber == 0) 
			state.pressColaButton();
		else
			state.pressSpriteButton();
		
		state.dispense();
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	
	public void releaseColaSoda() {
		System.out.println("A cola pops out of the machine.");
		if(colaCount != 0) {
			colaCount = colaCount - 1;
		}
	}
	
	public void releaseSpriteSoda() {
		System.out.println("A Sprite pops out of the machine.");
		if(spriteCount != 0) {
			spriteCount = spriteCount - 1;
		}
	}
	
	public int getColaCount() {
		return colaCount;
	}
	
	public int getSpriteCount() {
		return spriteCount;
	}
	
	public State getNoDollarState() {
		return noDollarState;
	}
	
	public State getSoldOutState() {
		return soldOutState;
	}
	
	public State getHaveDollarState() {
		return haveDollarState;
	}
	
	public State getColaSoldState() {
		return colaSoldState;
	}
	
	public State getSpriteSoldState() {
		return spriteSoldState;
	}
	
	public State getColaSoldOutNotSpriteState() {
		return colaSoldOutNotSpriteState;
	}
	
	public State getSpriteSoldOutNotColaState() {
		return spriteSoldOutNotColaState;
	}
	
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("\nWilliam's Soda Machine...");
		output.append("\nCola: " + colaCount + " / Sprite: " + spriteCount);
		output.append("\nMachine " + state + "\n");
		return output.toString();
	}

	public void pressColaButton() {
		state.pressColaButton();
		state.dispense();
	}
	
	public void pressSpriteButton() {
		state.pressSpriteButton();
		state.dispense();
	}

}
