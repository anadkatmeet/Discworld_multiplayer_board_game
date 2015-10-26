package PersonalityCards;

import source.MapBoard;
import source.Player;

/***
 * 
 * @author c_sarvai
 * 
 * This is class for DragonKingofArms. It overrides method checkWinningConditions from PersonalityCardParent and set the proper winning condition
 * 
 * @see PersonalityCardParent
 * @see DragonKingofArms(String name)
 */

public class DragonKingofArms extends PersonalityCardParent{
	/**
	 * <p> Constructor of DragonKingofArms set the name of Card, whenever constructor is created Card name is assigned </p> 
	 * @param name - Name of the card, in this case DragonKingofArms, whenever constructor is created Card name is assigned 
	 */
	public DragonKingofArms(String name, String condition){
		cardName=name;
		winningCondition=condition;
	}
	
	public boolean checkWinningConditions(int totalPlayers, Player p,MapBoard board){
		if(board.showTroubleMarkers().size()>=8)
			return true;
		return false;
		
	}
}
