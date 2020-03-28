package Item;

public class Shovel extends Item
{
	//in the default constructor we are calling the constructor from  the super class
	public Shovel()
	{
		super();//calling the super class constructor 
	}
	
	@Override
	public void useItem()
	{
		System.out.println("useItem() method is called for Shovel");
		//how to implement that we have to make the remove snow by 2 unit instead of 1
		iceberg.decreaseSnow(2);
	}

}
