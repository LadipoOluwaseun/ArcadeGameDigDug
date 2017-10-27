import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * 
 * creates the dirt for the DigDugWorld
 *
 * @author smithea2.
 *         Created Oct 27, 2017.
 */

public class Dirt extends Stuff{

	public Shape shape;
	public Point2D.Double point;
	
	
	public Dirt(DigDugEnvironment world, Point2D.Double point) {
		super(world, point);
		this.point = point;
	}

	@Override
	public Shape getShape() {
		return this.shape;
	}

	@Override
	public Point2D getCenterPoint() {
		return this.point;
	}

	public void updatePosition() {
		//doesn't update (it is dirt)
	}

	public void updateSize() {
		// does not update (it is dirt)
		
	}

	@Override
	public double getscore() {
		return 0;
	}

	@Override
	public Color getColor() {
		return Color.orange;
	}

}
