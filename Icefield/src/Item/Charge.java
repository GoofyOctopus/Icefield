package Item;

import model.Iceberg;
import Figures.Figure;


public class Charge implements IItem
{
	Iceberg iceberg;
	Figure figure;
	
	public Charge()//default constructor for class Charge
	{
		/*in default constructor by making the iceberg and figure to null
		 *  show that the item is neither in the figures inventory or on the iceberg */
		iceberg=null;
		figure=null;
	}

	public void destroy()//destroying the item on the collapsed iceberg, checking if the item is on the iceberg then we remove it
	{
		if(iceberg!=null)
			this.iceberg.removeItem(this);
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
