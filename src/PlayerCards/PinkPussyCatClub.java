package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Pink Pussy Cat Club extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Take Money($3) and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class PinkPussyCatClub extends PlayerCardActions {
	//take3$
	//play anotehr card
	
	public PinkPussyCatClub(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Take Money ($3)");
		actionList.add("Play Another Card");
	}
	
	@Override
	public void scroll() {
		//implement loan from bank
		
	}

	

	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Take Money ($3)' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Take Money
			if (value==1) {
				Helper.takeFromBank(3, p);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Play Another Card' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Play Another Card
			if (value==1) {
				//Play Another Card
				p.displayUnusedCards(board);
			}
			break;
		} while (true);
		
	}

}
