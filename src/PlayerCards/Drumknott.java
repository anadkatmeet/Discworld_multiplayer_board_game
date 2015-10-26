package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Drum Knott extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has one event to do  1>Scroll.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class Drumknott extends PlayerCardActions {
	
	// scroll
	
	public Drumknott(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Play any two other cards from your hand)");
		
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		for (int i = 0; i < 2; i++) {
			p.displayUnusedCards(board);
		}
	}



	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		
		do {
			System.out.println("Want to play 'Scoll' action?\n1-yes\n2-No");
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


