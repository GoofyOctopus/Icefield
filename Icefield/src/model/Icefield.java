package model;

import java.util.ArrayList;
import java.util.List;

import Item.*;
import Figures.*;
/*
 * Yazan
 */
public class Icefield {
	private Iceberg icebergs[][];
	private List<IItem> items;
	
	/*
	 * Default constructor initializes the icebergs 2d array
	 * and instantiate the iceberg objects according to a 
	 * specific algorithm, where all the sides are unstable
	 * and some few icebergs are unstable according to a
	 * relation between the counters i&j, hence, this might
	 * change if the future to increase the difficulty of
	 * the game. Also in the constructor the icebergs'
	 * neighbors are set.
	 */
	public Icefield(List<Figure> figures, int locations[])
	{ 
		System.out.println("Icefield default constructor is called now all icebergs are instantiated");
		icebergs = new Iceberg[10][10];
		items = new ArrayList<IItem>();
		for(int i = 0; i < 10; i++) 
		{
			for(int j = 0; j < 10; j++)
			{
				if(((i%2==0)&&(j%2==0))||((i==0)||(i==9)||(j==0)||(j==9)))
					icebergs[i][j]= new UnstableIceberg(i,j);
				else
					icebergs[i][j]= new StableIceberg(i,j);
				if(j > 0)
				{
					icebergs[i][j].setBorderingIceberg(Direction.UP, icebergs[i][j-1]);
					icebergs[i][j-1].setBorderingIceberg(Direction.DOWN, icebergs[i][j]);
				}
				if(i > 0)
				{
					icebergs[i][j].setBorderingIceberg(Direction.LEFT, icebergs[i-1][j]);
					icebergs[i-1][j].setBorderingIceberg(Direction.RIGHT, icebergs[i][j]);
				}
				if(j%2==0)
				{
					icebergs[i][j].addItem(new Food());
				}
				if(j%5==0)
				{
					icebergs[i][j].addItem(new Flare());
				}
				if((i!=0)&&(i%6==0))
				{
					icebergs[i][j].addItem(new Gun());
				}
				if((i!=0)&&(i%8==0))
				{
					icebergs[i][j].addItem(new Charge());
				}
				if((i!=0)&&(i%3==0))
				{
					icebergs[i][j].addItem(new Shovel());
				}
				if((j!=0)&&j%4==0)
				{
					icebergs[i][j].addItem(new Rope());
				}
				if(i==j)
				{
					icebergs[i][j].addItem(new DivingSuit()); 
				}
			}
		} 
		//setting the figures on the icebergs
		for(int i = 0; i < figures.size(); i+=2)
		{
			//in location array, each two consecutive numbers represent a location 
			icebergs[locations[i]][locations[i+1]].accept(figures.get(i));
			figures.get(i).setIceberg(icebergs[locations[i]][locations[i+1]]);
		}
	}
	/*
	 * generateBlizzards() method is used called from the Game class
	 * it iterates through the iceberg objects and call the increaseSnow
	 * method for each
	 */
	public void generateBlizzards()
	{
		System.out.println("generateBlizzards() method is called");
		for(int i = 0; i < 10; i++) 
		{
			for(int j = 0; j < 10; j++)
			{
				icebergs[i][j].increaseSnow();
			}
		}
	}
}
