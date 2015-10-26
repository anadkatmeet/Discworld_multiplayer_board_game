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
 *Junit test class for Pay to bank method.
 *On initial state of Player, 10$ is given.
 *Pay 5$ from player's account.
 *
 *<br/>
 *<br/>
 *Checking whether remaining money in player's account is 5 or not.
 *</p>
 */
public class PayToBankTest {

	@Test
	public void test() {
		//Player p=new Player(new MapBoard());
		Player p=new Player(new MapBoard(),"red");
		Helper.payToBank(5, p);
		assertEquals(5, (p.getPlayermoney()));
	}

}
