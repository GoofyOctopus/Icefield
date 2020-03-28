package Item;

import model.Iceberg;
import Figures.Figure;


public class Charge implements IItem
{
	Iceberg iceberg;
	Figure figure;
	
	public Charge()//default constructor for class Charge
	{
		iceberg=null;
		figure=null;
	}

	public void destroy()//destroying the item on the collapsed iceberg 
	{
		iceberg=null;
	}
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
