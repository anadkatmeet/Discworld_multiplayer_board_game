package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Fresh Start Club extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has one event to do  1>Interrupt.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class FreshStartClub extends PlayerCardActions {
	// Interrupt
	
	public FreshStartClub(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Interrupt - (If you have a minion removed you can place him in a different area.)");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		
	}



	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Interrupt' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform scroll
			if (value==1) {
				//Interrupt
			}
			break;
		} while (true);
		
		
	}

}

