package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Wallace Sonky extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has Interrupt to perform.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class WallaceSonky extends PlayerCardActions {
	
	// Interrupt
	public WallaceSonky(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Interrupt - (You cannot be affected by the text on a card played by another player.)");
	}
	
	@Override
	public void scroll() {
		
	}



	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Interrupt' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform interrupt
			if (value==1) {
				//interrupt
			}
			break;
		} while (true);
		
	
	}

}
