/**
 * 
 */
package PlayerCards;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import source.Helper;



/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, History Monks extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class HistoryMonks extends PlayerCardActions {
	//scroll
	// place minion
	
	public HistoryMonks(String name)  {
		// TODO Auto-generated constructor stub
		
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Shuffle the discard pile and draw four cards randomly.\n\t\t\tPlace the remaining cards back as the discard pile)");
		actionList.add("Place a Minion");
		
	}

	

	/* (non-Javadoc)
	 * @see PlayerCards.PlayerCardActions#startPlayerCardActions()
	 */
	@Override
	public void startPlayerCardActions() {
		// TODO Auto-generated method stub
		
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

	/* (non-Javadoc)
	 * @see PlayerCards.PlayerCardActions#scroll()
	 */
	@Override
	public void scroll() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			Random random=new Random();
			int value=random.nextInt(Helper.personalitySet.size());
			p.playerCards.add(Helper.playerCardSetDiscarded.get(value));
			Helper.playerCardSetDiscarded.remove(Helper.playerCardSetDiscarded.get(value));
		}
	}

}
