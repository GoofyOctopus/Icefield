package model;

import java.util.Scanner;

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
		case 2: main.tests();
		}
		
		/* *
		 *  using 5x5 topleft part *
		 *  2 eskimo 1 explorer *
		 *   all items are reachable *
		 *    14 test case 
		 *    * 15 is exit */	
	}
	public void tests() 
	{
		System.out.println("Do you want to play or test?");		
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();
		switch(answer) {
		case 1: testCase1(); break;
		case 2: testCase2(); break;
		case 3: testCase3(); break;
		case 4: testCase4(); break;
		case 5: testCase5(); break;
		case 6: testCase6(); break;
		case 7: testCase7(); break;
		case 8: testCase8(); break;
		case 9: testCase9(); break;
		case 10: testCase10(); break;
		case 11: testCase11(); break;
		case 12: testCase12(); break;
		case 13: testCase13(); break;
		case 14: testCase14(); break;
		default : System.out.println("Invalid input!"); break;
		}
	}
	public void testCase1()
	{
		
	}
	public void testCase2() {}
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

