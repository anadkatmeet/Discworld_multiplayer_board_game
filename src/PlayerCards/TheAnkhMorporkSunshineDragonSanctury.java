package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;


/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Ankh Morpork Sunshine extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class TheAnkhMorporkSunshineDragonSanctury extends PlayerCardActions {
	
	//scroll
	// play another card
	
	public TheAnkhMorporkSunshineDragonSanctury(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Any one player must give you $1)");
		actionList.add("Play another Card");
	}
	
	@Override
	public void scroll() {
		//implement scroll
		System.out.println("Please Select a player to ask for $1\n");
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if(!(Helper.playerList.get(i).getColor().equals(p.getColor())))
			{
				System.out.println((i)+" for "+Helper.playerList.get(i).getColor()+" color player");
			}
		}
		Scanner input=new Scanner(System.in);
		int value=input.nextInt();
		do
		{
			if(value>=0 || value<Helper.playerList.size()-1)
			{
				if(Helper.payToBank(1, Helper.playerList.get(value)))
				{
					Helper.takeFromBank(1, p);
					break;
				}
			}
			else
			{
				System.out.println("wrong Choice");
			}
		}while(true);
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
