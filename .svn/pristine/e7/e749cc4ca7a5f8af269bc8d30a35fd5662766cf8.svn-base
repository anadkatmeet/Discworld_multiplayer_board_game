package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.CityArea;
import source.Helper;
import source.Player;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Foul Ole Ron extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */

public class FoulOleRon extends PlayerCardActions {
	// scroll
	// play another card
	
	public FoulOleRon(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Move a minion belonging to another player from one area to an adjacent area.)");
		actionList.add("Play Another card");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		ArrayList<Integer> temp=new ArrayList<>();
		Scanner input=new Scanner(System.in);
		System.out.println("Select which players minion you want to move");
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if (Helper.playerList.get(i).equals(p)) {
				continue;
			}
			System.out.println(i+" for "+Helper.playerList.get(i).getColor()+" player");
			temp.add(i);
		}
		do{
			int value=input.nextInt();
			if(!(temp.contains(value))){
				System.out.println("Wrong choice, select again");
				continue;
			}
			Player pl=Helper.playerList.get(value);
			
			
			//check and call gaspode interrupt before this
			if(Helper.checkAndCallGaspodeInterrupt(board, pl, p,1)){
				return;
			}
			ArrayList<Integer> templist=new ArrayList<>();
			System.out.println("Select an area from which you want to pick "+pl.getColor()+" color minion");
			for (int i = 0; i < board.cityAreaObejctList.size(); i++) {
				if (board.cityAreaObejctList.get(i).minions.get(pl.getColor())>0) {
					System.out.println(board.cityAreaObejctList.get(i).cityAreaNumber+" for "+board.cityAreaObejctList.get(i).name);
					templist.add(board.cityAreaObejctList.get(i).cityAreaNumber);
				}
			}
			do{
				int areanumber=input.nextInt();
				if(!(templist.contains(areanumber))){
					System.out.println("Wrong choice, select again");
					continue;
				}
				//minion removed
				CityArea tempCA=board.getCityAreaByNumber(areanumber);
				tempCA.removeMinion(pl.getColor());
				
				//now display adjacent areas to place that minion
				System.out.println("Select adjacent area to place this minion");
				templist=new ArrayList<>();
				
				for (int i = 0; i < tempCA.adjcentAreas.size(); i++) {
					System.out.println(tempCA.adjcentAreas.get(i)+" for "+board.getCityAreaByNumber(tempCA.adjcentAreas.get(i)).name);
					templist.add(tempCA.adjcentAreas.get(i));
				}
				
				do{
					int tempnumber=input.nextInt();
					if(!(templist.contains(tempnumber))){
						System.out.println("Wrong choice, select again");
						continue;
					}
					board.getCityAreaByNumber(tempnumber).addMinion(pl.getColor());
					return;
					
				}while(true);
				
			}while(true);
			
			
			
			
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

