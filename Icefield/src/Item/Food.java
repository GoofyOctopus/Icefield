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
		figure.increaseHeatUnit();//increasing the body heat unit of the figure by 1
		
	}
	
	@Override
	public void destroy()
	{
		/*we are overriding the destroy method here because the food is deleted both from the iceberg and figure
		when the figure use food item and we check if there is the item is in the figure then remove it and if it's 
		on the iceberg and then we remove it*/ 
		if(figure!=null)
			this.figure.removeItem(this);
		if(iceberg!=null)
			this.iceberg.removeItem(this);
		
		iceberg=null;
		figure=null;
	}
}
