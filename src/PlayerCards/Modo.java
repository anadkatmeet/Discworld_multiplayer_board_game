package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
import source.Player;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Modo extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class Modo extends PlayerCardActions {
	
	// scroll
	// minion
	public Modo(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Discard one card)");
		actionList.add("Place a Minion");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		
		for (int i = 0; i < p.playerCards.size(); i++) {
			if (!p.playerCards.get(i).used &&
					!p.interruptCollection.contains(p.playerCards.get(i))) {
				System.out.println(i+" for "+p.playerCards.get(i).playerCardName);
				//p.playerCards.get(i).used=true;
			}
		}
		Scanner scan=new Scanner(System.in);
		do
		{
			int value=scan.nextInt();
			if(p.playerCards.contains(p.playerCards.get(value)))
			{
				p.playerCards.get(value).used=true;
				break;
			}
			else
			{
				System.out.println("Wrong Choice.");
				continue;
			}
		}while(true);
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
