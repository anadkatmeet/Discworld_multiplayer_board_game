package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Helper;
import source.MapBoard;
import source.Player;

public class PayToBankFailureTest {

	@Test
	public void test() throws InterruptedException {
		//Thread.sleep(20);
		
		MapBoard board=new MapBoard();
		Player p=new Player(board,"red");
		
		Helper.playerList.add(p);
		board.placeInitialPieces(p);
		Helper.payToBank(5, p);
		Helper.payToBank(5, p);
		boolean result=Helper.payToBank(1, p);
		
		assertFalse(result);
	}

}
