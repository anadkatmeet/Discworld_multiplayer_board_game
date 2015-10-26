 package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Fools Guild extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class TheFoolsGuild extends PlayerCardActions {
	//scroll
	// place minion
	
	public TheFoolsGuild(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Select another player.\n\t\t\tIf they do not give you $5 then place this card in front of them.\n\t\t\tThis card now counts towards their hand size of five cards when they come to refill their hand.\n\t\t\tThey cannot get rid of this card.)");
		actionList.add("Place a minion");
		
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		
	}


	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		
		do {
			System.out.println("Want to play 'Scoll' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform scroll
			if (value==1) {
				scroll();
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
			//perform take money
			if (value==1) {
				Helper.placeMinion(board, p);
			}
			break;
		} while (true);
		
		
	}

}
