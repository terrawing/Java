package stateSodaMachine;

public class SodaMachineMain {

	public static void main(String[] args) {
		SodaMachine sodaMachine = new SodaMachine(1, 2);
		System.out.println(sodaMachine);

		sodaMachine.insertDollar();
		sodaMachine.pressSpriteButton();
		
		System.out.println(sodaMachine);
		
		sodaMachine.pressSpriteButton();
		
		sodaMachine.insertDollar();
		sodaMachine.pressSpriteButton();
		
		System.out.println(sodaMachine);
		
		sodaMachine.insertDollar();
		sodaMachine.pressSpriteButton();
		
		System.out.println(sodaMachine);
		
		sodaMachine.insertDollar();
		sodaMachine.pressColaButton();
		
		System.out.println(sodaMachine);
		
	}

}
