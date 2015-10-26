package JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddBuildingToAssignAreaCardTest.class, AddMinion.class,
		DiscardUsedCardsTest.class, DrawFromDeckTest.class,
		PayToBankFailureTest.class, PayToBankTest.class,
		PlayerMinionTest.class, PlayerMoneyTest.class, 
		RollDieTest.class, TakeFromBank.class, 
		WCforChryoprase.class, WontAddBuildingIfThereIsTM.class,WCforCommanderVimes.class, 
		RemoveMinion.class })
public class AllTests {

}
