package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;


/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Sacharissa Cripslock extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class SacharissaCripslock extends PlayerCardActions {
	
	// scroll
	// place a minion
	public SacharissaCripslock (String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - ('Earn $1 for each trouble maker on the board')");
		actionList.add("Place a Minion");
	}
	
	@Override
	public void scroll() {
		int count=0;
		for (int i = 0; i < board.cityAreaObejctList.size(); i++) {
			if(board.cityAreaObejctList.get(i).troublemarkers)
			{
				count++;
			}
		}
		Helper.takeFromBank(count, p);
		
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