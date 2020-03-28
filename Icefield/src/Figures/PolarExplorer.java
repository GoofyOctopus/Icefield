/*
 *  Khosoo
 */
package Figures;

import model.Direction;
import model.Iceberg;
import model.UnstableIceberg;

public class PolarExplorer extends Figure{

	public PolarExplorer(Iceberg iceberg) {
		super();
		bodyHeatUnit = 4;
	}

	@Override
	public int useSkill(Direction d) {
		System.out.println("useSkill(Direction) method is called");
		if(iceberg.getNeighbor(d) instanceof UnstableIceberg) {
			return ((UnstableIceberg)iceberg).getCapacity();
		}
		return 0;
	}

	@Override
	public void useSkill() throws Exception {
		throw new Exception("Polar explorer can not build igloo!");
	}	
}
