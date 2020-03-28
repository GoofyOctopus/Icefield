package model;
import java.util.List;
import java.util.Random;

import Figures.Figure;
import Item.IItem;
/*Erdene*/
public class UnstableIceberg extends Iceberg{
	private List<Figure> figures;
	private List<IItem> items;
	
	private int capacity;
	Random random;
	public UnstableIceberg(int x, int y) 
	{ 
		super(x,y);
		random = new Random();
		capacity = random.nextInt(3);
		System.out.println("UnstableIceberg(List<Iceberg> neighbouringIcebergs) constructor is called");
	}

	//Returns how many figure it can hold.
	public int getCapacity() {
		System.out.println("getCapacity() method is called"); 
		return capacity;
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
		System.out.println("accept(Figure f) method is called");
		if(capacity < figures.size())
		{
			collapse();
		}
	}
	/*
	 * Makes all the figures fall into water 
	 * and items to be destroyed.
	 */
	public void collapse()
	{
		capacity = 0;
		System.out.println("collapse() method is called");
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
