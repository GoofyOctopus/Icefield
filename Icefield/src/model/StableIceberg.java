package model;

import java.util.List;
/*Erdene*/
public class StableIceberg extends Iceberg{

	public StableIceberg(int x, int y) 
	{ 
		super(x, y);
	}
	@Override
	public int getCapacity() {
		return -1;
	}
	@Override
	public void setCapacity(int capacity) {
		// TODO Auto-generated method stub
	}
}
