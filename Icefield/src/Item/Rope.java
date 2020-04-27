package Item;


public class Rope extends Item
{	
	//in the default constructor we are calling the constructor from  the super class
	public Rope()//default constructor for rope class
	{
		super();//calling the super class constructor 
	}
	
	@Override
	public void useItem() //rope can be used to help a figure which is drowning 
	{
		figure.help(iceberg);
	}
	
	public void destroy()//calling the destroy method from the super class which is item class
	{
		super.destroy();
	}
	
}
