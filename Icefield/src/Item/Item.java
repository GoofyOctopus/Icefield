package Item;

import Figures.Figure;
import model.Iceberg;

public abstract class Item implements IItem 
{
	Figure figure;
	Iceberg iceberg;
	
	abstract public void useItem();
	
	public Item()//default constructor which the child classes will call
	{
		System.out.println("Default constructor is called");//ask yazan if we should have this
		figure = null;
		iceberg = null;
	}
	public void destroy()
	{/*here we are checking if the item is in iceberg then we remove the item and then we do 
	the same thing for the figure and set the both of them to null */
		if(iceberg!=null)
			this.iceberg.removeItem(this);
		if(figure!=null)
			this.figure.removeItem(this);

		iceberg = null;
		figure = null;
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
