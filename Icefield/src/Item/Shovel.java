package Item;

public class Shovel extends Item
{
	public Shovel()
	{
		super();
		System.out.println("Defualt constructor is called ");
	}
	
	@Override
	public void useItem()
	{
		System.out.println("useItem() method is called for Shovel");
		//how to implement that we have to make the remove snow by 2 unit instead of 1
		iceberg.decreaseSnow(2);
	}

}
