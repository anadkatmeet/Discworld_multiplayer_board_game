package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Fire Brigade extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class TheFireBrigade extends PlayerCardActions {
	//scroll
	//play another card
	
	public TheFireBrigade(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Choose a player, if he doesnot pay you $5 then you can remove one of his buildings from the board.)");
		actionList.add("Play Another card");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		System.out.println("Select a player.");
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if(!(Helper.playerList.get(i).equals(p)))
			{
				System.out.println(i+" for "+Helper.playerList.get(i).getColor()+" player");
			}
		}
		Scanner scan=new Scanner(System.in);
		do
		{
			int num=scan.nextInt();
			if(Helper.playerList.contains(Helper.playerList.get(num))){
				System.out.println("This message for "+Helper.playerList.get(num).getColor()+" player");
				System.out.println("you wanna pay $5 to "+p.getColor()+" player ?\n1-yes\n2-No");
				do {
					int value=scan.nextInt();
					
					if (!((value==1)||(value==2))) {
						System.out.println("Wrong choice");
						continue;
					}
					//perform take money
					if (value==1) {
						if(Helper.payToBank(5, Helper.playerList.get(num)))
						{
							Helper.takeFromBank(5, p);
							System.out.println("Paid $5 to "+p.getColor()+" player");
							break;
						}
					}
					else
					{
						System.out.println(Helper.playerList.get(num).getColor()+" refused to pay so you can remove his building.");
						do {
							System.out.println("Want to remove building ?\n1-yes\n2-No");
							int number=scan.nextInt();
							
							if (!((value==1)||(value==2))) {
								System.out.println("Wrong choice");
								continue;
							}
							//perform take money
							if (value==1) {
								System.out.println("select an area.");
								for (int i = 0; i < board.cityAreaObejctList.size(); i++) {
									if(board.cityAreaObejctList.get(i).getBuilding().equals(Helper.playerList.get(num).getColor()))
									{
										System.out.println(i+" for "+board.getCityAreaByNumber(i));
									}
								}
								do
								{
									int temp=scan.nextInt();
									if(board.cityAreaObejctList.contains(board.getCityAreaByNumber(temp)))
									{
										board.getCityAreaByNumber(temp).setBuilding("none");
										break;
									}
									else
									{
										System.out.println("Wrong choice.");
										continue;
									}
								}
								while(true);
								break;
							}
							break;
						} while (true);
						break;
					}
					break;
				} while (true);
			}
			break;
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