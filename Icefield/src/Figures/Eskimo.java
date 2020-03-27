package Figures;

import model.Direction;
import model.Iceberg;

public class Eskimo extends Figure {

	public Eskimo(Iceberg iceberg) {
		super(iceberg);
		bodyHeatUnit = 5;
	}

	@Override
	int useSkill(Direction d) {
		return 0;
	}
}
