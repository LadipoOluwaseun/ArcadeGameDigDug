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

public class Ice extends Stuff{

	public Rectangle rect;
	public Point2D.Double point;
	public final static int WIDTH = 30;
	public final static int HEIGHT = 30;
	public Hero hero;
	private double score;
	public boolean isInactive;
	
	
	public Ice(DigDugEnvironment world, Point2D.Double point, Hero heroman) {
		super(world, point, heroman);
		this.point = point;
//		this.WIDTH = 30;
//		this.HEIGHT = 30;
		this.rect = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);
		this.hero = heroman;
		this.score = 20;
		this.isInactive = false;
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
		return score;
	}
	
	public void setScore() {
		score = 0;
	}

	@Override
	public Color getColor() {
		return Color.yellow;
	}
	
	@Override
	public void die() {
		isInactive = true;
		if(count == 0){
			world.removeStuff(this);
			world.updateScore(this.getscore());
			count++;
		}	
	}

	public Double[] getBorder() {
		// TODO Auto-generated method stub.
		return null;
	}

}
