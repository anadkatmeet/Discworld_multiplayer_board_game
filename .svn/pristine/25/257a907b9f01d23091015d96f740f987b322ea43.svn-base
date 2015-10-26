package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Captain Carrot extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has three events to do  1>Place a Minion, 2>Remove one trouble maker and 2>Take Money($1).
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class CaptainCarrot extends PlayerCardActions {
	
	
	public CaptainCarrot(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Place a Minion");
		actionList.add("Remove one trouble marker");
		actionList.add("Take Money ($1) ");
		
	}
	
	@Override
	public void scroll() {
	
	}

	// Place Minion
	// Remove one trouble marker 
	// Take money 

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
		
		do {
			System.out.println("Want to play 'Remove one trouble marker' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform take money
			if (value==1) {
				Helper.removeTM(board);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Take Money ($1)' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			
			if (value==1) {
				Helper.takeFromBank(1, p);
			}
			break;
		} while (true);
	}

}
