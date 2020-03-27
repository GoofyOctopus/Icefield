package model;
import java.util.List;
import Figures.Figure;
import Item.IItem;
public class UnstableIceberg extends Iceberg{
	
	private List<Figure> figures;
	private List<IItem> items;
	public UnstableIceberg(List<Iceberg> neighbouringIcebergs) 
	{
		super(neighbouringIcebergs);
		System.out.println("UnstableIceberg(List<Iceberg> neighbouringIcebergs) constructor is called");
	}
	
	private int capacity;
	
	public int getCapacity() {
		System.out.println("getCapacity() method is called"); 
		return capacity;
		//Returns how many figure it can hold.
	}
	@Override
	public void accept(Figure f) 
	{ 
		figures.add(f);
		System.out.println("accept(Figure f) method is called");
	}
		
	public void collapse()
	{
		System.out.println("collapse() method is called");
		for(int i = 0; i < figures.size(); i++)
		{
			figures.get(i).drown();
		}
		for(int i = 0; i < items.size(); i++)
		{
			removeItem(items.get(i).destroy());
		}
		
		/*collapse() method is called If the capacity is exceeded
		 * it causes all the figures fall into water 
		 * and items to be destroyed.
		 */
	}
}
