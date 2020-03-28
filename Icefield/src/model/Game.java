package model;
import java.util.ArrayList;
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
     * Constructor which sets everything ready for the game
     * and starts it.
     * */
    public Game() {
    	boolean finished = false;
    	startGame();
    	while(!finished) {
    		for(int i = 0; i < numberOfFigures; i++) {
    			if(!nextPlayer(figures.get(i)))
    				finished = true;
    		}
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
        System.out.println("Enter the number of players:");
        numberOfFigures = in.nextInt();
        figures = new ArrayList<Figure>();
        for(int i = 0; i < numberOfFigures; i++) {
        	figures.add(chooseFigure());
        }
        icf = new Icefield();/**Should we pass figures to icefield???????*/
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
//    			Eskimo es = new Eskimo();
//    			return es;
    		}else if(answer.toLowerCase().equals("p")) {
    			System.out.println("You have chosen Polar Explorer");
//    			PolarExplorer pe = new PolarExplorer();
//    			return pe;
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
     * Checks if item is in current player's inventory
     * and uses.
     **/
    public void checkItem(Figure currPl, Item i) {
    	ArrayList<IItem> items = currPl.getInventory();
    	for(int j = 0; j < items.size(); j++) {
    		//if(items.get(j) == i) items.get(j).useItem();???????????????????????????????????
    	}
    }
    
    /*
     * Current player makes move. It can step,remove snow, eat,
     * use shovel, rope, diving suit, flare gun or grab 
     * an item.
     * Returns false - if game finished, true - otherwise
     * */
    public boolean makeMove(Figure currPl, Move move){
    	System.out.println("MakeMove functino has been called");
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
	    	//currPl.retrieveItem();??????????????????????????????????????????????????????
	    	break;
	    case UR:
	    	checkItem(currPl, new Rope());
	    	break;
	    case USH:
	    	checkItem(currPl, new Shovel());
	    	break;
	    case EF:
	    	checkItem(currPl, new Food());
	    	break;
	    case UD:
	    	checkItem(currPl, new DivingSuit());
	    	break;
	    case US:
	    	//currPl.useSkill();???????????????????????????????????????????????????????
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
    	System.out.println("Remove snow - \"RS\", Use shovel - \"US\", Use rope - \"UR\"");
    	System.out.println("Use diving suit - \"UD\", Eat food - \"EF\", Use flare gun - \"UF\"");
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
				} catch (Exception e) {
					System.out.println("Invalid input");
					invalid = true;
				}	
        	}
    	}
    	roundCounter++;
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
