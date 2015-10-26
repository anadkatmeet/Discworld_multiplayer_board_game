package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Mended Drum extends the PlayerCardAction.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Place a Building and 2>Take Money($2).
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class TheMendedDrum extends PlayerCardActions {
	//place building
	//take 2$
	
	public TheMendedDrum(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Place a Building");
		actionList.add("Take Money($2)");
		
		
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
			//perform Place aBuilding
			if (value==1) {
				Helper.placeABuilding(board, p);
			}
			break;
		} while (true);
		
		
		do {
			System.out.println("Want to play 'Take Money($2)' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Place aBuilding
			if (value==1) {
				Helper.takeFromBank(2, p);
			}
			break;
		} while (true);
		
	}

}
