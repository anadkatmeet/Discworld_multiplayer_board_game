package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.CityArea;
import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Dysk extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Place a Building and 2>Scroll.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class TheDysk extends PlayerCardActions {
	// place building
	// scroll
	
	public TheDysk(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Place a Building");
		actionList.add("Scroll - (Earn $1 for each minion in the Isle of gods)");
		
	}
	
	@Override
	public void scroll() {
		//'int totalminions=board.getCityAreaByNumber(10).minions.size();
		int totalminions=0;
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if(board.getCityAreaByNumber(10).minions.get(Helper.playerList.get(i).getColor())>0)
			{
				totalminions++;
			}
		}
		Helper.takeFromBank(totalminions, p);
	}



	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Place a Building' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			
			if (value==1) {
				Helper.placeABuilding(board, p);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Scoll' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform take money
			if (value==1) {
				scroll();
			}
			break;
		} while (true);
		
		
	}

}
