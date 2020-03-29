package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Figures.Eskimo;
import Figures.Figure;
import Figures.PolarExplorer;
import Item.*;
/*
 *Beka Babunashvili 
 */
public class Game {
    public int numberOfFigures; //Number of players
    public int roundCounter; //Current round
    private int numberOfMoves;//Moves made by current player
    private ArrayList<Figure> figures;
    private Icefield icf;
    
    /*
     * Shortcuts for possible moves:
     * W,S,D,A - for stepping(up,down,right,left), UR - use rope,
     * USH - use shovel, RS - remove snow, EF - eat food, 
     * UD - use diving suit, UF - use flare gun, RI - retrieve item
     * US - use skill;
     * */
    private enum Move{
    	W,S,D,A, UR, USH, RS, EF, UD, UF, RI,US;
    }
    /*
     * Enum for items to easily compare user input
     * */
    private enum Items{
    	ROPE, SHOVEL, FOOD, SUIT, FLARE, GUN, CHARGE;
    }
    /*
     * Constructor which sets everything ready for the game
     * and starts it.
     * */
    public Game(boolean testCases) {
    	startGame();
    	if(!testCases)
    		gameLoop();
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
    /*
     *Gets number of players, lets them choose figures, creates
     *icefield and sets roundCounter and numberOfMoves to 0.
     * */
    public void startGame(){
    	System.out.println("StartGame function has been called");
    	roundCounter = 0;
        numberOfMoves = 0;
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        while(!valid) {
        	System.out.println("Enter the number of players:");
            numberOfFigures = in.nextInt();
            if(numberOfFigures >= 3)
            	break;
            System.out.println("Minimum number of players is 3!");
        }
        figures = new ArrayList<Figure>();
        for(int i = 0; i < numberOfFigures; i++) {
        	figures.add(chooseFigure());//I will change this part later 
        }
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
    			Eskimo es = new Eskimo();
    			return es;
    		}else if(answer.toLowerCase().equals("p")) {
    			System.out.println("You have chosen Polar Explorer");
    			PolarExplorer pe = new PolarExplorer();
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
    	System.out.println("CheckFlareGun function has been called");
    	int flare = 0;
    	Iceberg ic = figures.get(0).getIceberg();
    	ArrayList<IItem> items;
    	for(int i = 0; i < numberOfFigures; i++) {
    		if(ic != figures.get(0).getIceberg())
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
    public void checkItem(Figure currPl, IItem i, boolean use) {
    	List<IItem> items;
    	if(use)
    		items = currPl.getInventory();
    	else
    		items = currPl.getIceberg().getItems();
    	
    	for(int j = 0; j < items.size(); j++) {
    		Item c = (Item)items.get(j);
    		if(c.equals(i)) {
    			if(use)
    				c.useItem();
    			else
    				currPl.retrieveItem(c);
    		}
    			
    	}
    }
    /*
     * */
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
    /*
     * Current player makes move. It can step,remove snow, eat,
     * use shovel, rope, diving suit, flare gun or grab 
     * an item.
     * Returns false - if game finished, true - otherwise
     * */
    public boolean makeMove(Figure currPl, Move move) {
    	System.out.println("MakeMove functino has been called");
    	Scanner in = new Scanner(System.in);
    	String answer;
    	switch(move) {
	    case W:
	        currPl.step(Direction.UP);
	        break;
	    case S:
	        currPl.step(Direction.DOWN);
	        break;
	    case D:
	        currPl.step(Direction.RIGHT);
	        break;
	    case A:
	        currPl.step(Direction.LEFT);
	        break;
	    case RS:
	        currPl.removeSnow();
	        break;
	    case RI:
	    	System.out.println("Please, choose an item");
	    	answer = in.next().toUpperCase();
	    	Items it = Items.valueOf(answer);
	    	grabItem(currPl, it);
	    	break;
	    case UR:
	    	checkItem(currPl, new Rope(), true);
	    	break;
	    case USH:
	    	checkItem(currPl, new Shovel(), true);
	    	break;
	    case EF:
	    	checkItem(currPl, new Food(),true);
	    	break;
	    case UD:
	    	checkItem(currPl, new DivingSuit(),true);
	    	break;
	    case US:
	    	if(currPl instanceof PolarExplorer) {
	    		System.out.println("Please, enter the direction");
		    	answer = in.next();
		    	Direction d = Direction.valueOf(answer);
		    	try {
					currPl.useSkill(d);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}else {
	    		try {
					currPl.useSkill();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	break;
	    default:
	    	//Players won
	    	if(checkFlareGun())
	    		return false;
	    	break;
    	}
    	numberOfMoves++;
    	//Ends game if player died
    	if(currPl.getBodyHeatUnit() == 0) {
    		endGame();
    		return false;
    	}
    	//Player fell into the water
    	Iceberg ib = currPl.getIceberg();
    	if(ib instanceof UnstableIceberg)
    		if(((UnstableIceberg) ib).getCapacity() == 0)
    			numberOfMoves = 4;
    	return true;
    }
    /*
     * Gets current player, lets the player to make moves and
     * switches to the next player.
     * Returns false - if game finished, true - otherwise
     * */
    public boolean nextPlayer(Figure currPl){
    	if(currPl.isDrowning() && currPl.getRoundOfDrowning() < roundCounter)
			endGame();
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
    	System.out.println("EndGame function has been called");
    	System.out.println("You have lost :(");
    }

}
