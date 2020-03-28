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
		iceberg=null;
	}

}
