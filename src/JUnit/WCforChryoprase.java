package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Helper;
import source.MapBoard;
import source.Player;


/**
 * 
 * @author c_sarvai
 *
 *<p>
 *Junit test class to check winning conditions for <b>Chrysoprase</b> personality card.
 *</br></br>
 *<b>
 *Condition:
 *
 *If at a start of your turn you have a combined worth of 50$ or more (money in hand plus buildings you built),
 * then you win the game. Each loan you have counts as 12$ against your total.
 *</b>
 *</br></br>
 *
 *<br/>
 *Checking whether winning condition of that player is true or what.
 *</p>
 */

public class WCforChryoprase {

	@Test
	public void test() {
		MapBoard board=new MapBoard();
		Player p=new Player(board);
		Player p1=new Player(board);
		Helper.playerList.add(p);
		Helper.playerList.add(p1);
		
		for (int i = 0; i < Helper.personalitySet.size(); i++) {
			if (Helper.personalitySet.get(i).cardName.equals("Chrysoprase")) {
				p.setPersonalityCard(Helper.personalitySet.get(i));
				break;
			}
		}
		int totalplayers=Helper.playerList.size();
		Helper.takeFromBank(55, p);
		boolean result=p.getPersonalityCard().checkWinningConditions(totalplayers, p, board);
		assertFalse(result);
		
	}

}
