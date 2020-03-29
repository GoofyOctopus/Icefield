package model;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Do you want to play or test?");
		System.out.println("For playing press 1");
		System.out.println("For testing press 2");
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();
		switch(answer) {
		case 1: Game g = new Game(false);
		case 2: //we have deal with testss
		}
		
	}
}

