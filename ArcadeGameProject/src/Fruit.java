import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class Fruit extends Stuff{
	
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	public static final Point2D.Double point = new Point2D.Double(210, 120);
	public Hero hero;
	DigDugWorld world;
	public Rectangle rect;

	public Fruit(DigDugWorld world, Hero hero) {
		super(world, new Point2D.Double(210, 120));
		this.world = world;
//		this.point = point;
		this.hero = hero;
		this.rect = new Rectangle((int) point.getX(), (int) point.getY(), WIDTH, HEIGHT);
	}

	@Override
	public Color getColor() {
		return Color.RED;
	}

	@Override
	public Rectangle getShape() {
		return this.rect;
	}

	@Override
	public Point2D getCenterPoint() {
		return new Point2D.Double(this.point.getX() + WIDTH/2, this.point.getY() + HEIGHT/2);
	}

	@Override
	public void updatePosition() {
//		if(this.getShape().intersects(this.hero.getShape())) {
//			this.die();
//		}
	}

	@Override
	public void updateSize() {
		//
	}

	@Override
	public double getscore() {
		return 400;
	}
	
//	public void appear() {
//		
//	}
	
}
