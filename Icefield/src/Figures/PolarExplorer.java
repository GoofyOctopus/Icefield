package Figures;

import model.Direction;
import model.Iceberg;

public class PolarExplorer extends Figure{

	public PolarExplorer(Iceberg iceberg) {
		super(iceberg);
		bodyHeatUnit = 4;
	}

	@Override
	int useSkill(Direction d) {
		return 0; //////////////////////////////
	}
	

}
