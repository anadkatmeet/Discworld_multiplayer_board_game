package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards,MrGryle extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Assassination and 2>Take Money($1).
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class MrGryle extends PlayerCardActions {
	
	// assassination
	// take 1$
	public MrGryle(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Assasination");
		actionList.add("Take Money ($1)");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
	}



	@Override
	public void startPlayerCardActions() {
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
			System.out.println("Want to play 'Take Money ($1)' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			if (value==1) {
				Helper.takeFromBank(1, p);
			}
			break;
		} while (true);
	}

}