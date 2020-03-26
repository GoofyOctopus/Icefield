package model;
import java.util.List;

import Figures.Figure;
public class UnstableIceberg extends Iceberg{
	
	public UnstableIceberg(List<Iceberg> neighbouringIcebergs) {
		super(neighbouringIcebergs);
		// TODO Auto-generated constructor stub
	}
	private int capacity;
	
	public int getCapacity() {
		return capacity;
	}
	public void accept(Figure f) {
		
	}
	public void collapse()
	{
		
	}
}
