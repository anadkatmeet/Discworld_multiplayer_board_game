package JUnit;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import source.Helper;
import source.MapBoard;
import source.Player;
import source.Start;

/**
 * 
 * @author c_sarvai
 *
 *<p>
 *Junit test class to check winning conditions for <b>Commander Vimes</b> personality card.
 *</br></br>
 *<b>
 *Condition:
 *
 *If the game ends due to the cards running out then you win the game.
 *</b>
 *</br></br>
 *
 *<br/>
 *Checking whether winning condition of that player is true or what.
 *</p>
 */

public class WCforCommanderVimes {

	@Test
	public void test() {
		MapBoard board=new MapBoard();
		Player p=new Player(board,"red");
		Player p1=new Player(board,"green");
		Helper.playerList.add(p);
		for (int i = 0; i < Helper.personalitySet.size(); i++) {
			if (Helper.personalitySet.get(i).cardName.equals("Commander Vimes")) {
				p.setPersonalityCard(Helper.personalitySet.get(i));
				break;
			}
		}
		Helper.playerList.add(p1);
		int size=Helper.playerCardSet.size();
		for (int i = 0; i < size; i++) {
			Helper.playerCardSet.remove(0);
		}
		
		int totalplayers=Helper.playerList.size();
		assertTrue(p.getPersonalityCard().checkWinningConditions(4, p, board));
	}

}
