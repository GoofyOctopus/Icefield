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
		this.iceberg = iceberg;
		this.inventory = new ArrayList<IItem>();
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
	
	public abstract int useSkill();
}
