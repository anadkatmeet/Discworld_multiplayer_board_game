package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.*;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Mr Boggis extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class MrBoggis extends PlayerCardActions {
	
	//scroll
	//place a minion
	public MrBoggis(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Take $2,if possible from every other player)");
		actionList.add("Place a minion");
	}
	
	@Override
	public void scroll() {
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if(Helper.payToBank(2,Helper.playerList.get(i)))
			{
				Helper.takeFromBank(2, p);
			}
		}
		
		System.out.println("You got the money from other players");
	}

	
	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play scroll action?\n1-yes\n2-No");
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
			System.out.println("Want to play place a minion action?\n1-yes\n2-No");
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
