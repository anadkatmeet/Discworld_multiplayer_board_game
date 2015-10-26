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
 *Junit test class for money.
 *Every player has 10 $ in the starting of game.
 *Every player has 5 coins of 1$ and 1 coin of 5$.
 *
 *<br/>
 *<br/>
 *Checking whether total money a player has is 10 or what.
 *</p>
 */

public class PlayerMoneyTest {

	@Test
	public void test() {
		new Helper();
		Player p=new Player(new MapBoard(),"red");
		assertEquals(10, (p.getPlayermoney()));
		System.gc();
	}

}
