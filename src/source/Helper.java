package source;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import PersonalityCards.*;
import PlayerCards.*;
/**
 * <p><b>Helper class implements Serializable</b>
 * This class contains all the static variable which are commonly shared among different classes and methods.
 * @param personalitySet static - Set of 7 personality
 * @param randomEventsCardSet static - 12 random events
 * @param cityAreaCardSet static - Different city area cards
 * @param greenCardSet static -Set of Green cards
 * @param brownCardSet static -Set of Brown cards
 * @param demons static int - Demons 
 * @param troll static int -Trolls
 * @param troublemakers static int -Troublemakers
 * @param bankmoney1 static int - $1 coins 
 * @param bankmoney5 static int - $5 coins
 * @author Dell
 *
 */

public class Helper implements Serializable{
	public static ArrayList<PersonalityCardParent> personalitySet;
	public static ArrayList<PlayerCardActions> playerCardSet;
	public static ArrayList<PlayerCardActions> playerCardSetDiscarded;
	public static ArrayList<String> color;
	public static ArrayList<String> colortemp;
	//static HashMap<String,ArrayList> randomEventCardSet;
	//static HashMap<String,ArrayList> greenCardSet;
	//static HashMap<String,ArrayList> brownCardSet;
	static int demons,trolls,troublemakers;
	public static ArrayList<CityArea> adjucentToRiver=new ArrayList<>();
	public static int bankmoney;
	
	//public static int bankmoney5;
	public static ArrayList<Player> playerList;
	//public static ArrayList<CityArea> bankCityAreas;
	//public static ArrayList<RandomEvents> randomeventsset1;
	public static RandomEvents randomEventObject;
	public static PlayerCardsFactory playerCardFactory=new PlayerCardsFactory();
	
	
	/**
	 * <p> Gets $1 from the bank.</p>
	 * @return 1$ in bankmoney1
	 */
	public static int getBankmoney() {
		return bankmoney;
	}

	/**
	 * <p>Sets $1 to the bank.</p>
	 * @param bankmoney1 - integer variable to set bank money
	 */
	public static void setBankmoney(int bankmoney) {
		Helper.bankmoney = bankmoney;
	}

	

	


	static{
		playerList=new ArrayList<Player>();
		
		personalitySet=new ArrayList<PersonalityCardParent>();
		personalitySet.add(new LorddeWorde("Lord de Worde", "If at the start of your turn you have clear control over certain number of areas then you win the game immediately.\n\t\t\t With 2 players, 7 area control\n\t\t\tWith 3 players, 5 area control\n\t\t\tWith 4 players, 4 area control\n"));
		personalitySet.add(new CommanderVimes("Commander Vimes","If the game ends due to the cards running out then you win the game."));
		personalitySet.add(new LordSelachii("Lord Selachii","If at the start of your turn you have clear control over certain number of areas then you win the game immediately.\n\t\t\t With 2 players, 7 area control\n\t\t\tWith 3 players, 5 area control\n\t\t\tWith 4 players, 4 area control\n"));
		personalitySet.add(new LordRust("Lord Rust","If at the start of your turn you have clear control over certain number of areas then you win the game immediately.\n\t\t\t With 2 players, 7 area control\n\t\t\tWith 3 players, 5 area control\n\t\t\tWith 4 players, 4 area control\n"));
		personalitySet.add(new LordVetinari("Lord Vetinari","If at the start of your turn you have minion in a certain number of areas then you win the game immediately.\n\t\t\t With 2 players, minion in 11 areas\n\t\t\tWith 3 players, minion in 10 areas\n\t\t\tWith 4 players, minion in 9 areas\n"));
		personalitySet.add(new Chrysoprase("Chrysoprase","If at start of your turn you have combine worth of $50 or more\n\t\t\t(money in hand + buildings you have build)\n\t\t\t then you win  the game.\n\t\t\t Each loan you have counts $12 against your total."));
		personalitySet.add(new DragonKingofArms("Dragon King of Arms","If at the start of your turn there are eight or more trouble makers on board then you win the game immediately."));
		
		//colors initialization
		color=new ArrayList<String>();
		color.add("red");
		color.add("yellow");
		color.add("green");
		color.add("blue");
		
		//colortemp initialization
		colortemp=new ArrayList<String>();
		colortemp.add("red");
		colortemp.add("yellow");
		colortemp.add("green");
		colortemp.add("blue");
		
		/*randomevent card initialize*/
		randomEventObject=new RandomEvents();
		
		
		/*initialize other variable*/
		demons=4;trolls=3;troublemakers=12;
		bankmoney=120;
		
		/*initialize 48 green player card set*/
		initializeGreenCardObjects();
		
	}
	
	public static void initializesavestate(MapBoard board)
	{
		Player p1=Helper.getPlayerByColor("red");
		p1.setPlayermoney(25);
		Player p2=Helper.getPlayerByColor("yellow");
		p2.setPlayermoney(50);
		Player p3=Helper.getPlayerByColor("green");
		p3.setPlayermoney(25);
		Player p4=Helper.getPlayerByColor("blue");
		p4.setPlayermoney(25);
		
		
		CityArea dollysister=board.getCityAreaByNumber(1);
		dollysister.addMinion("red");
		dollysister.addMinion("yellow");
		dollysister.addMinion("green");
		dollysister.addMinion("blue");
		
		CityArea unrealestate=board.getCityAreaByNumber(2);
		unrealestate.addMinion("red");
		
		CityArea dragonslanding=board.getCityAreaByNumber(3);
		dragonslanding.addMinion("red");
		dragonslanding.addMinion("red");
		
		CityArea thescours=board.getCityAreaByNumber(5);
		thescours.addMinion("yellow");
		thescours.addBuilding("yellow");
		thescours.addMinion("blue");
		thescours.addMinion("blue");
		thescours.addMinion("blue");
		thescours.addDemons();
		
		CityArea thehippo=board.getCityAreaByNumber(6);
		thehippo.addMinion("blue");
		thehippo.addBuilding("blue");
		thehippo.addTrolls();
		thehippo.removeTroubleMarkers();
		
		CityArea theshades=board.getCityAreaByNumber(7);
		theshades.addMinion("yellow");
		theshades.addBuilding("yellow");
		theshades.addMinion("blue");
		
		CityArea dimwell=board.getCityAreaByNumber(8);
		dimwell.addMinion("red");
		dimwell.addBuilding("red");
		dimwell.addMinion("green");
		dimwell.removeTroubleMarkers();
		
		CityArea longwall=board.getCityAreaByNumber(9);
		longwall.addMinion("green");
		longwall.addMinion("blue");
		longwall.addMinion("blue");
		
		CityArea isleofgod=board.getCityAreaByNumber(10);
		isleofgod.addMinion("red");
		
		CityArea sevensleepers=board.getCityAreaByNumber(11);
		sevensleepers.addMinion("yellow");
		sevensleepers.addBuilding("yellow");
		sevensleepers.addMinion("red");
		sevensleepers.addMinion("green");
		
		CityArea naphill=board.getCityAreaByNumber(12);
		naphill.addMinion("red");
		naphill.addMinion("blue");
		naphill.addTrolls();
		naphill.removeTroubleMarkers();
		
		p1.setPlayermoney(15);
		p2.setPlayermoney(22);
		p3.setPlayermoney(17);
		p4.setPlayermoney(18);
		
		Helper.setBankmoney(48);
		
	}
	
	/**
	 * <p> This method used to initialize all the GreenCardObjects.
	 * All the cards are initialize here ijn this method and method is of private static</p>
	 */
	private static void initializeGreenCardObjects() {
		playerCardSet=new ArrayList<PlayerCardActions>();
		playerCardSetDiscarded=new ArrayList<PlayerCardActions>();
		
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Mr Boggis"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Gaspode"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("FreshStartClub"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Duckman"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Mr Bent"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Begger's Guild"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Bank Of Ankh Morpork"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Ankh Morpork Sunshine Dragon Sancturay"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Sergeant Angua"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Agony Aunts"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Dysk"));
		
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Drumknott"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("CMOT Dibbler"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Dr Cruces"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Captain Carrot"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Mrs Cake"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Groat"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Gimlet's Dwarf Delicatessen"));
		
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Foul Ole Ron"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Fool's Guild"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Fire Brigde"));
		
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Inigo Skimmer"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("History Monks"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Hex"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Here'n'Now"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Harry King"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Harga's House Of Ribs"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Mr Gryle"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Peeled Nuts"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Opera House"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Nobby Nobbs"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Modo"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Mended Drum"));
		//playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Librarian"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Leonard Of Quirm"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Shonky Shop"));
		
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Sacharissa Cripslock"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Rosie Palm"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Rincewind"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Royal Mint"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Queen Molly"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Pink Pussy Cat Club"));

		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Zorgo the Retro-phernologist"));
		//playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Dr Whiteface"));
		//playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Wallace Sonky"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Seamstresses' Guild"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("Mr Pin & Mr Tulip"));
		playerCardSet.add(playerCardFactory.getPlayerCardFromFactory("The Thieves' Guild"));
		
		
		/*
		playerCardSet.add(new MrBoggis("Mr Boggis"));
		playerCardSet.add(new Gaspode("Gaspode"));
		playerCardSet.add(new FreshStartClub("FreshStartClub"));
		playerCardSet.add(new TheDuckMan("The Duckman"));
		playerCardSet.add(new MrBent("Mr Bent"));
		playerCardSet.add(new TheBeggersGuild("The Begger's Guild"));
		playerCardSet.add(new TheBankOfAnkhMorpork("The Bank Of Ankh Morpork"));
		playerCardSet.add(new TheAnkhMorporkSunshineDragonSanctury("The Ankh Morpork Sunshine Dragon Sancturay"));
		playerCardSet.add(new SergeantAngua("Sergeant Angua"));
		playerCardSet.add(new TheAgonyAunts("The Agony Aunts"));
		playerCardSet.add(new TheDysk("The Dysk"));
		
		playerCardSet.add(new Drumknott("Drumknott"));
		playerCardSet.add(new CMOTDibbler("CMOT Dibbler"));
		playerCardSet.add(new DrCruces("Dr Cruces"));
		playerCardSet.add(new CaptainCarrot("Captain Carrot"));
		playerCardSet.add(new MrsCake("Mrs Cake"));
		playerCardSet.add(new Groat("Groat"));
		playerCardSet.add(new GimletsDwarfDelicatessen("Gimlet's Dwarf Delicatessen"));
		
		
		playerCardSet.add(new FoulOleRon("Foul Ole Ron"));
		playerCardSet.add(new TheFoolsGuild("The Fool's Guild"));
		playerCardSet.add(new TheFireBrigade("The Fire Brigde"));
		
		playerCardSet.add(new InigoSkimmer("Inigo Skimmer"));
		playerCardSet.add(new HistoryMonks("History Monks"));
		playerCardSet.add(new Hex("Hex"));
		playerCardSet.add(new HereNnow("Here'n'Now"));
		playerCardSet.add(new HarryKing("Harry King"));
		playerCardSet.add(new HargasHouseOfRibs("Harga's House Of Ribs"));
		playerCardSet.add(new MrGryle("Mr Gryle"));
		playerCardSet.add(new ThePeeledNuts("The Peeled Nuts"));
		playerCardSet.add(new TheOperaHouse("The Opera House"));
		playerCardSet.add(new NobbyNobbs("Nobby Nobbs"));
		playerCardSet.add(new Modo("Modo"));
		playerCardSet.add(new TheMendedDrum("The Mended Drum"));
		playerCardSet.add(new Librarian("Librarian"));
		playerCardSet.add(new LeonardOfQuirm("Leonard Of Quirm"));
		playerCardSet.add(new ShonkyShop("Shonky Shop"));
		
		playerCardSet.add(new SacharissaCripslock("Sacharissa Cripslock"));
		playerCardSet.add(new RosiePalm("Rosie Palm"));
		playerCardSet.add(new Rincewind("Rincewind"));
		playerCardSet.add(new TheRoyalMint("The Royal Mint"));
		playerCardSet.add(new QueenMolly("Queen Molly"));
		playerCardSet.add(new PinkPussyCatClub("Pink Pussy Cat Club"));

		playerCardSet.add(new ZorgoTheRetroPhrenologist("Zorgo the Retro-phernologist"));
		playerCardSet.add(new DrWhiteface("Dr Whiteface"));
		//playerCardSet.add(new WallaceSonky("Wallace Sonky"));
		playerCardSet.add(new TheSeamstressesGuild("The Seamstresses' Guild"));
		playerCardSet.add(new MrPinAndmrTulip("Mr Pin & Mr Tulip"));
		playerCardSet.add(new TheThievesGuild("The Thieves' Guild"));
		*/
		
		
		
	}
	/**
	 * <p> Helps to get the player by color. It returns the object of player. </p>
	 * @param color - Color of the player
	 * @return The object of player class.
	 */
	
	public static Player getPlayerByColor(String color){
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if ((Helper.playerList.get(i).getColor()).equals(color)) 
				return Helper.playerList.get(i);
			else
				continue;
		}
		return null;
	}
	
	/**
	 * <p> This method gives you player card randomly upon calling.</p>
	 * @param temp - It has the 
	 * @return it returns the object of PlayerCardActions and it will change the wining condition for commander vimes
	 */
	public static PlayerCardActions getRandomPlayerCard(){
		PlayerCardActions temp=null;
		Random random=new Random();
		try
		{
			if(playerCardSet.size()>0)
			{
				int value=random.nextInt(playerCardSet.size());
				temp=playerCardSet.get(value);
				
			}
			else
			{
				for (int i = 0; i < playerList.size(); i++) {

					String Name= playerList.get(i).getPersonalityCard().cardName;
					if(Name.equals("Commander Vimes"))
					{
						System.out.println(playerList.get(i)+" wins the game. because we don't have any cards in deck.");
						System.exit(0);
					}
				}
			}
			playerCardSet.remove(temp);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return temp;	
	}
	/**
	 * @param amount - How much money Player can take from bank
	 * @param p - Player Object
	 * 
	 * <p>
	 * This method transfer some amount of money from bank to player's account.
	 * Method transfers based on 5$ and 1$ coins.
	 * Returns null response if there is no enough money in bank.
	 * </p>
	 * 
	 * @see getBankmoney1()
	 * @see setBankmoney5()
	 */
	
	public static boolean takeFromBank(int amount,Player p){
		
		if (Helper.getBankmoney()>=amount) {
			Helper.setBankmoney(Helper.getBankmoney()-amount);
//			p.playermoney=p.playermoney+amount;
			p.setPlayermoney(p.getPlayermoney() + amount);
			
		}else{
			//System.out.println("Not enough money in the bank");
			return false;
		}
		//System.out.println("Got "+amount+" from the bank");
		return true;
	}
	
	/**
	 * 
	 * @param amount - How much money Player can pay to bank
	 * @param p -  Player Object
	 * 
	 * <p>
	 * Method to deduct money from player's account to deposite into bank.
	 * Method transfers based on 5$ and 1$ coins.
	 * </p>
	 * 
	 * @see getBankmoney1()
	 * @see setBankmoney5()
	 */
	/*this method will deduct money from player's account and will deposit to bank's amount*/
	public static boolean payToBank(int amount,Player p){
//		if(p.playermoney>=amount){

		if(p.getPlayermoney()>=amount){
			Helper.setBankmoney(Helper.getBankmoney()+amount);
//			p.playermoney=p.playermoney-amount;
			p.setPlayermoney(p.getPlayermoney() - amount);
		}else{
			//System.out.println("Not enough money in the bank");
			return false;
		}
		//System.out.println("Got "+amount+" from the bank");
		return true;
	}
	/**
	 * 
	 * @param board - Main MapBoard Object
	 * 
	 * <p>
	 * Removes Trouble Markers from particular city area.
	 * Takes input from user to select from which region user wants to remove trouble marker.
	 * </p>
	 * 
	 * @see showTroubleMarkers()
	 * @see getCityAreaByNumber()
	 * @see removeTroubleMarkers()
	 * 
	 */
	
	public static void removeTM(MapBoard board){
		ArrayList<Integer> list=board.showTroubleMarkers();
		
		Scanner input=new Scanner(System.in);
		int j;
		if (list.size()>=1) {
			System.out.println("\n-----------------------------------------------");
			System.out.println("|   Select region to remove Trouble Marker    |");
			System.out.println("-----------------------------------------------");
			do{
			for (int i = 0; i < list.size(); i++) {
				System.out.println("  Select "+i+" for "+ board.getCityAreaByNumber(list.get(i)).name);
			}
			System.out.println("-----------------------------------------------\n");
			j=input.nextInt();
			
			if(!(j>=0&&j<=list.size())){
				System.out.println("Wrong choice");
				continue;
			}else
				break;
			
			}while(true);
			
			(board.getCityAreaByNumber(list.get(j))).removeTroubleMarkers();
			
		}
		
	}

	
	
	/**
	 * 
	 * @param board - Main MapBoard object
	 * @param p - Player Object
	 * 
	 * <p>
	 * Place minion on map in appropriate city area.
	 * Checks certain rules to place it.
	 * </p>
	 * 
	 * @see getCityAreaToAddMinion()
	 * @see addMinion()
	 */
	
	public static void placeMinion(MapBoard board,Player p){
		board.getCityAreaToAddMinion(p).addMinion(p.getColor());
		
	}
	/**
	 * 
	 * @param board - Main MapBoard Object
	 * @param p - Player Object
	 * 
	 * <p>
	 * Places building in a city area.
	 * If city area has any trouble maker, it won't allow to place building.
	 * If there is already a building in city area, it won't either.
	 * </p>
	 * 
	 * @see isThereABuilding()
	 * @see getCityAreaByNumber()
	 * @see addBuilding()
	 * 
	 */
	
	public static void placeABuilding(MapBoard board,Player p){
		int local=0;
		for (int i = 0; i < board.cityAreaObejctList.size(); i++) {
			if (!((board.cityAreaObejctList.get(i).troublemarkers)||(board.isThereABuilding(board.cityAreaObejctList.get(i))))) {
				if (board.cityAreaObejctList.get(i).minions.get(p.getColor())>0) {
					System.out.println(board.cityAreaObejctList.get(i).cityAreaNumber+"-for area "+board.cityAreaObejctList.get(i).name + ",Cost="+ board.cityAreaObejctList.get(i).cost );
					local++;
				}
				
			}
		}
		if (local>0) {
			Scanner input=new Scanner(System.in);
			int i=input.nextInt();
			board.getCityAreaByNumber(i).addBuilding(p.getColor());
		}
		else
		{
			System.out.println("<<<<<<  You cannot add a building at this moment. >>>>>> \n");
		}
		
		
	}
	/**
	 * <p> This method places minion in particular area or in the adjacent area.
	 * Player can pay $3 and place minion in current area or the adjacent area.
	 * </p>
	 * @param board - Object of MapBoard class
	 * @param p - Object of Player class
	 * @param area - Object of city area class
	 */
	public static void placeMinionInParticularAreaOrAdjacent(MapBoard board,Player p,CityArea area){
		Scanner input=new Scanner(System.in);
				if (p.getTotalminions()>0) {
					
						//place minion
						
						ArrayList<Integer> templist=new ArrayList<Integer>();//to store area numbers of given area and its adjacents
						templist.add(area.cityAreaNumber);
						for (int i = 0; i < area.adjcentAreas.size(); i++) {
							templist.add(area.adjcentAreas.get(i));
						}
						//ArrayList<Integer> validationlist=new ArrayList<>();
						System.out.println("\n--------------------------------------------");
						System.out.println("|    Select area number to place minion    |");
						System.out.println("--------------------------------------------");
						for (int i = 0; i < templist.size(); i++) {
							System.out.println(templist.get(i)+"-for area "+board.getCityAreaByNumber(templist.get(i)).name);
						}
						System.out.println("--------------------------------------------\n");
						do{
							int value=input.nextInt();
							if (!(templist.contains(value))) {
								System.out.println("<<<<<  Wrong choice,enter again  >>>>>\n");
								continue;
							}
							board.getCityAreaByNumber(value).addMinion(p.getColor());
							System.out.println("<<<<<  Minion added to the selected area  >>>>>\n");
							break;
							//return;
						}while(true);
				}
				
			
	}
	
	
	/**
	 * 
	 * Works like real dice in game.
	 * @return Random int between 1-12
	 */
	public static int rollDice()
	{
		return ((int)Math.floor(Math.random()*10)% 12) + 1;
	}

	public static PlayerCardActions getPlayerCardByName(String name){
		for (int i = 0; i < Helper.playerCardSet.size(); i++) {
			if (Helper.playerCardSet.get(i).equals(name)) {
				return Helper.playerCardSet.get(i);
			}
		}
		return null;
	}
	
	public static Player whichPlayersTurn(){
		for (int i = 0; i < Helper.playerList.size(); i++) {
			Player temp=Helper.playerList.get(i);
			if (temp.isTurn()) {
				
				return temp;
			}
		}
		return null;
		
	}
	public static Player Nextplayer(Player p){
		for (int i = 0; i < Helper.playerList.size(); i++) {
			Player temp=Helper.playerList.get(i);
			if (p.getColor().equals(temp.getColor())) {
				if(i+1<Helper.playerList.size())
				{
					return Helper.playerList.get(i+1);
				}
				else
				{
					return Helper.playerList.get(0);
				}
			}
		}
		return null;
		
	}
	
	public static void calculatePoints(MapBoard board)
	{
		Player winner = null;
		int maxPoints=0;
		ArrayList<Player> list=new ArrayList<>();
		HashMap<Player, Integer> players=new HashMap<>();
		for (int i = 0; i < playerList.size(); i++) {
			Player p=playerList.get(i);
			int points=0;
			for (int j = 0; j <board.cityAreaObejctList.size(); j++) {
				/*if there are minions for this player and there shouldn't be any demon in this area*/
				if(board.cityAreaObejctList.get(i).minions.get(p.getColor())>0&&(!(board.cityAreaObejctList.get(i).demons>0))){
					points+=board.cityAreaObejctList.get(i).minions.get(p.getColor())*5;
				}
			}
			
			int totalAreaValue=0;
//			for (int j = 0; j < p.cityAreasConquered.size(); j++) {
//				totalAreaValue=totalAreaValue+p.cityAreasConquered.get(j).cost;
//			}
			for (int j = 0; j < board.cityAreaObejctList.size(); j++) {
				if(board.cityAreaObejctList.get(j).getBuilding().equals(p.getColor()) && !(board.cityAreaObejctList.get(j).demons>0))
				{
					totalAreaValue=totalAreaValue+board.cityAreaObejctList.get(j).cost;
				}
			}
			if(p.getPlayermoney()>(p.getLoan()*12))
			{
				p.setPlayermoney((p.getPlayermoney()-(p.getLoan()*12)));
			}
			else
			{
				points=points-(15*p.getLoan());
			}
			points=points+totalAreaValue+p.getPlayermoney();
			if(points>maxPoints)
			{
				list.clear();
				winner=p;
				list.add(winner);
				maxPoints=points;
			}
			else if(points==maxPoints){
				winner=p;
				list.add(winner);
				maxPoints=points;
			}
			players.put(p, totalAreaValue);
		}
		
		if (list.size()==1) {	//if there is just one winner
			System.out.println("<<<<< Winner is "+list.get(0).getColor()+" player!! >>>>>");
			
		}
		else{					//if there is a tie
			int maxtotalAreaplayer=0;
			ArrayList<Player> tlist=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if ((players.get(list.get(i))>maxtotalAreaplayer)) {
					tlist.clear();
					tlist.add(list.get(i));
				}else if((players.get(list.get(i))==maxtotalAreaplayer)){
					tlist.add(list.get(i));
				}
			}
			StringBuilder str=new StringBuilder();
			for (int i = 0; i < tlist.size(); i++) {
				str.append(tlist.get(i).getColor()).append(" player").append(",");
			}
			System.out.println("<<<<<< Winners are "+str.toString().substring(0, str.length()-1));
		}
		System.out.println("\t\t\t\t\t------------------");
		System.out.println("\t\t\t\t\t|   GAME ENDS    |");
		System.out.println("\t\t\t\t\t------------------");
		System.exit(0);
		
	}
	
	private static boolean gaspodeInterrupt(MapBoard board,Player p,Player currentplayer,int flag){	//flag==1 if it is called while moving, 0==called while removing
		Scanner input=new Scanner(System.in);
		if(flag==1){
			System.out.println("Message for "+p.getColor()+": Do you want to stop the current player from moving your minion??\n1-Yes\n2-No");
			do{
			int value=input.nextInt();
				if (value==1) {
					System.out.println(p.getColor()+" color player played Gaspode interrupt card, can't move his minion");
					return true;
				}
				else if(value==2){
					return false;
				}
				else{
					System.out.println("Wrong choice");
					continue;
				}
			}while(true);
		}
		else{	//flag==0
			System.out.println("Message for "+p.getColor()+" player: Do you want to stop the current player from removing your minion??\n1-Yes\n2-No");
			do{
			int value=input.nextInt();
				if (value==1) {
					System.out.println(p.getColor()+" color player played Gaspode interrupt card, can't remove his minion");
					return true;
				}
				else if(value==2){
					return false;
				}
				else{
					System.out.println("Wrong choice");
					continue;
				}
			}while(true);
		}
	}
	
	/*this method is called after a players minion is removed*/
	private static boolean freshStartClubInterrupt(MapBoard board,Player p,Player currentplayer){
		Scanner input=new Scanner(System.in);
		//flag==0
		System.out.println("Message for "+p.getColor()+" player: Do you want to move your removed minion??\n1-Yes\n2-No");
		do{
		int value=input.nextInt();
			if (value==1) {
				return true;
			}
			else if(value==2){
				return false;
			}
			else{
				System.out.println("Wrong choice");
				continue;
			}
		}while(true);
	}
	
	public static boolean checkAndCallGaspodeInterrupt(MapBoard board,Player pl,Player currentplayer,int flag){
		for (int i = 0; i < pl.interruptCollection.size(); i++) {	//check if player has interrupt card or not
			if (pl.interruptCollection.get(i).playerCardName.equals("Gaspode")) {
				System.out.println("Wait "+pl.getColor()+" player has Gaspode Interrupt card...");
				if(Helper.gaspodeInterrupt(board, pl, currentplayer, flag)){	//if player plays that interrupt card
			
					//remove interrupt card from playercardset and interruptcardset
					pl.interruptCollection.remove(i);
					pl.removePlayerCardFromSet("Gaspode");
					return true;
				}
				else	//if player refuses to play interrupt card
					break;
			}
		}
		return false;
	}
	
	public static boolean checkAndCallFreshStartClubInterrupt(MapBoard board,Player pl,Player currentplayer){
		for (int i = 0; i < pl.interruptCollection.size(); i++) {	//check if player has interrupt card or not
			if (pl.interruptCollection.get(i).playerCardName.equals("FreshStartClub")) {
				System.out.println("Wait "+pl.getColor()+" player has Fresh Start Club Interrupt card...");
				if(Helper.freshStartClubInterrupt(board, pl, currentplayer)){	//if player agree to play that interrupt card
					//System.out.println(pl.getColor()+" color player played Fresh Start Club interrupt card, can't move his minion");
					//place his minion 
					placeMinion(board, pl);
					
					
					//remove interrupt card from playercardset and interruptcardset
					pl.interruptCollection.remove(i);
					pl.removePlayerCardFromSet("FreshStartClub");
					return true;
				}
				else	//if player refuses to play interrupt card
					break;
			}
		}
		return false;
	}

	public static PlayerCardActions getTempGreenCard(String name){
		for (int i = 0; i < Helper.playerCardSet.size(); i++) {
			if (Helper.playerCardSet.get(i).playerCardName.equals(name)) {
				return Helper.playerCardSet.get(i);
			}
			
		}
		return null;
	}
	
}

	

	
	
 

