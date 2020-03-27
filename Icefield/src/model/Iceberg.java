package model;

import Figures.Figure;
import Item.IItem;

import java.util.List;

public abstract class Iceberg {
	private int snowUnit;
	private boolean igloos;
	private List<Iceberg> borderingIceberg;
	private List<Figure> figures;
	private List<IItem> items;
	
	/*
	 * Two constructors, one for when we send the neighboring icebergs
	 * and another default constructor, as it is not possible to instantiate
	 * all icebergs with knowing the neighboring icebergs of each (loop of
	 * dependencies). Instead, some are going to be instantiated without 
	 * knowing their neighbors, but later they are going to be added in the list
	 */
	public Iceberg()
	{
		System.out.println("Default Iceberg constructor is called");
		this.snowUnit = 1;
		this.igloos = false;
		this.borderingIceberg = null;
	}
	public Iceberg(List<Iceberg> borderingIceberg)
	{
		System.out.println("Non-default Iceberg contructor is called");
		this.snowUnit = 1;
		this.igloos = false;
		this.borderingIceberg = borderingIceberg;
	}
	/*
	 * getNeighbor(Direction direction) method is used when a figure
	 * wants to move between icebergs. The Figure iceberg asks the
	 * Iceberg class to return a reference to the neighboring iceberg
	 * in a passed direction.
	 */
	public Iceberg getNeighbor(Direction direction)
	{
		System.out.println("getNeighbor(Direction direction) methos is called");
		switch (direction) 
		{
		case UP: return borderingIceberg.get(0); 
		case DOWN: return borderingIceberg.get(1); 
		case RIGHT: return borderingIceberg.get(2); 
		default : return borderingIceberg.get(3);  //default is performed when non of the cases is true
		}
	}
	/*
	 * accept(Figure f) method is used when a figure that knows the
	 * reference to one iceberg asks it to add him(moved to it)
	 */
	public void accept(Figure f) { System.out.println("accept(Figure f) method is called"); figures.add(f); }
	/*
	 * remove(Figure f) method is called when the figure is accepted
	 * in another iceberg, where the previous iceberg is asked to
	 * remove that figure from the list(moved from)
	 */
	public void remove(Figure f) { System.out.println("remove(Figure f) method is called"); figures.remove(f); }
	/*
	 * setNeighbor(Direction d, Iceberg i) is called in cases of 
	 * creating icebergs that don't have a list of neighboring 
	 * icebergs, and that is to avoid loops.
	 */
	public void setNeighbor(Direction d, Iceberg i)
	{
		System.out.println("setNeighbor(Direction d, Iceberg i) method is called");
		int index = d.ordinal();
		borderingIceberg.add(index, i);
	}
	/*
	 * decreaseSnow(int units) method is called when the figure
	 * wants to remove snow from the iceberg. The parameter passed
	 * depends on whether he is using a shovel or not.
	 */
	public void decreaseSnow(int units) 
	{
		System.out.println("decreaseSnow(int units) method is called");
		this.snowUnit = snowUnit - units < 0 ? 0 : snowUnit-units; 
		/*
		 * same as the following
		 if(snowUnit - units < 0)
			snowUnit = 0;
		else
			snowUnit-=units;
		*/
	}
	/*
	 * increaseSnow() method is called in case of blizzards
	 */
	public void increaseSnow() { System.out.println("increaseSnow() mehtod is called"); snowUnit++; }
	/*
	 * hasIgloos() method is called to check whether this iceberg
	 * has igloos or not
	 */
	public boolean hasIgloos() { System.out.println("hasIgloos() method is called"); return igloos; }
	/*
	 * removeItem(IItem item) method removes a passed item from
	 * the list of items, and that happens when a player retrieve
	 * it or when an iceberg drown
	 */
	public void removeItem(IItem item) { System.out.println("removeItem(IItem item) is called"); items.remove(item); }	
}
