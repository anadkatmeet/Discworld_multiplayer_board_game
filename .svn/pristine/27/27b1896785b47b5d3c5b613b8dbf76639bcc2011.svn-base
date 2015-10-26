package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Hex extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Building.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class Hex extends PlayerCardActions {
	
	// scroll
	// place building
	
	public Hex(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Take three cards from the draw deck.)");
		actionList.add("Place a Building.");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		for (int i = 0; i < 3; i++) {
				PlayerCardActions temp=Helper.getRandomPlayerCard();
				temp.p=p; 
				temp.board=board;
				p.playerCards.add(temp);
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
			if (value==1) {
				scroll();
			}
			break;
		} while (true);
		
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
	}

}
