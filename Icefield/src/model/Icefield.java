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
	public Icefield(List<Figure> figures)
	{ 
		icebergs = new Iceberg[10][10];
		for(int i = 0; i < 10; i++) 
		{
			for(int j = 0; j < 10; j++)
			{	//all surroundings are unstable and some others
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
			/*	if(j%2==0)
				{
					icebergs[i][j].addItem(new Food());
				}
				if((i==1)&&(j==2))
				{
					icebergs[i][j].addItem(new Flare());
				}
				if((i==1)&&(j==2))
				{
					icebergs[i][j].addItem(new Gun());
				}
				if((i==1)&&(j==2))
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
				if(i==j+1)
				{
					icebergs[i][j].addItem(new DivingSuit()); 
				}
				*/
			}
		}
		
		//setting the figures on the icebergs
		for(int i = 0; i < figures.size(); i++)
		{
			//in location array, each two consecutive numbers represent a location 
			icebergs[1][1].accept(figures.get(i));
			figures.get(i).setIceberg(icebergs[1][1]);
		}
		
		//setting the sea around the icefield
		for(int i = 0; i< 10; i++) 
		{
			for( int j = 0; j< 10 ; j++) 
			{
				if((i==0)||(i==9))
					((UnstableIceberg) icebergs[i][j]).setCapacity(0);
				if((j==0)||(j==9))
					((UnstableIceberg) icebergs[i][j]).setCapacity(0);
			}
		}
	}
	/*
	 * generateBlizzards() method is used called from the Game class
	 * it iterates through the iceberg objects and call the increaseSnow
	 * method for each
	 */
	
	
	public void setFigures(Figure f,int x,int y) {
		icebergs[x][y].accept(f);
		f.setIceberg(icebergs[x][y]);
	}
	
	public void createStableIceberg(int x,int y) {
		icebergs[x][y]=new StableIceberg(x,y);
		icebergs[x][y].setBorderingIceberg(Direction.UP, icebergs[x][y-1]);
		icebergs[x][y].setBorderingIceberg(Direction.DOWN, icebergs[x][y+1]);
		icebergs[x][y].setBorderingIceberg(Direction.LEFT, icebergs[x-1][y]);
		icebergs[x][y].setBorderingIceberg(Direction.RIGHT, icebergs[x+1][y]);
		icebergs[x][y-1].setBorderingIceberg(Direction.DOWN, icebergs[x][y]);
		icebergs[x][y+1].setBorderingIceberg(Direction.UP, icebergs[x][y]);
		icebergs[x-1][y].setBorderingIceberg(Direction.RIGHT, icebergs[x][y]);
		icebergs[x+1][y].setBorderingIceberg(Direction.LEFT, icebergs[x][y]);
	}
	
	public void createUnstableIceberg(int x,int y,int capacity) {
		icebergs[x][y]=new UnstableIceberg(x,y);
		icebergs[x][y].setBorderingIceberg(Direction.UP, icebergs[x][y-1]);
		icebergs[x][y].setBorderingIceberg(Direction.DOWN, icebergs[x][y+1]);
		icebergs[x][y].setBorderingIceberg(Direction.LEFT, icebergs[x-1][y]);
		icebergs[x][y].setBorderingIceberg(Direction.RIGHT, icebergs[x+1][y]);
		icebergs[x][y-1].setBorderingIceberg(Direction.DOWN, icebergs[x][y]);
		icebergs[x][y+1].setBorderingIceberg(Direction.UP, icebergs[x][y]);
		icebergs[x-1][y].setBorderingIceberg(Direction.RIGHT, icebergs[x][y]);
		icebergs[x+1][y].setBorderingIceberg(Direction.LEFT, icebergs[x][y]);
		icebergs[x][y].setCapacity(capacity);
	}
	
	public void setItems(String name,int x,int y) {
		switch(name) {
		case "rope": icebergs[x][y].addItem(new Rope());
		break;
		case "food": icebergs[x][y].addItem(new Food());
		break;
		case "flare": icebergs[x][y].addItem(new Flare());
		break;
		case "gun": icebergs[x][y].addItem(new Gun());
		break;
		case "charge": icebergs[x][y].addItem(new Charge());
		break;
		case "shovel": icebergs[x][y].addItem(new Shovel());
		break;
		case "divingsuit": icebergs[x][y].addItem(new DivingSuit());
		break;
		}
	}
	
	public void setSnow(int x,int y,int snow) {
		icebergs[x][y].setSnow(snow);
	}
	
	public void setCapacity(int x,int y,int capacity) {
		icebergs[x][y].setCapacity(capacity);
	}
	
	public void generateBlizzards(int x,int y){
		if(icebergs[x][y].ishasIgloos()==true)
			{
				icebergs[x][y].increaseSnow();
			}
		for(int k = 0;k<icebergs[x][y].figures.size();k++)
			icebergs[x][y].figures.get(k).decreaseHeatUnit();
	}
}
