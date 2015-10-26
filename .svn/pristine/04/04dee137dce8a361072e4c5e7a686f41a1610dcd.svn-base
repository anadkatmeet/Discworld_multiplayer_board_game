package PlayerCards;
import source.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import source.*;


/***
 * 
 * @author c_sarvai
 * Abstract base class for every action of player card.
 * By using {@link MapBoard}
 *
 */
public abstract class PlayerCardActions implements Serializable {
	
	public MapBoard board=null;
	public Player p=null;
	public boolean used=false;
	public String playerCardName;
	ArrayList<String> actionList;
	/**
	 * <p>
	 *  This method shows the details of the player card.
	 *  Like the list of different actions.
	 * </p>
	 */
	public void showPlayerCardDetails(){
		System.out.println("\tPlayer Card Name: "+playerCardName);
		System.out.println("\n\tEvent     \tAction Name");
		System.out.println("----------------------------------------------------------------------------------------------");
		for (int i = 0; i < actionList.size(); i++) {
			System.out.println( "\t"+ (i+1)+"\t\t" + actionList.get(i));
		
			//System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	
	/**
	 * <p> Abstract method to start the actions of the player card.
	 *  This method's implementation is on the individual player card.</p>
	 */
	abstract public void startPlayerCardActions();
	
	/**
	 * <p>Assassination performed in this method,Remove one minion or troll or demon
	 *  of your choice from area that contains TM and remove TM.
	 *  Player is given three options,1>other player minion/2>Demon/3>Troll, for what he wants to remove he can remove.
	 *  On the bases of input it removes the requested stuff.
	 *  </p>
	 * @param board - Object of MapBoard class
	 * @param p - Object of Player class
	 */
	public void assassination(MapBoard board,Player p)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("What you want to remove?");
		ArrayList<String> colorlist=Helper.color;
		ArrayList<Integer> list=board.showTroubleMarkers();
		ArrayList<Integer> temp=new ArrayList<>();
		
		System.out.println("1-Other players minion \n2-Demon \n3-Troll");
		
		do{
		//int localcounter=1;
		int value=input.nextInt();
		if (value==1) {	/*user wants to remove other players minion*/
			System.out.println("Please select the player to assinate it's minion");
			for (int i = 0; i < Helper.playerList.size(); i++) {
				if(!(Helper.playerList.get(i).equals(p)) && Helper.playerList.get(i).getTotalminions()<12)
				{
					System.out.println(i + ". for "+Helper.playerList.get(i).getColor()+" player");
					temp.add(i);
				}
			}
			
			do
			{
				int tempinput=input.nextInt();
				
					if(temp.contains(tempinput))
					{
						Player pl=Helper.playerList.get(tempinput);
						if(Helper.checkAndCallGaspodeInterrupt(board, pl, p, 0)){
							return;
						}
						System.out.println("Please select the City area to assinate Selected player's minion");
						ArrayList<Integer> citytemp=new ArrayList<>();
						
						for (int i = 0; i < list.size(); i++) {
							CityArea tempCA=board.getCityAreaByNumber(list.get(i));
							if(tempCA.minions.get(pl.getColor())>0)
							{
								System.out.println(tempCA.cityAreaNumber + ". for "+tempCA.name);
								citytemp.add(tempCA.cityAreaNumber);
							}
						}
						
						do
						{
							int cityinput=input.nextInt();
							if(citytemp.contains(cityinput))
							{
								board.getCityAreaByNumber(cityinput).removeMinion(pl.getColor());
								Helper.checkAndCallFreshStartClubInterrupt(board, pl, p);
								return;
							}
							else
							{
								System.out.println("Wrong Choice.");
								System.out.println("Enter your choice again");
								continue;
							}
						}while(true);
					}
					else
					{
						System.out.println("Wrong Choice.");
						System.out.println("Enter your choice again");
						continue;
					}

			}while(true);
			
			
		}//end if for minions
		else if(value==2){ /*user wants to remove demon*/
			ArrayList<Integer> templist=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				CityArea tempCA=board.getCityAreaByNumber(list.get(i));
				if (tempCA.demons>0) {
					System.out.println(list.get(i)+" for "+tempCA.name);
					templist.add(list.get(i));
				}
			}
			if (templist.size()>0) {	//there are areas that has demons
				System.out.println("Enter your choice");
				do {
					int k=input.nextInt();	//"k" will be city area #
					if (templist.contains(k)) {
						board.getCityAreaByNumber(k).removeDemons();
						return;
					}
					else{
						System.out.println("Wrong choice");
						System.out.println("Enter your choice again");
						continue;
					}
					
				} while (true);
				
			}else{						//there are no areas that has demons
				System.out.println("no area found that has demons");
				return;
			}
			//break;
		}
		else if(value==3){	/*user wants to remove troll*/
			ArrayList<Integer> templist=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				CityArea tempCA=board.getCityAreaByNumber(list.get(i));
				if (tempCA.trolls>0) {
					System.out.println(list.get(i)+" for "+tempCA.name);
					templist.add(list.get(i));
				}
			}
			if (templist.size()>0) {	//there are areas that has trolls
				System.out.println("Enter your choice");
				do {
					int k=input.nextInt();	//"k" will be city area #
					if (templist.contains(k)) {
						board.getCityAreaByNumber(k).removeTrolls();
						return;
					}
					else{
						System.out.println("Wrong choice");
						System.out.println("Enter your choice again");
						continue;
					}
					
				} while (true);
				
			}else{						//there are no areas that has trolls
				System.out.println("no area found that has trolls");
				return;
			}
			//break;
		}
		else{
			System.out.println("Wrong choice");
			System.out.println("Enter your choice again");
			continue;
		}
			
		
		}while(true);
		//
	}
	
	
	/**
	 * <p>This is abstract method for scroll. All Player cards implements the scroll method depending on the scroll condition.
	 * </p>
	 */
	public abstract void scroll();
	/**
	 * <p>Random Events are mandatory. The player card which has the random event must perform that event.
	 * It executes the RandomEvents.
	 * </p>
	 * @param board - Object of the MapBoard class as the parameter
	 */
	public void randonEvent(MapBoard board)
	{
		Helper.randomEventObject.getRandomEvent().execute(board);
	}
	
	/**
	 * <p> This method is called when player has to play another card.</p>
	 */
	/*public void playAnotherCard()
	{
		
	}
	*/
	
	/**
	 * <p> This method has the implementation for the interrupt to perform</p>
	 */
	public void interrupt()
	{
		
	}
}
