package Item;

import model.Iceberg;
import Figures.Figure;


public class Flare implements IItem
{
	Iceberg iceberg;
	Figure figure;
	
	public Flare()//default constructor for class Flare
	{
		System.out.println("Default constructor is called");
		iceberg=null;
		figure=null;
	}
	
	public void destroy()//destroying the item on the collapsed iceberg 
	{
		if(iceberg!=null)
			this.iceberg.removeItem(this);
	}
	
	//getter and setter methods
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
