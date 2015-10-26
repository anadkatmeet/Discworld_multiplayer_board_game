package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, CMOT Dibbler extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class CMOTDibbler extends PlayerCardActions {
	// scroll
	// play another card
	
	public CMOTDibbler(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Roll the die, \n\t\t\tOn a roll of '7' or more you take $4 from the bank. \n\t\t\tOn a roll of '1' you must pay $2 to the bank or remove one of your minions from the board.\n\t\t\tAll other results have no effects.)");
		actionList.add("Play another card");
		
	}
	
	@Override
	public void scroll() {
		int dienum=Helper.rollDice();
		System.out.println("Result of rolling die is "+dienum);
		if(dienum>=7)
		{
			Helper.takeFromBank(4, p);
		}
		else if(dienum==1)
		{
			System.out.println("You must select any of below two options");
			System.out.println("1 - to pay $2 to the bank");
			System.out.println("2 - to remove one of your minions from the board");
			Scanner input=new Scanner(System.in);
			do {
				int value=input.nextInt();
				
				if (!((value==1)||(value==2))) {
					System.out.println("Wrong choice");
					continue;
				}
				//perform take money
				if (value==1) {
					Helper.payToBank(2, p);
				}
				else if(value==2)
				{
					for (int i = 0; i < board.cityAreaObejctList.size(); i++) {
						if (board.cityAreaObejctList.get(i).minions.get(p.getColor())>0) {
							System.out.println(board.cityAreaObejctList.get(i).cityAreaNumber+"-for area "+board.cityAreaObejctList.get(i).name+ " to remove a minion from");
						}
					}
					Scanner input2=new Scanner(System.in);
					int i=input2.nextInt();
					board.getCityAreaByNumber(i).removeMinion(p.getColor());
				}
				break;
			} while (true);
			
		}
		else
		{
			System.out.println("Results have no effects.");
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
			//perform take money
			if (value==1) {
				scroll();
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Play another card' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			
			if (value==1) {
				//Play another card
				p.displayUnusedCards(board);
			}
			break;
		} while (true);
	}

}

