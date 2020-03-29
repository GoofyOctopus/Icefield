/*
 *  khosoo
 */

package Figures;

import model.Direction;

public class Eskimo extends Figure {

	public Eskimo() {
		super();
		bodyHeatUnit = 5;
	}
	/*
	 * If Eskimo use this type of useSkill method,
	 * this method will throw exception as it is not possible 
	 * for eskimo to know capacity of neighboring iceberg.
	 */
	@Override
	public int useSkill(Direction d) throws Exception {
		throw new Exception("Eskimo can not know capacity of iceberg!");
	}
	/*
	 * Eskimo can build igloo on iceberg as this method
	 * calls sethasIgloos method if uceberg.
	 */
	@Override
	public void useSkill() {
		System.out.println("useSkill() method is called");
		iceberg.sethasIgloos(true);
	}
}
