
package PersonalityCards;
import java.io.Serializable;

import source.*;
/**
 * 
 * @author p_pandy
 * <p>This is base class for all personality cards. It has initial winning condition. Any class which extends PersonalityCardParent can 
 *  override checkWinningConditions method and change the condition.</p>
 *  @param cardName - Name of the personality card
 * @see  checkWinningConditions(int totalPlayers, Player p,MapBoard board)
 *
 */

public class PersonalityCardParent implements Serializable {
	public String cardName, winningCondition;
	/**
	 * <p>Method has 3 parameter and it checks the winning condition of the personality card. On satisfying condition it return the true, because
	 * method has boolean return type.</p>
	 * @param totalPlayers - Total number of players
	 * @param p - object of Player class
	 * @param board - Object of MapBoard class
	 * @return - it can be true or false depending on the status of the player
	 */
	public boolean checkWinningConditions(int totalPlayers, Player p,MapBoard board){
//		if ((totalPlayers==2 && p.cityAreasConquered.size()>=7)||(totalPlayers==3 && p.cityAreasConquered.size()>=5)||(totalPlayers==4 && p.cityAreasConquered.size()>=4))
		if ((totalPlayers==2 && p.getCityAreasConquered().size()>=7)||(totalPlayers==3 && p.getCityAreasConquered().size()>=5)||(totalPlayers==4 && p.getCityAreasConquered().size()>=4))
			return true;
		
		return false;
	}
	
	
	
}
