package model;

import java.util.ArrayList;

//import model.StableIceberg;
//import model.UnstableIceberg;
/*
 * Yazan
 */
public class Icefield {
	private Iceberg icebergs[][];
	/*
	 * Default constructor initialize the attribute we have
	 * and instantiate the iceberg object according to a 
	 * specific algorithm, where all the sides are unstable
	 * and some few icebergs are unstable according to a
	 * relation between the counters i&j, hence, this might
	 * change if the future to increase the difficulty of
	 * the game
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
					icebergs[i][j]= new UnstableIceberg();
				else
					icebergs[i][j]= new StableIceberg();
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
