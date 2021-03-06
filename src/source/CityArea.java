package source;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;





import PlayerCards.PlayerCardActions;
/**
 * <p><b>CityArea implements Serializable</b><br>
 * This class has different methods to perform different function like adding & removing minion, adding & removing building.
 * 
 * @author Dell
 * @param cityAreaInfo -Information of city area
 * @see CityArea(int number,String name,ArrayList<String> info,int cost)
 * @see addMinion(String color) 
 * @see removeMinion(String color) 
 * @see addBuilding(String color
 * @see removeBuilding(String color)
 * @see addDemons()
 * @see removeDemons()
 * @see addTrolls()
 * @see removeTrolls()
 * @see addTroubleMarkers()
 * @see removeTroubleMarkers()
 */

public abstract class CityArea implements Serializable{
	public String name;
	public ArrayList<Integer> adjcentAreas;
	public int demons=0,trolls=0;
	public boolean troublemarkers=false;
	public int cityAreaNumber;
	public int cost;
	public MapBoard board;
	private String action;
	private String building="none";
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	public HashMap<String,Integer> minions;
	
	
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * <p>This method takes four argument and set the values of City Area.</p>
	 * @param number -City area number
	 * @param name - City area name
	 * @param info - City area information
	 * @param cost -  City area cost
	 */
	abstract public void executeCityAreaMethods(MapBoard board,Player p);
	
	public CityArea(int number,String name,int cost,ArrayList<Integer> adjcent,MapBoard board,String action) {
		this.cityAreaNumber=number;
		this.name=name;
		this.cost=cost;
		this.board=board;
		this.action=action;
		adjcentAreas=adjcent;
		minions=new HashMap<String, Integer>();
		minions.put("red", 0);
		minions.put("yellow", 0);
		minions.put("green", 0);
		minions.put("blue", 0);
		
	}
	
	/**
	 * <p>Adds the minion to the city area.</p>
	 * @param color - Color of minion
	 */
	public void addMinion(String color){
		if(!this.troublemarkers)
		{
			for (int i = 0; i < Helper.color.size(); i++) {
				if(this.minions.get(Helper.color.get(i))>0)
				{
					this.troublemarkers=true;
					Helper.troublemakers--;
					break;
				}
			}
			
			
		}
		minions.replace(color, minions.get(color), minions.get(color)+1);
		//remove this color minion to corresponding player
		int temp=Helper.getPlayerByColor(color).getTotalminions();
		Helper.getPlayerByColor(color).setTotalminions(temp-1);
		
	}
	/**
	 * <p>Removes the minion from the city area.</p>
	 * @param color - Color of minion
	 */
	public void removeMinion(String color){
		minions.replace(color, minions.get(color), minions.get(color)-1);
		//add this color minion to corresponding player
		Helper.getPlayerByColor(color).setTotalminions(Helper.getPlayerByColor(color).getTotalminions() + 1);
		removeTroubleMarkers();
	}
	
	/**
	 * <p>Adds the building to the city area.</p>
	 * @param color - Color of building
	 */
	public void addBuilding(String color){
		if (troublemarkers) {
			System.out.println("Cannot add a building because of TM in this area");
			return;
		}
		if (minions.get(color)>0 && Helper.payToBank(this.cost, Helper.getPlayerByColor(color))) {
			//buildings.replace(color, buildings.get(color), buildings.get(color)+1);
			setBuilding(color);
			//Helper.getPlayerByColor(color).totalbuildings--;
			Helper.getPlayerByColor(color).setTotalbuildings(Helper.getPlayerByColor(color).getTotalbuildings() - 1);
//			Helper.getPlayerByColor(color).cityAreasConquered.add(this);
			if(!(this.demons>0))
			{
				Helper.getPlayerByColor(color).getCityAreasConquered().add(this);
				//board.cityAreaObejctList.remove(this);
				board.bankCityAreas.remove(this);
			}
			else{
				System.out.println("There is a demon in this area, so you cannot get city area card");
			}
			
	
		}
		else{
			System.out.println("Cant place a building because either you dont have any minion in this area or not enough money");
			return;
		}
			
		
	}
	/**
	 * <p>removes the building from the city area.</p>
	 * @param color - Color of building
	 */
	public void removeBuilding(String color){
		//buildings.replace(color, buildings.get(color), buildings.get(color)-1);
		setBuilding("none");
		//Helper.getPlayerByColor(color).totalbuildings++;
		Helper.getPlayerByColor(color).setTotalbuildings(Helper.getPlayerByColor(color).getTotalbuildings() + 1);
//		if (Helper.getPlayerByColor(color).cityAreasConquered.contains(this)) {	//this means player is holding the card (bloodystupidjohnson condition)
//			Helper.getPlayerByColor(color).cityAreasConquered.remove(this);
//			Helper.bankCityAreas.add(this);
//		}
		if (Helper.getPlayerByColor(color).getCityAreasConquered().contains(this)) {	//this means player is holding the card (bloodystupidjohnson condition)
			Helper.getPlayerByColor(color).getCityAreasConquered().remove(this);
			board.bankCityAreas.add(this);
		}
		//board.cityAreaObejctList.add(this);
		
		System.out.println("Building removed");
		
	}
	
	/**
	 * <p>Adds the Demons to the city area.</p>
	 * 
	 */
	public void addDemons(){
		demons++;
		Helper.demons--;
		addTroubleMarkers();
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if(Helper.playerList.get(i).getCityAreasConquered().contains(this))
			{
				board.bankCityAreas.add(this);
				Helper.playerList.get(i).getCityAreasConquered().remove(this);
			}
		}
		System.out.println("One demon added from the map");
	}
	/**
	 * <p>removes the Demons to the city area.</p>
	 * 
	 */
	public void removeDemons(){
		if (demons==0) {
			System.out.println("No demons found");
			return;
		}
		demons--;
		Helper.demons++;
		System.out.println("demon removed from the map");
		removeTroubleMarkers();
	}
	
	/**
	 * <p>Adds the trolls to the city area.</p>
	 * 
	 */
	public void addTrolls(){
		if(!this.troublemarkers)
		{
			for (int i = 0; i < Helper.color.size(); i++) {
				if(this.minions.get(Helper.color.get(i))>0)
				{
					this.troublemarkers=true;
					Helper.troublemakers--;
					break;
				}
			}
			
			
		}
		trolls++;
		Helper.trolls--;
		System.out.println("troll added");
	}
	/**
	 * <p>removes the trolls to the city area.</p>
	 * 
	 */
	public void removeTrolls(){
		if (trolls==0) {
			System.out.println("No troll found");
			return;
		}
		trolls--;
		Helper.trolls++;

		System.out.println("troll removed from the map");
		removeTroubleMarkers();
	}
	
	/**
	 * <p>Adds the Troublemakers to the city area.</p>
	 *
	 */
	public void addTroubleMarkers(){
		if (troublemarkers) {
			//System.out.println("There is already a trouble marker in "+name+" area");
		}
		else{
			troublemarkers=true;
			Helper.troublemakers--;
			//System.out.println("Trouble marker added in "+name+" area");
		}
		
	}
	/**
	 * <p>removes the Troublemakers to the city area.</p>
	 * 
	 */
	public void removeTroubleMarkers(){
		if (!troublemarkers) {
			//System.out.println("No trouble marker exists in "+name+" area");
		}
		else{
			troublemarkers=false;
			Helper.troublemakers++;
			//System.out.println("Trouble marker removed from "+name+" area");
		}
	}
		
}

class DollySisters extends CityArea{

	public DollySisters(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);

	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		//pay $3 and place minion in DollySisters or adjacent area
		
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		
		if(p.getTotalminions()>0){
			if(Helper.payToBank(3, p)){
				Helper.placeMinionInParticularAreaOrAdjacent(board, p, this);
			}else{
				System.out.println("Not enough funds");
			}
			return;
		}
		else
		{
			System.out.println("Not enough minions to place on board");
			return;
		}
	}
}
class UnrealEstate extends CityArea{

	public UnrealEstate(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		//get one card from deck
		p.playerCards.add(Helper.getRandomPlayerCard());
		
		Scanner input=new Scanner(System.in);
		
		//now discard one player card from your hand
		System.out.println("Select one card to discard");
		for (int i = 0; i < p.playerCards.size(); i++) {
			if (!(p.playerCards.get(i).used)) {
				System.out.println(i+"-for the card "+p.playerCards.get(i).playerCardName);
			}
		}
		do
		{
			int value=input.nextInt();
			if(p.playerCards.contains(Helper.playerCardSet.get(value)))
			{
				p.playerCards.get(value).used=true;
				System.out.println("Selected player card discarded");
				break;
			}
			else
			{
				System.out.println("Wrong Choice.");
				continue;
			}
		}while(true);
		
	}
	
}
class DragonsLanding extends CityArea{

	public DragonsLanding(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		if(Helper.takeFromBank(2, p)){
			System.out.println("You got $2 from the bank");
		}
	}
	
}
class SmallGods extends CityArea{

	public SmallGods(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		Scanner input=new Scanner(System.in);
		
		System.out.println("Message for "+p.getColor()+" player: One of your pieces affected by random event.\n\nDo you wanna pay $3 and ignore the effect?\n1. Yes\n\n2. No");
		do{
			int value=input.nextInt();
			if (!(value==1||value==2)) {
				System.out.println("Wrong choice,enter again");
				continue;
			}
			if (value==1) {
				if (Helper.payToBank(3, p)) {
					return;
				}
				else
					System.out.println("Not enough funds");
				return;
			}
		}while(true);
	}
	
}
class TheScours extends CityArea{

	public TheScours(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		//now discard one player card from your hand
		Scanner input=new Scanner(System.in);
		System.out.println("Select one card to discard");
		for (int i = 0; i < p.playerCards.size(); i++) {
			if (!(p.playerCards.get(i).used)) {
				System.out.println(i+"-for the card "+p.playerCards.get(i).playerCardName);
			}
		}
		int value=input.nextInt();
		p.playerCards.get(value).used=true;
		System.out.println("Selected player card discarded");
	
		if(Helper.takeFromBank(2, p)){
			System.out.println("You got $2 from the bank");
		}
		
	}
	
}
class TheHippo extends CityArea{

	public TheHippo(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		if(Helper.takeFromBank(2, p)){
			System.out.println("You got $2 from the bank");
		}
		
	}
	
}
class TheShades extends CityArea{

	public TheShades(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		//can place TM in shades or adjacent areas
		Scanner input=new Scanner(System.in);
		int size=(board.getCityAreaByNumber(7).adjcentAreas.size()); //size=adjacent of shades
		ArrayList<Integer> templist=new ArrayList<Integer>();	//templist to store cityareanumbers of shades and its adjacents
		templist.add(7);
		for (int i = 0; i < size; i++) {
			templist.add(board.getCityAreaByNumber(7).adjcentAreas.get(i));
		}
		int local=0;
		for (int i = 0; i < templist.size(); i++) {
			if (!(board.getCityAreaByNumber(templist.get(i)).troublemarkers)) {
				if (i==0){ 
					System.out.println("Select area to place TM");
				}
				System.out.println(i+"-for area "+board.getCityAreaByNumber(templist.get(i)).name);
				local++;
			}
		}
		if (local>0) {
			int value=input.nextInt();
			board.getCityAreaByNumber(value).addTroubleMarkers();
		}		
	}
	
}
class Dimwell extends CityArea{

	public Dimwell(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		//pay $3 and place minion in Dimwell or adjacent area
		//Scanner input=new Scanner(System.in);
		if(p.getTotalminions()>0){
			if(Helper.payToBank(3, p)){
				Helper.placeMinionInParticularAreaOrAdjacent(board, p, this);
				
			}else{
				System.out.println("Not enough funds");				
			}
			
		}
		else{
				System.out.println("Not enough minions to place on board");
				
			}
		}
	
}
class Longwall extends CityArea{

	public Longwall(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		if(Helper.takeFromBank(1, p)){
			System.out.println("You got $1 from the bank");
		}
		
	}
	
}
class IsleOfGods extends CityArea{

	public IsleOfGods(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		Scanner input=new Scanner(System.in);
		do {
			System.out.println("You can pay $2 and remove one TM. Want to do that?\n1-Yes\n2-No");
			int j=input.nextInt();
			 if (!(j==1||j==2)) {
				System.out.println("Wrong choice");
				continue;
			}
			if (j==1) {
				if(Helper.takeFromBank(2, p)){
					System.out.println("You got $2 from the bank");
					
					//now remove TM
					System.out.println("Select area to remove TM");
					for (int i = 0; i < board.cityAreaObejctList.size(); i++) {
						if (board.cityAreaObejctList.get(i).troublemarkers) {
							System.out.println(i+"-for area "+board.cityAreaObejctList.get(i).name);
						}
					}
					
					int value=input.nextInt();
					board.getCityAreaByNumber(value).removeTroubleMarkers();
					
				}
				else{
					System.out.println("Not enough funds");
					return;
				}
			}
			else if(j==2){
				return;
			}
			
		} while (true);
		
		
	}
	
}
class SevenSleepers extends CityArea{

	public SevenSleepers(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		if(Helper.takeFromBank(3, p)){
			System.out.println("You got $3 from the bank");
		}
		
	}
	
}
class NapHill extends CityArea{

	public NapHill(int number, String name, int cost,
			ArrayList<Integer> adjcent, MapBoard board,String action) {
		super(number, name, cost, adjcent, board,action);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void executeCityAreaMethods(MapBoard board,Player p) {
		if (demons>1) {
			System.out.println("This city area contains demons. so you can't perform city area actions.");
			return;
		}
		if(Helper.takeFromBank(1, p)){
			System.out.println("You got $1 from the bank");
		}
		
	}
	
}



