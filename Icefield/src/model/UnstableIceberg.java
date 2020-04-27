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
		capacity = random.nextInt(2);
	}

	//Returns how many figure it can hold.
	@Override
	public int getCapacity() {
		return capacity;
	}
	//Sets capacity given by the parameter
	public void setCapacity(int capacity) {
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
		figures.add(f);
		f.setIceberg(this);
		if(figures.size() > capacity)
			collapse();
	}
	/*
	 * Makes all the figures fall into water 
	 * and items to be destroyed.
	 */
	public void collapse()
	{
		capacity = 0;
		for(int i = 0; i < figures.size(); i++)
		{
			figures.get(i).drown();
		}
		for(int i = 0; i < items.size(); i++)
		{
			items.get(i).destroy();
		}
		collapsed=true;
	}
}
