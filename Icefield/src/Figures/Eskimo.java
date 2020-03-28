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

	@Override
	public int useSkill(Direction d) throws Exception {
		throw new Exception("Eskimo can not know capacity of iceberg!");
	}

	@Override
	public void useSkill() {
		System.out.println("useSkill() method is called");
		iceberg.sethasIgloos(true);
	}
}
