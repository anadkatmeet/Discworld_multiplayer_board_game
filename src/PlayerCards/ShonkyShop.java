package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;



/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Shonky Shop extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Building.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class ShonkyShop extends PlayerCardActions {
	// scroll
	// place a building
	
	public ShonkyShop(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - ('Discard as many cards as you wish and take $1 for each discard')");
		actionList.add("Place a Building");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		int unusedsize=0;
		for (int i = 0; i < p.playerCards.size(); i++) {
			if(!(p.playerCards.get(i).used)&&!p.interruptCollection.contains(p.playerCards.get(i)))
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
						if(temp.contains(value))
						{
							p.playerCards.get(value).used=true;
							Helper.takeFromBank(1, p);
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
			System.out.println("Want to play 'Scroll' action?\n1-yes\n2-No");
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
			System.out.println("Want to play 'Place a Building' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform place a building
			if (value==1) {
				Helper.placeABuilding(board, p);
			}
			break;
		} while (true);
		
	}

}
