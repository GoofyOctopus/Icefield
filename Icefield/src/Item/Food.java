package Item;


public class Food extends Item
{
	//in the default constructor we are calling the constructor from  the super class
	public Food()//default constructor for class Food
	{
		super();//calling the super class constructor
	}
	@Override
	public void useItem()
	{
		System.out.println("useItem() method is called for food");
		figure.increaseHeatUnit();//increasing the body heat unit of the figure by 1
		this.destroy();/*we have used destroy here because the food is deleted both from the iceberg and figure
		when the figure use food item*/ 
	}
}
