/*
 *  Khosoo
 */
package Figures;

import model.Direction;
import model.Iceberg;

public class Eskimo extends Figure {

	public Eskimo(Iceberg iceberg) {
		super(iceberg);
		bodyHeatUnit = 5;
	}

	@Override
	public int useSkill(Direction d) {
		throw new Exception("Eskimo can not know capacity of iceberg!")
	}

	@Override
	public void useSkill() {
		iceberg.sethasIgloos(true);
	}
}
