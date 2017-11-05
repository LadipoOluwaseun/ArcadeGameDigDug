import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Fruit extends Stuff{
	
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	public Point2D.Double point;
	public Hero hero;
	DigDugWorld world;
	public Rectangle rect;

	public Fruit(DigDugWorld world, Point2D.Double point, Hero hero) {
		super(world, point);
		this.world = world;
		this.point = point;
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
		return this.point;
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
}
