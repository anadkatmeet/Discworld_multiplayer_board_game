package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;


/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Sergeant Angua extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Remove One Trouble Maker and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class SergeantAngua  extends PlayerCardActions {
	
	// remove trouble marker
	// play another card
	public SergeantAngua(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Remove One Trouble Marker");
		actionList.add("Play another Card");
	}
	
	@Override
	public void scroll() {
		//implement scroll
		
	}



	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Remove One Trouble Marker' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform scroll
			if (value==1) {
				Helper.removeTM(board);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'play another card' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform play another card
			if (value==1) {
				//add play another card method
				p.displayUnusedCards(board);
			}
			break;
		} while (true);
		
	}

}

