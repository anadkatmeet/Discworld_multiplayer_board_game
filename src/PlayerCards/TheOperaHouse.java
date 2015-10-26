package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Opera House extends the PlayerCardAction.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Place a Building and 2>Scroll.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class TheOperaHouse extends PlayerCardActions {
	
	//place building
	//scroll
	public TheOperaHouse(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Place a Building");
		actionList.add("Scroll - ('Earn $1 for each minion in the Isle of Gods.')");
		
		
	}
	
	@Override
	public void scroll() {
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
			//perform Place aBuilding
			if (value==1) {
				Helper.placeABuilding(board, p);
			}
			break;
		} while (true);
		
		
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
		
	}

}
