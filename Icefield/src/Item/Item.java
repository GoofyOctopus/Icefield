package Item;

import Figures.Figure;
import model.Iceberg;

public abstract class Item implements IItem 
{
	Figure figure;
	Iceberg iceberg;
	
	abstract public void useItem();//abstract method which we implement in the child classes regarding using an item such as shovel,rope,diving suit,food
	
	public Item()//default constructor which the child classes will call
	{
		//by setting the figure and iceberg to null we show that the item is not owned by any of them
		figure = null;
		iceberg = null;
	}
	public void destroy()
	{//here we are checking if the item is in iceberg then we remove the item from the iceberg
		if(iceberg!=null)
			this.iceberg.removeItem(this);
		
		iceberg = null;
	}

	//getters and setter methods
	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	public Iceberg getIceberg() {
		return iceberg;
	}

	public void setIceberg(Iceberg iceberg) {
		this.iceberg = iceberg;
	}
	
}
