package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import source.MapBoard;
import source.Player;

/**
 * 
 * @author c_sarvai
 *
 *<p>
 *Junit test class for number of minions.
 *Every player has 12 minions.
 *
 *<br/>
 *<br/>
 *Checking whether total number of minions of a player is 12 or what.
 *</p>
 */

public class PlayerMinionTest {

	@Test
	public void test() {
		Player p=new Player(new MapBoard(),"red");
		assertEquals(12, p.getTotalminions());
	}

}
