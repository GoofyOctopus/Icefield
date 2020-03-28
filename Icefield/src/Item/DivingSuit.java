package Item;

public class DivingSuit extends Item
{
	
	public DivingSuit()
	{
		super();
		System.out.println("Defualt constructor is called");
	}
	
	@Override
	public void useItem()//Diving suit can be used to be sure that the figure does not drown
	{
		System.out.println("useItem() method is called for Diving Suit");
		figure.setWearingDivingSuit(true); // making the isWearingDivingSuit to true to show that the figure has the diving suit on it
		System.out.println("setWearingDivingSuit(boolean:isWearingDivingSuit) method is called");
	}

}
