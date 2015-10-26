package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;


/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Agony Aunts extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has Three events to do  1>Assassination, 2>Take Money($2) and 3>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class TheAgonyAunts extends PlayerCardActions {
	
	// assassination
	// take 2$
	// place a minion
	
	public TheAgonyAunts(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Assasination");
		actionList.add("Take Money ($2)");
		actionList.add("Place a minion");
		
	}
	
	@Override
	public void scroll() {
		//implement scroll
		
	}



	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Assasination' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			
			if (value==1) {
				assassination(board, p);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Take Money($2)' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform take money
			if (value==1) {
				Helper.takeFromBank(2, p);
			}
			break;
		} while (true);
		do {
			System.out.println("Want to play 'Place a minion' action?\n1-yes\n2-No");
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
