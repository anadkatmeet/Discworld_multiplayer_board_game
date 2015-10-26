package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Royal Mint extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Place a Building and 2>Take Money($5).
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class TheRoyalMint extends PlayerCardActions {
	
	//place building
	//take 5$
	public TheRoyalMint(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Place a Building");
		actionList.add("Take Money ($5)");
	}
	
	@Override
	public void scroll() {
		//empty
	}



	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Place a Building' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Place a Building 
			if (value==1) {
				Helper.placeABuilding(board, p);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Take Money ($5)' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Take Money
			if (value==1) {
				Helper.takeFromBank(5, p);
			}
			break;
		} while (true);
		
	}

}
