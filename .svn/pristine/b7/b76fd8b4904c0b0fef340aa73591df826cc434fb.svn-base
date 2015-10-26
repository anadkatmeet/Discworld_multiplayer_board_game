package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, MrsCake extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Take Money($2) and 2>Place a Building.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class MrsCake extends PlayerCardActions {
	//scroll
	//take 2$
	// place building
	
	public MrsCake(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Look at all but one of the unused Personality cards)");
		actionList.add("Take Money ($2) ");
		actionList.add("Place a Building");
		
	}
	
	@Override
	public void scroll() {
		System.out.println("Unused Personality cards");
		for (int i = 0; i < Helper.personalitySet.size(); i++) {
			System.out.println(Helper.personalitySet.get(i).cardName);
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
			//perform take money
			if (value==1) {
				scroll();
			}
			break;
		} while (true);

		
		do {
			System.out.println("Want to play 'Take Money ($2)' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			
			if (value==1) {
				Helper.takeFromBank(2, p);
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
