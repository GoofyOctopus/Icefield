package Figures;

import model.Direction;
import model.Iceberg;

public class PolarExplorer extends Figure{

	public PolarExplorer(Iceberg iceberg) {
		super(iceberg);
		bodyHeatUnit = 4;
	}

	@Override
	public int useSkill(Direction d) {
		return iceberg.getNeighbor(d).getCapacity();
	}

	@Override
	public void useSkill() throws Exception {
		throw new Exception("Polar explorer can not build igloos");
	}	
}
