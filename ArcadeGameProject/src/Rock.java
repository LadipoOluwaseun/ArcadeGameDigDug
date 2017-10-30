import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import com.sun.javafx.geom.Rectangle;

public class Rock extends Stuff{
	
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	public Point2D.Double point;
	public Hero hero;
	private boolean intercepts;
	private Point2D.Double bottomCorner;
	
	public Rock(DigDugEnvironment world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.point = point;
		this.hero = hero;
		this.intercepts = false;
		this.bottomCorner = new Point2D.Double(point.getX() + WIDTH,point.getY() + HEIGHT);
		
	}

	@Override
	public Color getColor() {
		return Color.gray;
	}

	@Override
	public Rectangle getShape() {
		return new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);
	}

	public Point2D.Double getCornerPoint() {
		return this.point;
	}

	@Override
	public void updatePosition() {
		if(intercepts(hero) && hero.getCorner() == this.bottomCorner) {
			while(!intercepts) {
				this.fall();
		}
	}
	
	public void fall() {
		double fallValue = -5;
	}

	@Override
	public void updateSize() {
		// size of rock does not change
		
	}

	@Override
	public double getscore() {
		// TODO Auto-generated method stub.
		return 0;
	}
	
	public void intercepts(Stuff stuff) {
		if(stuff == hero) {
			hero.die();
		}
		if(stuff.getColor() == Color.orange) {
			this.intercepts = true;
		}
		if(stuff.getColor() == Color.red) {
			stuff.die();
		}
		if(stuff.getColor() == Color.blue) {
			stuff.die();
		}
		
	}

	@Override
	public Point2D getCenterPoint() {
		// TODO Auto-generated method stub.
		return null;
	}

}
