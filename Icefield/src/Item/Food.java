package Item;


public class Food extends Item
{
	//in the default constructor we are calling the constructor from  the super class
	public Food()//default constructor for class Food
	{
		super();//calling the super class constructor
	}
	@Override
	public void useItem()//increasing the body heat unit of the figure by 1
	{
		System.out.println("useItem() method is called for food");
		figure.increaseHeatUnit();
		System.out.println("IncreaseHeatUnit() method is called");
	}
}
