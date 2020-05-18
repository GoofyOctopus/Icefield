/*
 * Khosoo
 */

package Figures;

import java.util.ArrayList;

import Item.Charge;
import Item.Flare;
import Item.Food;
import Item.Gun;
import Item.IItem;
import Item.Rope;
import model.Direction;
import model.Iceberg;

	/*
	 * Main abstract class that represents figures.
	 * It contains all necessary attributes and methods of 
	 * figure to function.
	 */

public abstract class Figure{
	public boolean isDrowning;
	public int roundOfDrowning;
	public int bodyHeatUnit;
	public int currentRound;
	public boolean isWearingDivingSuit;
	String name;
	Iceberg iceberg;
	public ArrayList<IItem> inventory;
	/*
	 * Constructor for Fifgure class.
	 * When it is initialized, it will have no item
	 * in its inventory.
	 */
	public Figure(String name) {
		this.isDrowning = false;
		this.currentRound = 0;
		this.isWearingDivingSuit = false;
		this.inventory = new ArrayList<IItem>();
		this.name = name;
		//****add items here for testing purposes****
	}
	/*
	 * Stepping method for figure which will call the remove method of 
	 * iceberg which its currently on and call the accept method of 
	 * iceberg which it intends to move to.
	 */
	
	public void step(Direction d) {
		if(this.isDrowning) return;
		Iceberg ic = iceberg.getNeighbor(d);
		iceberg.remove(this);
		ic.accept(this);
	}
	/*
	public void die() {
		Game.endGame();        Not needed because endgame method is being called from game itself but not from figure.
	}
	*/
	
	/*
	 * Decreases body heat unit of figure, if it gets caught by blizzard.
	 */
	public void decreaseHeatUnit() {
		bodyHeatUnit--;
	}
	/*
	 * Increase body heat unit of figure, if it eats food.
	 */
	public void increaseHeatUnit() {
		System.out.println("increasing heat unit");
		if(bodyHeatUnit<6)
			bodyHeatUnit++;
	}
	/*
	 *  Method that decreases snow of iceberg by one unit.
	 */
	public void removeSnow(int x) {
		iceberg.decreaseSnow(x);
	}
	public void removeItem(IItem i) {
		inventory.remove(i);
	}
	/*
	 *  It checks if that item is currently on that iceberg or not
	 *  and if the figure has this item in its inventory.
	 *  if those conditions are passed, it removes it from iceberg and
	 *  add it to inventory of figure.
	 */
	public void retrieveItem() {
		for(int j=0; j<iceberg.getItems().size(); j++) {
			inventory.add(iceberg.getItems().get(j));
			iceberg.getItems().get(j).setFigure(this);
		}
		iceberg.retrievedAllItem();
	}
	/*
	 * This function tells other classes that it is being helped 
	 * by other figure and calls remove method of that hole and
	 * calls accept method of iceberg, which it is getting helped from.
	 */
	public void help(Iceberg i1) {
		iceberg.remove(this);
		isDrowning = false;
		i1.accept(this);
		roundOfDrowning = 0;
	}
	/*
	 * States that figure has started drowning.
	 */
	public void drown() {
		if(!isWearingDivingSuit) {
			isDrowning = true;
			this.setRoundOfDrowning(currentRound);
		}
	}
	/*
	 * It is special skill method of figures.
	 * There are two types of this method as it does
	 * different moves according to which type
	 * of figures it is.
	 */
	public abstract int useSkill(Direction d) throws Exception;
	public abstract void useSkill() throws Exception;
	/* 
	 * Getter and setter methods for attributes as it is needed in other classes.
	 */
	public String getName() {
		return name;
	}
	public int getBodyHeatUnit() {
		return bodyHeatUnit;
	}
	public void setBodyHeatUnit(int bodyHeatUnit) {
		this.bodyHeatUnit = bodyHeatUnit;
	}
	public ArrayList<IItem> getInventory() {
		return inventory;
	}
	public void setIceberg(Iceberg i) {
		iceberg = i;
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
	public void addToInventory(IItem item) {
		this.inventory.add(item);
	}
	public void setCurrentRound(int num) {
		this.currentRound = num;
	}
}
