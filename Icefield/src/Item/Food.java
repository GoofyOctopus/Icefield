package Item;


public class Food extends Item
{
	
	public Food()
	{
		super();
		System.out.println("Ddefault constructor is called here");
	}
	@Override
	public void useItem()//increasing the body heat unit of the figure by 1
	{
		System.out.println("useItem() method is called for food");
		figure.increaseHeatUnit();
		System.out.println("IncreaseHeatUnit() method is called");
	}
}
