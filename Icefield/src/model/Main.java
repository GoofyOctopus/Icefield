package model;

import java.util.Scanner;

import Item.DivingSuit;
import Item.Food;
import Item.Rope;
import Item.Shovel;
import model.Game.Move;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Do you want to play or test?");
		System.out.println("For playing press 1");
		System.out.println("For testing press 2");
		Main main = new Main();
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();
		switch(answer) {
		case 1: Game g = new Game(false);
		case 2: while(main.tests());
		}
		
		/* *
		 *  using 5x5 topleft part *
		 *  2 eskimo 1 explorer *
		 *   all items are reachable *
		 *    14 test case 
		 *    * 15 or any other number is exit */	
	}
	public boolean tests() 
	{
		System.out.println("Which test cases do you want");
		System.out.println("We need to explain test cases to the user");	
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();
		switch(answer) {
		case 1: testCase1(); return true;
		case 2: testCase2(); return true;
		case 3: testCase3(); return true;
		case 4: testCase4(); return true;
		case 5: testCase5(); return true;
		case 6: testCase6(); return true;
		case 7: testCase7(); return true;
		case 8: testCase8(); return true;
		case 9: testCase9(); return true;
		case 10: testCase10(); return true;
		case 11: testCase11(); return true;
		case 12: testCase12(); return true;
		case 13: testCase13(); return true;
		case 14: testCase14(); return true;
		default : System.out.println("Test cases are done! Thank you!"); return false;
		}
	}
	/*
	 * Case N1 - Move to a stable iceberg
	 * */
	public void testCase1()
	{
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.D);//Move RIGHT
	}
	/*
	 * Case N2 - Move to an unstable iceberg
	 * */
	public void testCase2() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.S);//Move DOWN
		g.makeMove(g.figures.get(0), Move.D);//Move RIGHT
	}
	/*
	 * Case N2 - Move to an unstable iceberg to collapse
	 * */
	public void testCase3() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.A);//Move Left
		g.makeMove(g.figures.get(1), Move.A);//Move Left
		g.makeMove(g.figures.get(2), Move.A);//Move Left
	}
	public void testCase4() {
		Game g = new Game(true);
		g.nextPlayer(g.figures.get(0));
		g.nextPlayer(g.figures.get(1));
		g.nextPlayer(g.figures.get(2));
		
		
	}
	public void testCase5() {}
	public void testCase6() {
		Game g = new Game(true);
		g.icf.generateBlizzards();
		System.out.println("Blizzard is generated!");
	}
	public void testCase7() {
			Game g = new Game(true);
		}
	public void testCase8() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(2), Move.US);
	}
	public void testCase9() {
		Game g = new Game(true);
		g.nextPlayer(g.figures.get(0));
		}
	public void testCase10() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.RS);
	}
	public void testCase11() 
	{
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.S); //move to 1,2
		g.makeMove(g.figures.get(0), Move.RI); //food
		System.out.println("Retrieve an item test case is done");
	}
	public void testCase12()
	{
		Game g = new Game(true);
		g.figures.get(0).addToInventory(new DivingSuit());
		g.makeMove(g.figures.get(0), Move.UD);
		System.out.println("Use diving suit test case is done");
	}
	public void testCase13()
	{
		Game g = new Game(true);
		g.figures.get(0).addToInventory(new Food());
		g.makeMove(g.figures.get(0), Move.EF);
		System.out.println("Use food test case is done");
	}
	public void testCase14()
	{
		Game g = new Game(true);
		g.icf.test14();			//setting capacity to 1
		g.makeMove(g.figures.get(0), Move.A);
		g.makeMove(g.figures.get(1), Move.A);
		g.figures.get(2).addToInventory(new Rope());
		g.makeMove(g.figures.get(2), Move.UR); 
		System.out.println("Use rope case is called");
	}
	
	public void testCase15()
	{
		Game g = new Game(true);
		g.figures.get(0).addToInventory(new Shovel());
		g.makeMove(g.figures.get(0), Move.USH);
		System.out.println("Use shovel test case is called");
	}
}

