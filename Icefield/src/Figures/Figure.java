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
	ArrayList<IItem> inventory;
	
	public int getBodyHeatUnit() {
		return bodyHeatUnit;
	}
	public void setBodyHeatUnit(int bodyHeatUnit) {
		this.bodyHeatUnit = bodyHeatUnit;
	}
	public ArrayList<IItem> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<IItem> inventory) {
		this.inventory = inventory;
	}
	public Iceberg getIceberg() {
		return iceberg;
	}
	public void setDrowning(boolean isDrowning) {
		this.isDrowning = isDrowning;
	}
	public void setRoundOfDrowning(int roundOfDrowning) {
		this.roundOfDrowning = roundOfDrowning;
	}
	public void setWearingDivingSuit(boolean isWearingDivingSuit) {
		this.isWearingDivingSuit = isWearingDivingSuit;
	}
	public boolean isDrowning() {
		return isDrowning;
	}
	public int getRoundOfDrowning() {
		return roundOfDrowning;
	}
	public boolean isWearingDivingSuit() {
		return isWearingDivingSuit;
	}
	
	
	
	
	public Figure(Iceberg iceberg) {
		this.isDrowning = false;
		this.roundOfDrowning = 0;
		this.isWearingDivingSuit = false;
		this.inventory = new ArrayList<IItem>();
	}
	
	public void setIceberg(Iceberg i) {
		iceberg = i;
	}
	
	public void step(Direction d) {
		iceberg.remove(this);
		iceberg.getNeighbor(d).accept(this);
	}
	/*
	public void die() {
		Game.endGame();        Not needed because endgame is being called from game itself but not from figure.
	}
	*/
	public void decreaseHeatUnit() {
		bodyHeatUnit--;
	}
	
	public void increaseHeatUnit() {
		bodyHeatUnit++;
	}
	
	public void removeSnow() {
		iceberg.decreaseSnow(1);
	}
	
	public void retrieveItem(IItem i) {
		////
	}
	
	public void help(Iceberg i1) {
		iceberg.remove(this);
		i1.accept(this);
		roundOfDrowning = 0;
	}
	
	public void drown() {
		isDrowning = true; // Have to make endgame more clear!!!!!!!!!!!!!!
	}
	
}
