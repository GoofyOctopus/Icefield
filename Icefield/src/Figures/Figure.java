package Figures;

import java.util.ArrayList;

import Item.IItem;
import model.Direction;
import model.Iceberg;

public abstract class Figure {
	boolean isDrowning;
	int roundOfDrowning;
	int bodyHeatUnit;
	boolean isWearingDivingSuit;
	Iceberg iceberg;
	Iceberg neighboringIceberg;
	ArrayList<IItem> inventory;
	
	public Figure(Iceberg iceberg) {
		this.isDrowning = false;
		this.roundOfDrowning = 0;
		this.isWearingDivingSuit = false;
		this.iceberg = iceberg;
		this.inventory = new ArrayList<IItem>();
	}
	void step(Direction d) {
		iceberg.remove(this);
		iceberg.getNeighbor(d).accept(this);
	}
	
	void die() {
		
	}
	
	void decreaseHeatUnit() {
		bodyHeatUnit--;
	}
	
	void increaseHeatUnit() {
		bodyHeatUnit++;
	}
	
	void removeSnow() {
		iceberg.decreaseSnow(1);
	}
	
	void retrieveItem(IItem i) {
		
	}
	
	void help(Iceberg i1) {
		iceberg.remove(this);
		i1.accept(this);
	}
	
	void drown() {
		isDrowning = true;
	}
	
}
