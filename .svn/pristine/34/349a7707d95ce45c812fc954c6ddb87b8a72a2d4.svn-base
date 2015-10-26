package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Mr Pin Andmr Tulip extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardActions. It has two events to do  1>Assassination and 2>Take money($1).
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class MrPinAndmrTulip extends PlayerCardActions {
	
	// Assassinatino
	// take 1$
	public MrPinAndmrTulip(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Assasination");
		actionList.add("Take Money ($1)");
	}
	
	@Override
	public void scroll() {
		//implement loan from bank
		
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
			//perform Take Money
			if (value==1) {
				Helper.takeFromBank(1, p);
			}
			break;
		} while (true);
		
	}

}
