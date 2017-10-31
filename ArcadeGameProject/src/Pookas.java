import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

//import com.sun.javafx.geom.Rectangle;

public class Pookas extends Stuff{
	
	public Hero hero;
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	private DigDugEnvironment world;
	public Point2D.Double point;
	private boolean intercepts;
	
	
	public Pookas(DigDugEnvironment world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.world = world;
		this.point = new Point2D.Double(point.getX(), point.getY());
		this.intercepts = false;
	}

	@Override
	public Color getColor() {
		return Color.blue;
	}

	@Override
	public Rectangle getShape() {
		return new Rectangle((int) this.point.getX(),(int) this.point.getY(), WIDTH, HEIGHT);
	}

	@Override
	public Point2D getCenterPoint() {
		return null;
	}
	
	public Point2D.Double getCornerPoint() {
		return this.point;
	}

	@Override
	public void updatePosition() {
		//
		
	}

	@Override
	public void updateSize() {
//		if(intercepts(hero.cord)) {
//			this.
//		}
		
	}

	@Override
	public double getscore() {
		// TODO Auto-generated method stub.
		return 0;
	}

	public Double[] getBorder() {
		// TODO Auto-generated method stub.
		return null;
	}

}
