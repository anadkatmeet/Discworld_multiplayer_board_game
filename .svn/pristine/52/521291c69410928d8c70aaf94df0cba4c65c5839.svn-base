package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Harry King extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Place a Minion and 2>Scroll.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class HarryKing extends PlayerCardActions {
	
	// scroll
	// place minions
	
	public HarryKing(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Place a minion");
		actionList.add("Scroll - (Discard as many cards you wish and take $2 for each one discarded.)");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		int unusedsize=0;
		for (int i = 0; i < p.playerCards.size(); i++) {
			if(!(p.playerCards.get(i).used) && !p.interruptCollection.contains(p.playerCards.get(i)))
			{
				unusedsize++;
			}
		}
		System.out.println("You have "+unusedsize+" player cards in hand\nPlease enter a number to discard the player card from you hand which is less than or equal to "+unusedsize);
		Scanner scan=new Scanner(System.in);
		int input=scan.nextInt();
		do
		{
			if(input>p.playerCards.size() || input<0)
			{
				System.out.println("Wrong Choice");
			}
			else
			{
				ArrayList<Integer> temp=new ArrayList<>();
				for (int i = 0; i < input; i++) {
					for (int j = 0; j < p.playerCards.size(); j++) {
						if (!p.playerCards.get(j).used &&
								!p.interruptCollection.contains(p.playerCards.get(j))) {
							System.out.println(j+" for "+p.playerCards.get(j).playerCardName);
							temp.add(j);
							//p.playerCards.get(i).used=true;
						}
					}
					do
					{
						int value=scan.nextInt();
						if(value>=0 && value<unusedsize)
						{
							p.playerCards.get(value).used=true;
							Helper.takeFromBank(2, p);
							break;
						}
						else
						{
							System.out.println("Wrong Choice.");
							continue;
						}
					}while(true);
				}
				break;
			}
		}while(true);
	}


	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Place a Minion' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			if (value==1) {
				Helper.placeMinion(board, p);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Scroll' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			if (value==1) {
				scroll();
			}
			break;
		} while (true);
		
	}

}
