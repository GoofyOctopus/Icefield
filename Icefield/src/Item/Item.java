package Item;

import Figures.Figure;
import model.Iceberg;

public abstract class Item implements IItem 
{
	Figure figure;
	Iceberg iceberg;
	
	abstract public void useItem();
	
	public Item()
	{
		
		figure = null;
		for(int i=0 ; i<10 ; i++)
		{
			for(int j=0 ; j<10 ; j++)
			{
			}
		}
	}
	
	public void destroy()
	{
		iceberg=null;
	}
}
