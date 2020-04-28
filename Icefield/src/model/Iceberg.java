package model;

import Figures.Figure;
import Item.*;

import java.util.ArrayList;
import java.util.List;

/*
 * Yazan
 */
public abstract class Iceberg {
	private int snowUnit;
	private boolean hasigloos;
	private List<Iceberg> borderingIceberg;
	protected List<Figure> figures;
	protected List<IItem> items;
	protected boolean collapsed=false;
	protected int x; //new location attribute
	protected int y; //new location attribute
	
	/*
	 * Default constructor, sets most attributes, other attributes
	 * are supposed to be initialized later using other methods
	 */
	public Iceberg(int x, int y)
	{
		this.snowUnit = 1;
		this.hasigloos = false;
		this.borderingIceberg = new ArrayList<Iceberg>();
		this.items = new ArrayList<IItem>();
		this.figures = new ArrayList<Figure>();
		this.x=x;
		this.y=y;
		
		for (int i = 0; i < 4; i++) //setting initial size of iceberg
			this.borderingIceberg.add(i,null);
			
	}
	/*
	 * getNeighbor(Direction direction) method is used when a figure
	 * wants to move between icebergs. The Figure iceberg asks the
	 * Iceberg class to return a reference to the neighboring iceberg
	 * in a passed direction.
	 */
	public Iceberg getNeighbor(Direction direction)
	{
		switch (direction) 
		{
		case UP: return borderingIceberg.get(0); 
		case DOWN: return borderingIceberg.get(1); 
		case RIGHT: return borderingIceberg.get(2);
		case LEFT:	return borderingIceberg.get(3);
		default :  return null;   //Invalid argument given
		}
	}
	/*
	 * accept(Figure f) method is used when a figure that knows the
	 * reference to one iceberg asks it to add him(moved to it)
	 */
	public void accept(Figure f) { 
		figures.add(f);
		f.setIceberg(this);
	}
	/*
	 * remove(Figure f) method is called when the figure is accepted
	 * in another iceberg, where the previous iceberg is asked to
	 * remove that figure from the list(moved from)
	 */
	public void remove(Figure f) { 
		figures.remove(f);
	}
	/*
	 * setBorderingIceberg(Direction d, Iceberg i) is called in cases of 
	 * creating icebergs that don't have a list of neighboring 
	 * icebergs, and that is to avoid loops.
	 * The name of the method is changed for consistency
	 */
	public void setBorderingIceberg(Direction d, Iceberg i)
	{
		int index = d.ordinal();
		borderingIceberg.set(index, i);
	}
	/*
	 * decreaseSnow(int units) method is called when the figure
	 * wants to remove snow from the iceberg. The parameter passed
	 * depends on whether he is using a shovel or not.
	 */
	public void decreaseSnow(int units) 
	{
		this.snowUnit = snowUnit - units < 0 ? 0 : snowUnit-units; 
	}
	/*
	 * increaseSnow() method is called in case of blizzards
	 */
	public void increaseSnow() { snowUnit++; }
	/*
	 * isIgloos() method is called to check whether this iceberg
	 * has igloos or not
	 * method name is changed for consistency
	 */
	public boolean ishasIgloos() { return hasigloos; }
	/*
	 * removeItem(IItem item) method removes a passed item from
	 * the list of items, and that happens when a player retrieve
	 * it or when an iceberg drown
	 */
	public void removeItem(IItem item) { items.remove(item); }
	/*
	 * The following methods are just getters and setters,
	 * they were not represented in the class diagram for
	 * clarity
	 */
	/*
	 * getItems() is called when we want to write the items
	 * in the iceberg on the screen(in the future)
	 */
	public List<IItem> getItems() { return items; }
	/*
	 * addItem(IItem item) method is called at the
	 * beginning of the game, when setting it up
	 */
	public void addItem(IItem item)
	{
		this.items.add(item);
		((IItem) item).setIceberg(this); //telling the item that this is its iceberg
	}
	/*
	 * setIgloos(boolean hasigloos) method is called when an
	 * Eskimo uses their skill
	 */
	public void sethasIgloos(boolean hasigloos) 
	{ 
		this.hasigloos = hasigloos;
	}
	
	public void setSnow(int snow) {
		this.snowUnit = snow;
	}
	public List<Figure> getFigures(){
		return figures;
	}
	public boolean isCollapsed() {return collapsed;}
	public abstract void setCapacity(int capacity);
	public int getX() { return x; }
	public int getSnow() {return snowUnit;}
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }	
	public abstract int getCapacity();
}