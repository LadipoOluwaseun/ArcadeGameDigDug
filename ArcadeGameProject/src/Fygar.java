import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

//import com.sun.javafx.geom.Rectangle;

public class Fygar extends Enemy{
	
//	public DigDugEnvironment world;
//	public Point2D.Double point;
//	private static final int WIDTH = 30;
//	private static final int HEIGHT = 30;
	
	public Fygar(DigDugEnvironment world, Point2D.Double point, Hero heroman) {
		super(world, point, heroman);
//		this.point = point;
		// TODO Auto-generated constructor stub.
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return Color.GREEN;
	}

	@Override
	public Rectangle getShape() {
		return new Rectangle((int) this.point.getX(), (int) this.point.getY(), super.WIDTH, super.HEIGHT);
	}

	@Override
	public Point2D getCenterPoint() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.
		
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
