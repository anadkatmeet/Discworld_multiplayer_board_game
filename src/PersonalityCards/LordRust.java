package PersonalityCards;
/**
 * 
 * @author p_pandy
 * 
 * <p>This is class for CommanderVimes.</p>
 * 
 * @see PersonalityCardParent
 * @see LordRust(String name)
 * 
 */

public class LordRust extends PersonalityCardParent {
	/**
	 * <p> Constructor of LordRust set the name of Card, whenever constructor is created Card name is assigned </p> 
	 * @param name - Name of the card, in this case LordRust, whenever constructor is created Card name is assigned 
	 */
	public LordRust(String name, String condition){
		cardName=name;
		winningCondition=condition;
	}
	//same as super class
}