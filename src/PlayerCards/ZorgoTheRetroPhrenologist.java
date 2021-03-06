package PlayerCards;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import source.*;
import PersonalityCards.PersonalityCardParent;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Zorgo The Retro Phrenologist extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Building
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class ZorgoTheRetroPhrenologist extends PlayerCardActions {
	
	//scroll 
	//place a building
	public ZorgoTheRetroPhrenologist(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (You may exchange your personality card with one drawn \n\t\t\trandomly from those not in use.)");
		actionList.add("Place a Building");
	}
	
	@Override
	public void scroll() {
		Random random=new Random();
		int value=random.nextInt(Helper.personalitySet.size());
		PersonalityCardParent temp=Helper.personalitySet.get(value);
		System.out.println("New personality card name :\t"+temp.cardName);
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to swap your card?\n1-yes\n2-No");
			int j=input.nextInt();
			
			if (!((j==1)||(j==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			
			if (j==1) {
				p.setPersonalityCard(temp);
				Helper.personalitySet.remove(temp);
				System.out.println("Personality card name changed!");
			}
			break;
		} while (true);
		
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
