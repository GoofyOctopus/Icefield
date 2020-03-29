package model;
import java.util.List;
import java.util.Random;

import Figures.Figure;
import Item.IItem;
/*Erdene*/
public class UnstableIceberg extends Iceberg{
	private int capacity;
	private Random random;
	
	public UnstableIceberg(int x, int y) 
	{ 
		super(x,y);
		random = new Random();
		capacity = random.nextInt(3);
		System.out.println("UnstableIceberg constructor is called");
	}

	//Returns how many figure it can hold.
	public int getCapacity() {
		System.out.println("getCapacity() method is called"); 
		return capacity;
	}
	//Sets capacity given by the parameter
	public void setCapacity(int capacity) {
		System.out.println("setCapacity() method is called");
		this.capacity = capacity;
	}
	/*
	 *  Adds the figure to the iceberg
	 * checks the capacity 
	 * and if it exceeds the number of figures, collapse() method will be called
	 */
	@Override
	public void accept(Figure f) 
	{ 
		System.out.println("accept(Figure f) method is called");
		figures.add(f);
		if(figures.size() > capacity)
			collapse();
	}
	/*
	 * Makes all the figures fall into water 
	 * and items to be destroyed.
	 */
	public void collapse()
	{
		System.out.println("collapse() method is called");
		capacity = 0;
		for(int i = 0; i < figures.size(); i++)
		{
			figures.get(i).drown();
		}
		for(int i = 0; i < items.size(); i++)
		{
			items.get(i).destroy();
		}
	}
}
