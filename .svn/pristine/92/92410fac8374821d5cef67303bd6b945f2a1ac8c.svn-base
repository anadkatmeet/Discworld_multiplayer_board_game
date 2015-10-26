package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Hargas House of Ribs extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Take Money($3) and 2>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class HargasHouseOfRibs extends PlayerCardActions {
	/// take 3$
	// place minion
	
	public HargasHouseOfRibs(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Take Money($3)");
		actionList.add("Place a Minion");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		
	}


	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Take Money ($3)' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Take money
			if (value==1) {
				Helper.takeFromBank(3, p);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Place a Minion' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform place a minion
			if (value==1) {
				Helper.placeMinion(board, p);
			}
			break;
		} while (true);
		
	}

}
