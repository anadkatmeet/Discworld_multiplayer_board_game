package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;


import source.Helper;
import source.Player;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Thieves Guild extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class TheThievesGuild extends PlayerCardActions {
	
	//scroll
	// place aminion
	public TheThievesGuild(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Take $2, if possible, from every other player.)");
		actionList.add("Place a Minion");
	}
	
	@Override
	public void scroll() {
		for (int i = 0; i < Helper.playerList.size(); i++) {
			Player temp=Helper.playerList.get(i);
			if(Helper.payToBank(2, temp)){
				Helper.takeFromBank(2, p);
			}
		}
	}

	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Scroll' action?\n1-yes\n2-No");
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
			//perform place a minion
			if (value==1) {
				Helper.placeMinion(board, p);
			}
			break;
		} while (true);
		
	}

}
