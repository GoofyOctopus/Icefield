package model;

import Item.DivingSuit;
import Item.Food;
import Item.Rope;
import Item.Shovel;
import model.Game.Move;

public class yazantempcalss {

	public void testCase11() 
	{
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.RI);
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