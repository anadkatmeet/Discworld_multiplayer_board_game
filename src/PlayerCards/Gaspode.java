package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Gaspode extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has one event to do  1>Interrupt.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class Gaspode extends PlayerCardActions {
	//Interrupt
	
	public Gaspode(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Interrupt - (Stop a player from moving or removing one of your minions.)");
	}
	
	@Override
	public void scroll() {
		
	}

	

	@Override
	public void startPlayerCardActions() {
		/*Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Interrupt' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform take money
			if (value==1) {
				//Implement Interrupt action
			}
			break;
		} while (true);
		*/
	}

}

