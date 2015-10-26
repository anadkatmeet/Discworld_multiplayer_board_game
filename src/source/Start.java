package source;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import PersonalityCards.PersonalityCardParent;
import PlayerCards.PlayerCardActions;
import PlayerCards.RandomEvents;

/**
 * 
 * <p>
 * Start class, as name suggest game starts from here.
 * Initializes all players with the predefine condition and allocation of resources like minions,
 * buildings and city area map.
 * </P>
 * @param p1,p2,p3,p4 -Objects of Player class,<br> used to initialize and keep track of players Details.
 * @param board -Object of MapBoard class,<br>
 * @param playerList -keeps track of players playing the game, takes object of "Player class object"
 * @param totalplayers -Integer variable which take value return by showmenu()
 * @param commonstart -
 * @see showmenu()
 * @see initializePlayers(int n)
 * @see showMap(int players)
 * 
 */
public class Start implements Serializable{
	Player p1,p2,p3,p4;
	MapBoard board;
	static Start commonstart;
	int totalplayers;
	static ArrayList<CityArea> temparea;
	
	public static void main(String[] args) {
		showmenu();		
	}
	
	/**
	 * 
	 * @param n -It takes the number of totaler> is list which has list of player objects.
	 * <p>
	 * It creates objects of Player class depending upon the value entered. 
	 * Adds them to the game board, sets their initial values.
	 * </p>
	 * @see showmenu()
	 * @see placeInitialPieces(Player p) players going to play the game as argument.
	 * @param playerList -ArrayList<Type Play
	 * 
	 */
	private void initializePlayers(int n) {
		Helper.playerList=new ArrayList<Player>();
		switch (n) {
		case 2:
			p1=new Player(commonstart.board);
			p2=new Player(commonstart.board);
			p3=null;p4=null;
			p1.setTurn(true);
			Helper.playerList.add(p1);
			Helper.playerList.add(p2);
			
			commonstart.board.placeInitialPieces(p1);
			commonstart.board.placeInitialPieces(p2);
			
			break;
		case 3:
			p1=new Player(commonstart.board);
			p1.setTurn(true);
			p2=new Player(commonstart.board);
			p3=new Player(commonstart.board);
			p4=null;
			Helper.playerList.add(p1);
			Helper.playerList.add(p2);
			Helper.playerList.add(p3);
			commonstart.board.placeInitialPieces(p1);
			commonstart.board.placeInitialPieces(p2);
			commonstart.board.placeInitialPieces(p3);
			
			break;
		case 4:
			p1=new Player(commonstart.board);
			p1.setTurn(true);
			p2=new Player(commonstart.board);
			p3=new Player(commonstart.board);
			p4=new Player(commonstart.board);
			Helper.playerList.add(p1);
			Helper.playerList.add(p2);
			Helper.playerList.add(p3);
			Helper.playerList.add(p4);
			commonstart.board.placeInitialPieces(p1);
			commonstart.board.placeInitialPieces(p2);
			commonstart.board.placeInitialPieces(p3);
			commonstart.board.placeInitialPieces(p4);
			
			
			break;
		default:
			break;
		}
		
		//Helper.initializesavestate(board);
		//saveState();
	}
	/**
	 * <p>
	 * This method shows the initial menu which gives options like "Start the game" & "Load game".
	 * Then it shows further option menu depending on what you first select if you enter "1" then 
	 * it will ask for players and further shows two final option of "Player status" & "Map board".
	 * But at the start if you go for "2" then it will loads the game from where you have saved.
	 * Finally it also ask if you want to save game or not.</p>
	 * @param input -object of Scanner class
	 * @param totalplayers -Number of players who is participating in the game,<br> taken by user input.
	 * @return totalplayers -This variable is further used by initializePlayers(int n)
	 * @see initializePlayers(int n) 
	 */
	private static void showmenu() {
		Scanner input=new Scanner(System.in);
		System.out.println("\n\t\t\t\t---------------------------------------");
		System.out.println("\t\t\t\t| Welcome to DiscWorld Ankh-Morpork!! |");
		System.out.println("\t\t\t\t---------------------------------------\n");
		do{
			System.out.println("---------------------------------------");
			System.out.println("|\t1.Initialize the game         |");
			System.out.println("|\t2.Load game                   |");
			System.out.println("---------------------------------------");
			int choice=input.nextInt();
		if (choice==1) {
			
			commonstart=new Start();
			do{
			System.out.println("--------------------------------------------------------");
			System.out.println("|\tEnter the number of players between 2 to 4     |");
			System.out.println("--------------------------------------------------------");
			commonstart.totalplayers=input.nextInt();
			if(commonstart.totalplayers==2||commonstart.totalplayers==3||commonstart.totalplayers==4){break;}
			else{
				System.out.println("<<<<---Wrong choice--->>>>\n");
				continue;
			}
			}while(true);
			commonstart.board=new MapBoard();
			
			commonstart.initializePlayers(commonstart.totalplayers);
			
			System.out.println("\n<----------------------------------------Game is starting----------------------------------------->\n");
			
			commonstart.GamePlay();
			break;
		}else if(choice==2){
			System.out.println("--------------------------------------------------------");
			System.out.println("|\t     Enter previously saved file name          |");
			System.out.println("--------------------------------------------------------");
			String name=input.next();
			loadState(name);
			
			break;
		}
		else
		{
			System.out.println("<<<<---Wrong choice--->>>>\n");
			continue;
		}
		}while(true);
		
	}
	
	public static void takeTurn(MapBoard board,Player p)
	{
		p.setTurn(!p.isTurn());
		temparea=new ArrayList<CityArea>();
		
		boolean checkWC= CheckPersonalityCardWC(board,p);
		if(checkWC)
		{
			System.out.println(p.getColor()+" Player won the game.");
			System.exit(0);
		}
		else
		{
			Scanner scan=new Scanner(System.in);
			for (int i = 0; i < p.getCityAreasConquered().size(); i++) {
				if(!(p.getCityAreasConquered().get(i).equals(board.getCityAreaByNumber(4))))
				{
					temparea.add(p.getCityAreasConquered().get(i));
				}				
			}
			do
			{
				
				if(temparea.size()>0)
				{
					System.out.println("\t<<--Select From Below-->>");
					System.out.println("---------------------------------------");
					System.out.println("|\t1.Perform City Area           |");
					System.out.println("|\t2.Perform Player Cards        |");
					System.out.println("---------------------------------------");
					int value=scan.nextInt();
					if(value==1)
					{
						CheckCityAreaCard(board,p);
						//continue;
					}else if(value==2)
					{
						PerformPlayerCard(board,p);
						Helper.Nextplayer(p).setTurn(true);
						break;
					}
					else
					{
						System.out.println("<<<<----Wrong Choice.----->>>>\n");
						continue;
					}
				}
				else
				{
					PerformPlayerCard(board,p);
					Helper.Nextplayer(p).setTurn(true);
					break;
				}
			}while(true);
			
		}
		
	}
	
	public void ShowGame()
	{
		System.out.println("\tTable no. 1");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tPLAYER INFO                                |");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("|\tColor  \tMoney   \tMinons \tBuildings   \tPersonality_Card   |");
		System.out.println("----------------------------------------------------------------------------");
		for (int i = 0; i < Helper.playerList.size(); i++) {
			Helper.playerList.get(i).showPlayer();
			System.out.println();
		}
		System.out.println("----------------------------------------------------------------------------");
		commonstart.board.showMap(commonstart.totalplayers);
		System.out.println("\t\t\t\t\t  -----------------------");
		System.out.println("\t\t\t\t\t  |  Bank money  |  "+Helper.bankmoney+"  |");
		System.out.println("\t\t\t\t\t  -----------------------\n");
	}
	
	public static boolean CheckPersonalityCardWC(MapBoard board,Player p)
	{
		
//		return p.personalityCard.checkWinningConditions(Helper.playerList.size(), p, board);
		return p.getPersonalityCard().checkWinningConditions(Helper.playerList.size(), p, board);
	}
	
	public static void CheckCityAreaCard(MapBoard board,Player p)
	{
		System.out.println("\t<<< Running methods from city area cards that player holds >>>");
		while(temparea.size()>0){
			for (int i = 0; i < temparea.size(); i++) {
				System.out.println(i+" for "+temparea.get(i).name+" , action: "+temparea.get(i).getAction());
			}
			System.out.println(temparea.size()+" to return from this operation");
			Scanner input=new Scanner(System.in);
			do
			{
				int j=input.nextInt();
				if(j==temparea.size()){
					return;
				}
				if(j>=0&&j<=temparea.size())//  (cityareas.contains(cityareas.get(j)))
				{
					System.out.println("------------------------------------------------------------------------------------------");
					System.out.println("\tExecuting "+temparea.get(j).name);
					System.out.println("------------------------------------------------------------------------------------------");
					temparea.get(j).executeCityAreaMethods(board, p);
					temparea.remove(temparea.get(j));
					break;
					//return;
				}
				else
				{
					System.out.println("<<<<---Wrong Choice.--->>>>\n");
					continue;
				}
			}while(true);
		
		}
		System.out.println("you don't have any city area cards");
//		ArrayList<CityArea> cityareas=p.cityAreasConquered;
		//ArrayList<CityArea> cityareas=p.getCityAreasConquered();
		/*if (temparea.size()>0) {
			System.out.println("\t<<< Running methods from city area cards that player holds >>>");
			System.out.println("------------------------------------------------------------------\n");
			
			for (int i = 0; i < temparea.size(); i++) {
				System.out.println(i+" for "+temparea.get(i).name+" , action: "+temparea.get(i).getAction());
			}
			System.out.println(temparea.size()+" to skip this operation");
			Scanner input=new Scanner(System.in);
			do
			{
				int j=input.nextInt();
				if(j==temparea.size()){
					return;
				}
				if(j>=0&&j<=temparea.size())//  (cityareas.contains(cityareas.get(j)))
				{
					System.out.println("------------------------------------------------------------------------------------------");
					System.out.println("\tExecuting "+temparea.get(j).name);
					System.out.println("------------------------------------------------------------------------------------------");
					temparea.get(j).executeCityAreaMethods(board, p);
					temparea.remove(temparea.get(j));
					break;
					//return;
				}
				else
				{
					System.out.println("<<<<---Wrong Choice.--->>>>\n");
					continue;
				}
			}while(true);*/
		
		

		
		
	}
	
	public static void PerformPlayerCard(MapBoard board,Player p)
	{
		int unusedcards=0;
		for (int i = 0; i < p.playerCards.size(); i++) {
			if (!(p.playerCards.get(i).used)) {
				unusedcards++;
			}
		}
		while (unusedcards<5) {	//if the player has less than 5 cards in hand then call drawfromdeck method
			p.drawFromDeck(board);
			unusedcards++;
		}
		p.displayUnusedCards(board);
	}
	/**
	 * </p><b>saveState()</b><br> This method saves the current state of the game.
	 * It creates the object of "FileOutputStream" and "ObjectOutputStream" & writes file using "writeObject" method.</p>
	 * @param input -object of scanner class
	 */
	
	public static int saveState(){
		try{
		Scanner input=new Scanner(System.in);
		System.out.println("------------------------------------------------------------");
		System.out.println("|   Name of the file to which you want to save the state   |");
		System.out.println("------------------------------------------------------------");
		String name=input.nextLine();
		FileOutputStream file=new FileOutputStream(name+".ser");
		ObjectOutputStream out=new ObjectOutputStream(file);
		out.writeObject(Start.temparea);
		out.writeObject(commonstart);
		out.writeObject(Helper.personalitySet);
		out.writeObject(Helper.playerCardSet);
		out.writeObject(Helper.playerCardSetDiscarded);
		out.writeObject(Helper.color);
		out.writeObject(Helper.colortemp);
		out.writeObject(Helper.demons);
		out.writeObject(Helper.trolls);
		out.writeObject(Helper.troublemakers);
		out.writeObject(Helper.adjucentToRiver);
		out.writeObject(Helper.bankmoney);
		out.writeObject(Helper.playerList);
		out.writeObject(Helper.randomEventObject);
		out.writeObject(Helper.playerCardFactory);
		
		System.out.println("\n<<<< BINGO state saved!! >>>>\n");
		
		
		file.close();
		out.close();
		return 1;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return 0;
		}
	}
	/**
	 * <p><b>loadState(String e)</b> This method loads the game from where it has been saved. 
	 * It's like resuming to the game from last saved   point.
	 * This method uses object of "FileInputStream" & "ObjectInputStream" to read object file.</p>
	 * @param s -String file name which the name of the file to which game state is saved.
	 */
	public static void loadState(String s){
		try
	      {
	         FileInputStream fileIn = new FileInputStream(s+".ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         Start.temparea=(ArrayList<CityArea>)in.readObject();
	         commonstart = (Start) in.readObject();
	         Helper.personalitySet=(ArrayList<PersonalityCardParent>)in.readObject();
	         Helper.playerCardSet=(ArrayList<PlayerCardActions>)in.readObject();
	         Helper.playerCardSetDiscarded=(ArrayList<PlayerCardActions>)in.readObject();
	         Helper.color=(ArrayList<String>)in.readObject();
	         Helper.colortemp=(ArrayList<String>)in.readObject();	         
	         Helper.demons=(int)in.readObject();
	         Helper.trolls=(int)in.readObject();
	         Helper.troublemakers=(int)in.readObject();
	         Helper.adjucentToRiver=(ArrayList<CityArea>)in.readObject();
	         Helper.bankmoney=(int)in.readObject();	         
	         Helper.playerList=(ArrayList<Player>)in.readObject();
	         Helper.randomEventObject=(RandomEvents)in.readObject();
	         Helper.playerCardFactory=(PlayerCardsFactory)in.readObject();
	         
	        
	         
	         in.close();
	        //Initiate(commonstart);
	         fileIn.close();
	         /*for (int i = 0; i < Helper.playerList.size(); i++) {
	        	 Helper.playerList.get(i).showPlayer();
					System.out.println();
			}*/
	         System.out.println("\n\t<<<<<<<<Game loaded successfully>>>>>>>>\n");
	         commonstart.GamePlay();
	         //commonstart.board.showMap(commonstart.totalplayers);
	      }catch(Exception i)
	      {
	         i.printStackTrace();
	         return;
	      }
	}
	
	/*public void GamePlay()
	{		
		do{
			System.out.println("1. Want to save the state??\n1.Yes\n2.No");
			
			
			Scanner input=new Scanner(System.in);
			System.out.println();
			Player currentplayer=Helper.whichPlayersTurn();
			
			
			
			int temp=input.nextInt();
		if (temp==1) {
			saveState();
			break;
		}else if(temp==2){
			
			commonstart.ShowGame();
			
			System.out.println("\t\tCurrent Turn : "+currentplayer.getColor()+" player"+"\tPersonality Card: "+currentplayer.personalityCard.cardName+ "\n");
			System.out.println("------------------------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\tWinning Condition:\n" );
			System.out.println(currentplayer.personalityCard.winningCondition);
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			takeTurn(commonstart.board, currentplayer);
			commonstart.ShowGame();
		}
		else
			{
				System.out.println("Wrong choice");
				continue;
			}	
		}while(true);
	}*/
	
	public void GamePlay()
	{	
		StartGamePlay();
		CallSaveState();
	}
	
	public void StartGamePlay()
	{
		Player currentplayer=Helper.whichPlayersTurn();
		commonstart.ShowGame();
		
		System.out.println("\t\tCurrent Turn : "+currentplayer.getColor()+" player"+"\tPersonality Card: "+currentplayer.personalityCard.cardName+ "\n");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\tWinning Condition:\n" );
		System.out.println(currentplayer.personalityCard.winningCondition);
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		takeTurn(commonstart.board, currentplayer);
		commonstart.ShowGame();
	}
	
	public void CallSaveState()
	{
		do{
			System.out.println("------------------------------------------------");
			System.out.println("|     <<<<  Want to save the state??  >>>>     |");
			System.out.println("------------------------------------------------");
			System.out.println("|           1. YES                             |");
			System.out.println("|           2. No                              |");
			System.out.println("------------------------------------------------");
						
			Scanner input=new Scanner(System.in);
			System.out.println();
							
			int temp=input.nextInt();
		if (temp==1) {
			saveState();
			StartGamePlay();
		}else if(temp==2){
			StartGamePlay();			
		}
		else
			{
			System.out.println("<<<<<  Wrong choice  >>>>>\n");
				continue;
			}	
		}while(true);
	}
	
}
