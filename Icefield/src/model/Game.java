package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Figures.Eskimo;
import Figures.Figure;
import Figures.PolarExplorer;
import Item.*;


/*
 *Author Beka Babunashvili 
 */
public class Game{
    public int numberOfFigures = 0; //Number of players
    public int roundCounter = 0; //Current round
    public int numberOfMoves = 0;//Moves made by current player
    
    public int currentFigure = 0;
    public boolean finished = false;
    public ArrayList<Figure> figures;
    public Icefield icf;
    private boolean test;
    /*
     * Shortcuts for possible moves:
     * W,S,D,A - for stepping(up,down,right,left), UR - use rope,
     * USH - use shovel, RS - remove snow, EF - eat food, 
     * UD - use diving suit, UF - use flare gun, RI - retrieve item
     * US - use skill;
     * */
    public enum Move{
    	W,S,D,A, RS, RI, USE, CW, U1, U2, U3, U4, U5, U6, URW, URS, URD ,URA ,USW, USA, USD, USS;
    }
    /*
     * Enum for items to easily compare user input
     * */
    public enum Items{
    	ROPE, SHOVEL, FOOD, SUIT, FLARE, GUN, CHARGE;
    }
    /*
     * Constructor which sets everything ready for the game
     * and starts it.
     * */
    
    public Game(boolean testCases) {
    	test = testCases;
    	startGame();
    	//gameLoop();

    	/*
    	 * The basic idea to separate the threads is here
    	 * let's not delete the test and override the code
    	 * instead of calling the starting and looping methods, 
    	 * we wait to be told from the Main. Otherwise, the whole class should be modified
    	 * in a way that it just do the logic and the calculations(what I prefer)
    	 */
    	//startGame(); 
    	//if(!testCases)
    	//	gameLoop();
    }
   
    /*
     * If user doesn't want to test the game, game loop
     * starts. Players start to make their moves, until
     * game is finished.
     * */
    public void gameLoop() {
    	
    	boolean finished = false;
    	while(!finished) {
    		for(int i = 0; i < numberOfFigures; i++) {
    			if(!nextPlayer(figures.get(i)))
    				finished = true;
    		}
        	roundCounter++;
    	}
    }
    
    public void madeMove(String input) {
    	int numberOfDrowningBefore = 0;
    	int numberOfDrowningAfter = 0;
    	for(int i=0 ; i<figures.size() ; i++) {
    		if(figures.get(i).isDrowning())
    			numberOfDrowningBefore++;
    	}
    	System.out.println("Number of drowning figures before the move: "+numberOfDrowningBefore);
    	if(numberOfDrowningBefore>=numberOfFigures) {
    		finished = true;
    		return;
    	}
    	if(numberOfMoves==4) {
    		currentFigure++;
    		numberOfMoves=0;
    	}
    	if(currentFigure>=numberOfFigures) {
    		roundCounter++;
    		currentFigure = currentFigure % numberOfFigures;
    	}
    	
    	while(figures.get(currentFigure).isDrowning()==true) {
    		currentFigure++;
    		if(currentFigure >= figures.size()) {
    			currentFigure = currentFigure % numberOfFigures;
    			roundCounter++;
    		}
    		numberOfMoves = 0;
    	}
    	
    	Figure currPl = figures.get(currentFigure);
//    	if(currPl.isDrowning() && currPl.getRoundOfDrowning() < roundCounter) {
//			finished = true;
//			return false;
//		}
    	for(int i=0 ; i<figures.size();i++) {
    		if(figures.get(i).isDrowning() && figures.get(i).getRoundOfDrowning()+1 < roundCounter ) {
    			finished = true;
    			return;
    		}
    	}
    	System.out.println("Current figure "+currentFigure);
    	Move move = Move.valueOf(input.toUpperCase());
    	try {
			if(!makeMove(currPl, move)) return;
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong while making a move!");
		}
    	System.out.println("Current numberOfMoves "+ numberOfMoves);
    	for(int i=0 ; i<figures.size() ; i++) {
    		if(figures.get(i).isDrowning())
    			numberOfDrowningAfter++;
    	}
    	System.out.println("Number of drowning figures after the move: "+numberOfDrowningAfter +"\n");
	}
    /*
     *Gets number of players, lets them choose figures, creates
     *icefield and sets roundCounter and numberOfMoves to 0.
     * */
    public void startGame(){
    	roundCounter = 0;
        numberOfMoves = 0;
        
//        if(!test) {
//        	Scanner in = new Scanner(System.in);
//            boolean valid = false;
//            while(!valid) {
//            	System.out.println("Enter the number of players:");
//                numberOfFigures = in.nextInt();
//                if(numberOfFigures >= 3)
//                	break;
//                System.out.println("Minimum number of players is 3!");
//            }
//        }
        figures = new ArrayList<Figure>();
        /*
        if(!test) {
         for(int i = 0; i < numberOfFigures; i++) {
             	figures.add(chooseFigure()); 
             }
        }
        */
        //icf = new Icefield(figures);
    }
    
    public void addFigure(HashMap<String, String> figureNames) {
//    	if(figures.size()<numberOfFigures) {
//    		if(name.equalsIgnoreCase("Eskimo")) {
//    			figures.add(new Eskimo(""));
//    			System.out.println("Eskimo chosen");
//    			System.out.println(figures.size());
//    		}
//    		if(name.equalsIgnoreCase("Explorer")) {
//    			figures.add(new PolarExplorer(""));
//    			System.out.println("Explorer chosen");
//    			System.out.println(figures.size());
//    		}
//    	}
    	for (String key : figureNames.keySet()) {
 		   if(figureNames.get(key).equals("Eskimoo"))
 			   figures.add(new Eskimo(key));
 		   else
 			   figures.add(new PolarExplorer(key));
 		}
    	numberOfFigures = figureNames.size();
    	
    	icf = new Icefield(figures);
    	
    }
    
    /*
     * Each player chooses a figure to play
     * */
    public Figure chooseFigure(){
    	System.out.println("ChooseFigure function has been called");
    	System.out.println("Type 'E' for Eskimo");
    	System.out.println("Type 'P' for Polar explorer");
    	System.out.println("Please, choose the figure:");
    	Scanner in = new Scanner(System.in);
    	String answer;
    	while(true) {
    		answer = in.next();
    		if(answer.toLowerCase().equals("e")) {
    	    	System.out.println("You have chosen Eskimo");
    			Eskimo es = new Eskimo("");
    			return es;
    		}else if(answer.toLowerCase().equals("p")) {
    			System.out.println("You have chosen Polar Explorer");
    			PolarExplorer pe = new PolarExplorer("");
    			return pe;
    		}
    		System.out.println("Invalid arguments");
    	}
    }
    /*
     * Checks if flare gun is collected and
     * if all the figures are on the same iceberg
     * */
    public boolean checkFlareGun(){
    	int flare = 0;
    	Iceberg ic = figures.get(0).getIceberg();
    	ArrayList<IItem> items;
    	for(int i = 0; i < figures.size(); i++) {
    		if(ic.x != figures.get(i).getIceberg().x || ic.y!=figures.get(i).getIceberg().y)
    			return false;
    		items = figures.get(i).getInventory();
    		for(int j = 0; j < items.size(); j++) {
    			if(items.get(j) instanceof Flare || items.get(j) instanceof Gun || items.get(j) instanceof Charge)
    				flare++;
    		}
    	}
    	if(flare == 3)
    		return true;
    	return false;
    }
    
    /*
     * If players managed to collect flare gun and
     * step all the figures on the same iceberg, they win and
     * this method finishes the game
     * */
    public void winGame(){
    	System.out.println("WinGame function has been called");
    	System.out.println("You have won!!!");
    }
    
    /*
     * There are two scenarios:
     * 1.Use = true, checks if item is in current player's inventory
     * and uses.
     * 2.Use = false, Checks if item is on the iceberg and player can retrieve
     **/
    public void useItem(Figure currPl, int j) {
    	List<IItem> items;
    	//if(use)
    	items = currPl.getInventory();
    	//else
    	//items = currPl.getIceberg().getItems();
    	if(items.get(j) instanceof Shovel || items.get(j) instanceof Food || items.get(j) instanceof DivingSuit)
    		((Item) items.get(j)).useItem();
    	//for(int j = 0; j < items.size(); j++) {
    		
    		//if(items.get(j).getClass() == i.getClass()) {
    			//if(use)
    			//	((Item) items.get(j)).useItem();
    			//else
    				//currPl.retrieveItem(items.get(j));
    		//}
    	//}

    }
    /*
     * 
    public void grabItem(Figure currPl,Items it) {
    	switch(it) {
    	case ROPE:
    		checkItem(currPl, new Rope(), false);
	    	break;
	    case SHOVEL:
	    	checkItem(currPl, new Shovel(), false);
	    	break;
	    case FOOD:
	    	checkItem(currPl, new Food(),false);
	    	break;
	    case SUIT:
	    	checkItem(currPl, new DivingSuit(),false);
	    	break;
	    case FLARE:
	    	checkItem(currPl, new Flare(),false);
	    	break;
	    case GUN:
	    	checkItem(currPl, new Gun(),false);
	    	break;
	    default:
	    	checkItem(currPl, new Charge(),false);
	    	break;
    	}
    }
    */
    /*
     * Current player makes move. It can step,remove snow, eat,
     * use shovel, rope, diving suit, flare gun or grab 
     * an item.
     * Returns false - if game finished, true - otherwise
     * */
    public boolean makeMove(Figure currPl, Move move) throws Exception {
    	//If player is in the water, we change the current player
    	
    	System.out.println("makemove called !");
    	
    	switch(move) {
	    case W:
	    	System.out.println("Moved up");
	        currPl.step(Direction.LEFT);
	        break;
	    case S:
	    	System.out.println("Moved down");
	        currPl.step(Direction.RIGHT);
	        break;
	    case D:
	    	System.out.println("Moved right");
	        currPl.step(Direction.DOWN);
	        break;
	    case A:
	    	System.out.println("Moved left");
	        currPl.step(Direction.UP);
	        break;
	    case RS:
	    	System.out.println("Removed snow");
	        currPl.removeSnow(1);
	        break;
	    case RI:
	    	currPl.retrieveItem();
	    	break;
	    case URA:
	    		for(int i=0;i<currPl.getIceberg().getNeighbor(Direction.UP).getFigures().size();i++) {
	    			currPl.getIceberg().getNeighbor(Direction.UP).getFigures().get(i).help(currPl.getIceberg());
	    		}
	    	break;
	    case URW:
    		for(int i=0;i<currPl.getIceberg().getNeighbor(Direction.LEFT).getFigures().size();i++) {
    			currPl.getIceberg().getNeighbor(Direction.LEFT).getFigures().get(i).help(currPl.getIceberg());
    		}
    	break;
	    case URD:
    		for(int i=0;i<currPl.getIceberg().getNeighbor(Direction.DOWN).getFigures().size();i++) {
    			currPl.getIceberg().getNeighbor(Direction.DOWN).getFigures().get(i).help(currPl.getIceberg());
    		}
    	break;
	    case URS:
    		for(int i=0;i<currPl.getIceberg().getNeighbor(Direction.RIGHT).getFigures().size();i++) {
    			currPl.getIceberg().getNeighbor(Direction.RIGHT).getFigures().get(i).help(currPl.getIceberg());
    		}
    	break;
	    case U1:
	    	useItem(currPl, 0 );
	    	break;
	    case U2:
	    	useItem(currPl, 1);
	    	break;
	    case U3:
	    	useItem(currPl, 2);
	    	break;
	    case U4:
	    	useItem(currPl, 3);
	    	break;
	    case U5:
	    	useItem(currPl, 4);
	    	break;
	    case U6:
	    	useItem(currPl, 5);
	    	break;
	    case USE:
	    	if(currPl instanceof Eskimo) {
	    		currPl.useSkill();
	    	}
	    	break;
	    case USW:
	    		if(currPl instanceof PolarExplorer) {
	    			currPl.useSkill(Direction.LEFT);
	    		}
	    	break;
	    case USS:
    		if(currPl instanceof PolarExplorer) {
    			currPl.useSkill(Direction.RIGHT);
    		}
    	break;
	    case USD:
    		if(currPl instanceof PolarExplorer) {
    			currPl.useSkill(Direction.DOWN);
    		}
    	break;
	    case USA:
    		if(currPl instanceof PolarExplorer) {
    			currPl.useSkill(Direction.UP);
    		}
    	break;
	    case CW:
	    	//Players won
	    	return(checkFlareGun());
	    default:
	    	return false;
	    		
    	}
    	numberOfMoves++;
//    	Iceberg ib = currPl.getIceberg();
//    	if(ib instanceof UnstableIceberg) {
//    		if(((UnstableIceberg) ib).getCapacity() == 0) {
//    			numberOfMoves = 4;
//    			System.out.println("Figure " + currentFigure+" is drowning");
//    		}
//    	}
    	//Ends game if player died
    	if(currPl.getBodyHeatUnit() == 0) {
    		finished = true;
    		return false;
    	}
    	//Player fell into the water
    	
    	return true;
    }
    /*
     * Gets current player, lets the player to make moves and
     * switches to the next player.
     * Returns false - if game finished, true - otherwise
     * */
    public boolean nextPlayer(Figure currPl){
    	if(currPl.isDrowning() && currPl.getRoundOfDrowning() < roundCounter) {
			finished = true;
			return false;
		}
    	Scanner in = new Scanner(System.in);
    	String answer;
    	Move move;
    	//Inputs for player to make a move
    	System.out.println("NextPlayer function has been called");
    	System.out.println("Go right - 'D', Go left - 'A', Go up - 'W', Go down - 'S'");
    	System.out.println("Remove snow - \"RS\", Retrieve item - \"RI\",Use shovel - \"US\", ");
    	System.out.println("Use rope - \"UR\", Use diving suit - \"UD\",");
    	System.out.println( "Eat food - \"EF\", Use flare gun - \"UF\"");
    	//Each player has 4 moves
    	while(numberOfMoves < 4) {
    		System.out.println("Enter next move:");
    		boolean invalid = true;
        	while(invalid) {
        		invalid = false;
        		answer = in.next();
        		answer = answer.toUpperCase();
        		try {
        			move = Move.valueOf(answer);
        			if(!makeMove(currPl, move)) return false;
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid input");
					invalid = true;
				} catch(Exception e) {
					System.out.println("Something went wrong while making a move!");
				}
        	}
    	}
    	return true;
    }
    /*
     * Ends the game if anybody's heat went to 0 or anyone drowned
     * into the water
     * */
    public void endGame(){
    	System.out.println("You have lost :(");
    }
}
