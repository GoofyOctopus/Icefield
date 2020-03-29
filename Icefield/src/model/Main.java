package model;

import java.util.Scanner;

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
	public void testCase1()
	{
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.D);//Move down to stable iceberg
	}
	public void testCase2() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.A);//Move Left to stable iceberg
		System.out.println("getNeighbor(Direction direction) methos is called");
	}
	public void testCase3() {}
	public void testCase4() {}
	public void testCase5() {}
	public void testCase6() {}
	public void testCase7() {}
	public void testCase8() {}
	public void testCase9() {}
	public void testCase10() {}
	public void testCase11() {}
	public void testCase12() {}
	public void testCase13() {}
	public void testCase14() {}
}

