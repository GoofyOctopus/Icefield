/*
 *  Khosoo
 */
package Figures;

import model.Direction;
import model.UnstableIceberg;

public class PolarExplorer extends Figure{

	public PolarExplorer() {
		super();
		System.out.println("Default constructor of polar explorer is called");
		bodyHeatUnit = 4;
	}
	/*
	 * Polar explorer can know capacity of iceberg,
	 * in given direction. It calls getNeighbor 
	 * method of iceberg two know its neighboring
	 * iceberg and checks if it is unstable or not.
	 * If it is unstable iceberg, it gets its 
	 * capacity by calling getCapacity method
	 */
	@Override
	public int useSkill(Direction d) {
		System.out.println("useSkill(Direction) method is called");
		if(iceberg.getNeighbor(d) instanceof UnstableIceberg) {
			return ((UnstableIceberg)iceberg).getCapacity();
		}
		return 0;
	}
	/*
	 * Polar explorer can not build igloo on iceberg.
	 * This method throws exception if explorer calls this 
	 * method
	 */
	@Override
	public void useSkill() throws Exception {
		throw new Exception("Polar explorer can not build igloo!");
	}	
}
