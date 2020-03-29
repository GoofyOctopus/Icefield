package Item;

import Figures.Figure;
import model.Iceberg;

public interface IItem 
{
	public void destroy();//method for destroying the item from the collapsed iceberg
	
	//getter and setter methods
	public Figure getFigure();
	public void setFigure(Figure figure) ;
	public Iceberg getIceberg();
	public void setIceberg(Iceberg iceberg) ;
}
