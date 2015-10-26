package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Librarian extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has one event to do  1>Scroll.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class Librarian extends PlayerCardActions {
	
	// scroll
	public Librarian(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Take four cards from the draw desk.)");
		
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		for (int i = 0; i < 4; i++) {
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
