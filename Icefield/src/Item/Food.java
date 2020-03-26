package Item;
import Figures.Figure;


public class Food extends Item
{
	public void useItem()
	{
		increaseheatUnit();//increasing the body heat unit of the figure by 1
		System.out.println("The body heat unit of the figure is increased by 1");
		
	}
}
