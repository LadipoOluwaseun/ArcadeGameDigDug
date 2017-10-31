import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;


//import com.sun.javafx.geom.Rectangle;

/**
 * 
 * creates the dirt for the DigDugWorld
 *
 * @author smithea2.
 *         Created Oct 27, 2017.
 */

public class Dirt extends Stuff{

	public Rectangle rect;
	public Point2D.Double point;
	public int WIDTH;
	public int HEIGHT;
	public Hero hero;
	
	
	public Dirt(DigDugEnvironment world, Point2D.Double point, Hero heroman) {
		super(world, point, heroman);
		this.point = point;
		this.WIDTH = 30;
		this.HEIGHT = 30;
		this.rect = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);
		this.hero = heroman;
		}

	@Override
	public Rectangle getShape() {
		return this.rect;
	}

	@Override
	public Point2D getCenterPoint() {
		return this.point;
	}

	@Override
	public void updatePosition() {
		//doesn't update (it is dirt)
	}

	@Override
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

	public Double[] getBorder() {
		// TODO Auto-generated method stub.
		return null;
	}

}
