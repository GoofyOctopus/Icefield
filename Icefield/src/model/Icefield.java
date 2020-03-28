package model;

import java.util.ArrayList;
import java.util.List;

import Item.IItem;

/*
 * Yazan
 */
public class Icefield {
	private Iceberg icebergs[][];;
	
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
	public Icefield()
	{ 
		System.out.println("Icefield default constructor is called now all icebergs are instantiated");
		icebergs = null;
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
			}
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
