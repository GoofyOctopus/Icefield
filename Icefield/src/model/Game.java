package model;
import java.util.Scanner;

import Figures.Figure;

public class Game {
    public int numberOfFigures;
    public int roundCounter;
    private int numberOfMoves;

    public void startGame(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of players:");
        numberOfFigures = in. nextInt();
        roundCounter = 0;
        numberOfMoves = 0;
    }
    public void chooseFigure(int numberOfFigures){}
    public void checkFlareGun(){}
    public void winGame(){}
    public void makeMove(Figure currPl){}
    public void nextPlayer(){}
    public void endGame(){}

}
