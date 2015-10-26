package PersonalityCards;

import source.Helper;
import source.MapBoard;
import source.Player;

/***
 * 
 * @author c_sarvai
 * 
 * This is class for LordVetinari. It overrides method checkWinningConditions from PersonalityCardParent and set the proper winning condition
 * 
 * @see PersonalityCardParent
 *
 */

public class LordVetinari extends PersonalityCardParent{
	
	int count;
	/**
	 * <p> Constructor of LordVetinari set the name of Card, whenever constructor is created Card name is assigned </p> 
	 * @param name - Name of the card, in this case LordVetinari, whenever constructor is created Card name is assigned 
	 */
	
	public LordVetinari(String name, String condition){
		cardName=name;
		winningCondition=condition;
	}
	
	public boolean checkWinningConditions(int totalPlayers, Player p,MapBoard board){

		count = 0;
		for (int i = 0; i < board.cityAreaObejctList.size(); i++) {
			if (board.cityAreaObejctList.get(i).minions.get(p.getColor())>=1 && (board.cityAreaObejctList.get(i).demons==0))
				count++;
		}
		
		if ((totalPlayers==2 && count>=11)||(totalPlayers==3 && count>=10)||(totalPlayers==4 && count>=9))
			return true;
		
		return false;
	}
	
}
