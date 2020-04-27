package Item;


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
		figure.setWearingDivingSuit(true); /* making the isWearingDivingSuit to true
		 to show that the figure has the diving suit on it*/
	}
	
	public void destroy()/*we are calling the destroy method which is in the super class item and using it here*/
	{
		super.destroy();
	}
}
