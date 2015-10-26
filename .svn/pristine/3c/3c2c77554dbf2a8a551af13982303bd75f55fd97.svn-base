package PersonalityCards;

import source.MapBoard;
import source.Player;

/**
 * 
 * @author p_pandy
 * 
 * <p>This is class for Chrysoprase. It overrides method checkWinningConditions from PersonalityCardParent and set the proper winning condition.</p>
 * 
 * @see PersonalityCardParent
 * @see Chrysoprase(String name) 
 * 
 */

public class Chrysoprase extends PersonalityCardParent {
	/**
	 * <p> Constructor of Chrysoprase set the name of Card, whenever constructor is created Card name is assigned </p> 
	 * @param name - Name of the card, in this case Chrysoprase, whenever constructor is created Card name is assigned 
	 */
	public Chrysoprase(String name, String condition){
		cardName=name;
		winningCondition=condition;
	}
	
	
	public boolean checkWinningConditions(int totalPlayers, Player p,MapBoard board){
		int sum1=p.getPlayermoney();
		int sum2=0;
		int loanamount=p.getLoan()*12;

		for (int i = 0; i < p.getCityAreasConquered().size(); i++) {
			if(!(p.getCityAreasConquered().get(i).demons>0))
			{
				sum2+=p.getCityAreasConquered().get(i).cost;
			}
		}
		
		if((sum1+sum2)-loanamount>=50)
			return true;
		
		return false;
	}
	
}
