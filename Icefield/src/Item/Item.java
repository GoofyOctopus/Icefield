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
		iceberg=null;
		}
	
	public void destroy()
	{
		iceberg=null;
	}
}
