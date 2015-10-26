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
 *Junit test class to remove a minion from city area.
 *If there is more than one minion in a city area, it must have trouble marker.
 *Trouble maker can be removed if one of all minions is removed.
 *Here, two minions are added and that's why there would be one trouble maker in area.
 *If one minion is removed, there should be no trouble maker in area.
 *<br/>
 *<br/>
 *Checking whether any trouble marker in a city area or not if we remove a minion.
 *</p>
 */

public class RemoveMinion {

	@Test
	public void test() {
		MapBoard board=new MapBoard();
		
		Player p=new Player(board,"red");
		Helper.playerList.add(p);
		board.cityAreaObejctList.get(11).addMinion(p.getColor());
		board.cityAreaObejctList.get(11).addMinion(p.getColor());
		board.cityAreaObejctList.get(11).removeMinion(p.getColor());
		assertFalse(board.cityAreaObejctList.get(11).troublemarkers);
	}

}
