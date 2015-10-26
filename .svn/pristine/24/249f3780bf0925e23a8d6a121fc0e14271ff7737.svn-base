package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Mr Bent extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class MrBent extends PlayerCardActions {
	
	// scroll
	// play another card
	
	public MrBent(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Place this card infront of you and take a loan from the bank.\n\t\t\tat the end of the game you must pay back $12 or lose 15 points )");
		actionList.add("Play another Card");
	}
	
	@Override
	public void scroll() {
		//implement loan from bank
		if(Helper.takeFromBank(10, p)){
			System.out.println("Successfully got the loan!");
//			p.loan++;
			p.setLoan(p.getLoan() + 1);
		}
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
