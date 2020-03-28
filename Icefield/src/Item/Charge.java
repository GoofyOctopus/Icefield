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
}
