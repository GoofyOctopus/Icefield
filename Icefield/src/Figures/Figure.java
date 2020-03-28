/*
 * Khosoo
 */

package Figures;

import java.util.ArrayList;

import Item.IItem;
import model.Direction;
import model.Iceberg;

	/*
	 * Main abstract class that represents figures.
	 * It contains all necessary attributes and methods of 
	 * figure to function.
	 */

public abstract class Figure{
	boolean isDrowning;
	int roundOfDrowning;
	int bodyHeatUnit;
	boolean isWearingDivingSuit;
	Iceberg iceberg;
	ArrayList<IItem> inventory;
	
	
	public Figure(Iceberg iceberg) {
		this.isDrowning = false;
		this.roundOfDrowning = 0;
		this.isWearingDivingSuit = false;
		this.inventory = new ArrayList<IItem>();
	}
	
	/*
	 * Stepping method for figure which will call the remove method of 
	 * iceberg which its currently on and call the acceot method of 
	 * iceberg which it intends to move to.
	 */
	public void step(Direction d) {
		iceberg.remove(this);
		iceberg.getNeighbor(d).accept(this);
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
		bodyHeatUnit++;
	}
	/*
	 *  Method that decreases snow of iceberg by one unit.
	 */
	public void removeSnow() {
		iceberg.decreaseSnow(1);
	}
	/*
	 *  It checks if that item is currently on that iceberg or not
	 *  and if it is on the iceberg, it removes it from iceberg and
	 *  add it to inventory of figure.
	 */
	public void retrieveItem(IItem i) {
		for(int j=0;j<iceberg.getItems().size();j++) {
			if(i.getClass().equals(iceberg.getItems().get(j).getClass())) {
				iceberg.removeItem(i);
				inventory.add(i);
				break;
			}
		}
	}
	/*
	 * This function tells other classes that it is being helped 
	 * by other figure and calls remove method of that hole and
	 * calls accept method of iceberg, which it is getting helped from.
	 */
	public void help(Iceberg i1) {
		iceberg.remove(this);
		i1.accept(this);
		roundOfDrowning = 0;
	}
	/*
	 * States that figure has started drowning.
	 */
	public void drown() {
		isDrowning = true;
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
}
