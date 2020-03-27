package model;
import java.util.Scanner;

import Figures.Eskimo;
import Figures.Figure;
import Figures.PolarExplorer;
/*
 *Beka Babunashvili 
 */
public class Game {
    public int numberOfFigures; //Number of players
    public int roundCounter; //Current round
    private int numberOfMoves;//Moves made by current player
    private Figure[] figures;/**new*/
    private Icefield icf;/**new*/
    /*
     * Constructor which sets everything ready for the game
     * and starts it.
     * */
    public Game() {
    	startGame();
    	//while(true) {
    		for(int i = 0; i < numberOfFigures; i++) {
    			nextPlayer(figures[i]);
    		}
    	//}
    	
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
        figures = new Figure[numberOfFigures];
        for(int i = 0; i < numberOfFigures; i++) {
        	figures[i] = chooseFigure();
        }
        icf = new Icefield();/**Should we pass figures to icefield???????*/
    }
    
    /*
     * Each player chooses a figure to play
     * */
    /**Changed return value*/
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
    public void checkFlareGun(){
    	System.out.println("CheckFlareGun function has been called");
    }
    public void winGame(){
    	System.out.println("WinGame function has been called");
    }
    /*
     * Current player makes move. It can step,remove snow, eat,
     * use shovel, rope, diving suit, flare gun or grab 
     * an item.*/
    public void makeMove(Figure currPl){
    	System.out.println("MakeMove functino has been called");
    }
    /*
     * Gets current player, lets the player to make moves and
     * switches to the next player.
     * */
    public void nextPlayer(Figure currPl){
    	System.out.println("NextPlayer function has been called");
    }
    /*
     * Ends the game if anybody's heat went to 0 or anyone drowned
     * into the water
     * */
    public void endGame(){
    	System.out.println("EndGame dunction has been called");
    }

}
