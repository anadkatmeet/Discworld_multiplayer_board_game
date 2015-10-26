package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Groat extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has one event to do  1>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class Groat extends PlayerCardActions {
	/// place minion
	
	public Groat(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Place a Minion");
		
	}
	
	@Override
	public void scroll() {
		
	}



	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Place a Minion' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform take money
			if (value==1) {
				Helper.placeMinion(board, p);
			}
			break;
		} while (true);
		
	}

}
