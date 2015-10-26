package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
import source.Player;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Here'N'now extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class HereNnow extends PlayerCardActions {
	// scroll
	// another card
	
	public HereNnow(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Roll the Die.\n\t\t\tOn the roll of 7 or more you take $3 from player of your choice.\n\t\t\tOn the roll of '1' you must remove one of your minions from the board.\n\t\t\tAll other results have no effect)");
		actionList.add("Play Another Card");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		int dienum=Helper.rollDice();
		Scanner input=new Scanner(System.in);
		System.out.println("Result of rolling the die is "+dienum);
		if(dienum>=7)
		{
			System.out.println("Please Select a player to ask for $3\n");
			for (int i = 0; i < Helper.playerList.size(); i++) {
				if(!(Helper.playerList.get(i).getColor().equals(p.getColor())))
				{
					System.out.println((i)+" for "+Helper.playerList.get(i).getColor()+" color player");
				}
			}
			
			int value=input.nextInt();
			Player temp=Helper.playerList.get(value);
			do
			{
				if(value>=0 || value<Helper.playerList.size()-1)
				{
					if(Helper.payToBank(3, temp))
					{
						Helper.takeFromBank(3, p);
						return;
					}
				}
				else
				{
					System.out.println("wrong Choice");
				}
			}while(true);
		}
		else if(dienum==1){
			ArrayList<Integer> temp=new ArrayList<>();
			System.out.println("You have to remove one of your minions from the board");
			for (int i = 0; i < board.cityAreaObejctList.size(); i++) {
				if (board.cityAreaObejctList.get(i).minions.get(p.getColor())>0) {
					System.out.println(board.cityAreaObejctList.get(i).cityAreaNumber+" for "+board.cityAreaObejctList.get(i).name);
					temp.add(board.cityAreaObejctList.get(i).cityAreaNumber);
				}
				
			}
			
			do{
				int value=input.nextInt();
				if(!(temp.contains(value))){
					System.out.println("Wrong choice");
					continue;
				}
				board.getCityAreaByNumber(value).removeMinion(p.getColor());
			}while(true);
		
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
			//perform scroll
			if (value==1) {
				scroll();
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Play Another Card' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Play Another Card
			if (value==1) {
				//Play another card
				p.displayUnusedCards(board);
			}
			break;
		} while (true);
		
	}

}
