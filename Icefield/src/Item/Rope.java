package Item;


public class Rope extends Item
{	
	Rope rope;
	//in the default constructor we are calling the constructor from  the super class
	public Rope()//default constructor for rope class
	{
		super();//calling the super class constructor 
	}
	
	@Override
	public void useItem() //rope can be used to help a figure which is drowning 
	{
		System.out.println("useItem() method is called for rope");
		figure.help(iceberg);
	}
	
	
}
