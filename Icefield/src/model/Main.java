package model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Utility.UtilityClass;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		String next = in.next();
		UtilityClass.run(next);
		UtilityClass.print();
	}
}
	
	
	
	
	
	
/*  Previous tests
 
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.out.println("Do you want to play or test?");
		System.out.println("For playing press 1");
		System.out.println("For testing press 2");
		Main main = new Main();
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();
		switch(answer) {
		case 1: Game g = new Game(false);
		case 2: while(main.tests()) {System.out.println("############Case is done############");};
		}
		/*Usage of utility classes
		List<String> data = ReadFile.readFrom("deleteme.txt"); 
		for (String line : data) 
			System.out.println(line);
		
		if(WriteToFile.writeTo(data, "C:/temp/help.txt"))
			System.out.println("Saved Successfully!");
		
	}
	public boolean tests() 
	{	//You enter anything else to exit.
		System.out.println("--------------------Test Cases--------------------");
		System.out.println("Enter which case you would like to run: ");
		System.out.println("1  : Move to unstable iceberg");
		System.out.println("2  : Move to stable iceberg");
		System.out.println("3  : WIN");
		System.out.println("4  : Endgame");
		System.out.println("5  : Drown");
		System.out.println("6  : Blizzard");
		System.out.println("7  : Check capacity");
		System.out.println("8  : Build igloos");
		System.out.println("9  : Next player");
		System.out.println("10 : Remove snow");
		System.out.println("11 : Retrieve an item");
		System.out.println("12 : Use diving suit");
		System.out.println("13 : Use food");
		System.out.println("14 : Use rope");
		System.out.println("15 : Use shovel");
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
		case 15: testCase15(); return true;
		default : System.out.println("Test cases are done! Thank you!"); return false;
		}
	}
	
	 * Test case N1 - Move to an unstable iceberg and collapse after exceeding

	public void testCase1() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.S);
		g.makeMove(g.figures.get(0), Move.D);
	}

	 * Test case N2 - Move to a stable iceberg

	public void testCase2()
	{
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.D);//Move RIGHT
	}

	 * Test case N3 - Winning the game

	public void testCase3() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.S);//Move Left
		System.out.println("Type GUN");
		g.makeMove(g.figures.get(0), Move.RI);
		g.makeMove(g.figures.get(1), Move.S);//Move Left
		System.out.println("Type CHARGE");
		g.makeMove(g.figures.get(0), Move.RI);
		g.makeMove(g.figures.get(2), Move.S);//Move Left
		System.out.println("Type FLARE");
		g.makeMove(g.figures.get(0), Move.RI);
		if(g.checkFlareGun())
			g.winGame();
		
	}

	 * Test case N4 - game is over

	public void testCase4() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.S);//Move DOWN
		g.makeMove(g.figures.get(0), Move.D);//Move RIGHT
		g.makeMove(g.figures.get(1), Move.S);//Move DOWN
		g.makeMove(g.figures.get(1), Move.D);//Move RIGHT
		g.makeMove(g.figures.get(2), Move.S);//Move DOWN
		g.makeMove(g.figures.get(2), Move.D);//Move RIGHT
		g.roundCounter++;
		g.nextPlayer(g.figures.get(0));
		
	}

	 * Test case N5 - drown

	public void testCase5() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.S);//Move DOWN
		g.makeMove(g.figures.get(0), Move.D);//Move RIGHT
		g.makeMove(g.figures.get(1), Move.S);//Move DOWN
		g.makeMove(g.figures.get(1), Move.D);//Move RIGHT
		g.makeMove(g.figures.get(2), Move.S);//Move DOWN
		g.makeMove(g.figures.get(2), Move.D);//Move RIGHT
		
	}

	 * Test case N6 - Generate blizzard

	public void testCase6() {
		Game g = new Game(true);
		g.icf.generateBlizzards();
		System.out.println("Blizzard is generated!");
	}

	 * Test case N7 - Checking capacity of neighboring iceberg

	public void testCase7() {
		Game g = new Game(true);
		System.out.println("Type any direction UP,DOWN,LEFT,RIGHT");
		g.makeMove(g.figures.get(2), Move.US);
		System.out.println("Check capacity test case is done!");
	}

	 * Test case N8 - Building igloos

	public void testCase8() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.US);
	}

	 * Test case N9 - Next player 

	public void testCase9() {
		Game g = new Game(true);
		g.nextPlayer(g.figures.get(0));
		// You have to type D for testing.
	}

	 * Test case N10 - Removing snow

	public void testCase10() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.RS);
	}

	 * Test case N11 - Retrieving an item

	public void testCase11() 
	{
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.S); //move to 1,2
		g.makeMove(g.figures.get(0), Move.RI); //food exist on this iceberg.
		System.out.println("Retrieve an item test case is done");
		//Please type FOOD for testing.
	}

	 * Test case N12 - Using diving suit

	public void testCase12()
	{
		Game g = new Game(true);
		g.figures.get(0).addToInventory(new DivingSuit());
		g.figures.get(0).getInventory().get(0).setFigure(g.figures.get(0));
		g.makeMove(g.figures.get(0), Move.UD);
		System.out.println("Use diving suit test case is done");
	}

	 * Test case N13 - Using food

	public void testCase13()
	{
		Game g = new Game(true);
		g.figures.get(0).addToInventory(new Food());
		g.figures.get(0).getInventory().get(0).setFigure(g.figures.get(0));
		g.makeMove(g.figures.get(0), Move.EF);
		System.out.println("Use food test case is done");
	}

	 * Test case N14 - Using rope

	public void testCase14()
	{
		Game g = new Game(true);
		g.icf.test14();			//setting capacity to 1
		g.makeMove(g.figures.get(0), Move.A);
		g.makeMove(g.figures.get(1), Move.A);
		g.figures.get(2).addToInventory(new Rope());
		g.figures.get(2).getInventory().get(0).setFigure(g.figures.get(2));
		g.figures.get(2).getInventory().get(0).setIceberg(g.figures.get(2).getIceberg());
		g.makeMove(g.figures.get(2), Move.UR); 
		System.out.println("Use rope case is called");
	}

	 * Test case N15 - Using shovel

	public void testCase15()
	{
		Game g = new Game(true);
		g.figures.get(0).addToInventory(new Shovel());
		g.figures.get(0).getInventory().get(0).setFigure(g.figures.get(0));
		g.figures.get(0).getInventory().get(0).setIceberg(g.figures.get(0).getIceberg());
		g.makeMove(g.figures.get(0), Move.USH);
		System.out.println("Use shovel test case is called");
	}
	*/
	


