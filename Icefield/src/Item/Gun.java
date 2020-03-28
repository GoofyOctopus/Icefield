package Item;

import model.Iceberg;
import Figures.Figure;

public class Gun implements IItem
{
	Iceberg iceberg;
	Figure figure;
	
	public Gun()//default constructor for class Gun
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
