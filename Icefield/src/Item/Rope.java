package Item;


public class Rope extends Item
{	
	Rope rope= new Rope();
	/*in the default constructor we are calling the constructor from  the super class which is the call item
	 * in the super class we instantiate the items and put them on the icebergs
	 * */
	public Rope()//default constructor for rope class
	{
		super();//calling the super class constructor 
		System.out.println("Default constructor is called");
	}
	
	@Override
	public void useItem() //rope can be used to help a figure which is drowning 
	{
		if((rope instanceof Rope) == true)
		{
		System.out.println("useItem() method is called for rope");
		figure.help(iceberg);
		System.out.println("help(i:iceberg) method is called");
		}
		else
		{
			System.out.println("The item is not an instance of rope!!");
		}
	}
	
	
}
