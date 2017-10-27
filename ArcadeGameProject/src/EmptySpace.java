import java.awt.Color;
import java.awt.geom.Point2D;

import com.sun.javafx.geom.Rectangle;

public class EmptySpace extends Stuff{

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param world
	 * @param point
	 */
	
	public Rectangle shape;
	public Point2D.Double point;
	public int WIDTH;
	public int HEIGHT;
	
	
	public EmptySpace(DigDugEnvironment world, Point2D.Double point) {
		super(world, point);
		this.point = point;
		this.WIDTH = 30;
		this.HEIGHT = 30;
		this.shape = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);
		}

	@Override
	public Rectangle getShape() {
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
		return Color.black;
	}



}
