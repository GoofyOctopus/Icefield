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
		System.out.println("Defualt constructor is called");
		figure = null;
		iceberg = null;
	}
	public void destroy()
	{
		if(iceberg!=null)
			this.iceberg.removeItem(this);
//removeItem method to be added to the figure
//		if(figure!=null)
//			this.figure.removeItem(this);

		iceberg = null;
		figure = null;
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
