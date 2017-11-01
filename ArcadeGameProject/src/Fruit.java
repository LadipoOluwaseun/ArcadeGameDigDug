import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Fruit extends Stuff{

	public Fruit(DigDugEnvironment world, Double point) {
		super(world, point);
		
	}

	@Override
	public Color getColor() {
		return null;
	}

	@Override
	public Rectangle getShape() {
		return null;
	}

	@Override
	public Point2D getCenterPoint() {
		return null;
	}

	@Override
	public void updatePosition() {
	}

	@Override
	public void updateSize() {
	}

	@Override
	public double getscore() {
		return 400;
	}

	@Override
	public Double[] getBorder() {
		return null;
	}

}
