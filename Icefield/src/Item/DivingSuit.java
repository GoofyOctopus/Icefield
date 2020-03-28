package Item;

import Figures.Figure;
import model.Iceberg;

public class DivingSuit extends Item
{
	//in the default constructor we are calling the constructor from  the super class
	public DivingSuit()
	{
		super();//calling the super class constructor 
	}
	
	@Override
	public void useItem()//Diving suit can be used to be sure that the figure does not drown
	{
		System.out.println("useItem() method is called for Diving Suit");
		figure.setWearingDivingSuit(true); // making the isWearingDivingSuit to true to show that the figure has the diving suit on it
		System.out.println("setWearingDivingSuit(boolean:isWearingDivingSuit) method is called");
	}
}
