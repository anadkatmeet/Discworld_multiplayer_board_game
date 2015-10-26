package PersonalityCards;

import source.Helper;
import source.MapBoard;
import source.Player;

/**
 * 
 * @author p_pandy
 * 
 * <p>This is class for CommanderVimes.</p>
 * 
 * @see PersonalityCardParent
 * @see CommanderVimes(String name)
 * 
 */

public class CommanderVimes extends PersonalityCardParent {
	/**
	 * <p> Constructor of CommanderVimes set the name of Card, whenever constructor is created Card name is assigned </p> 
	 * @param name - Name of the card, in this case CommanderVimes, whenever constructor is created Card name is assigned 
	 */
	public CommanderVimes(String name, String condition){
		cardName=name;
		winningCondition=condition;
	}
	// game ends due to cards running out of deck
	public boolean checkWinningConditions(int totalPlayers, Player p,MapBoard board){
		if (Helper.playerCardSet.size()==0) {
			return true;
		}
		//already implemeted in player card deck	
		return false;
	}
}
