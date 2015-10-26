/**
 * 
 */
package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;


/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Inigo Skimmer extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Assassination and 2>Take Money($2).
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class InigoSkimmer extends PlayerCardActions {

	// assassination
	// take 2$
	
	public InigoSkimmer(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Assassination");
		actionList.add("Take Money ($2) ");
		
	}
	

	/* (non-Javadoc)
	 * @see PlayerCards.PlayerCardActions#startPlayerCardActions()
	 */
	@Override
	public void startPlayerCardActions() {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Assasination' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			
			if (value==1) {
				assassination(board, p);
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
	}

	/* (non-Javadoc)
	 * @see PlayerCards.PlayerCardActions#scroll()
	 */
	
	@Override
	public void scroll() {
		// TODO Auto-generated method stub

	}

}
