import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;


public class Mud extends Stuff {

	private DigDugWorld world;
	private Point2D.Double point;
	private Hero hero;
	private final static int WIDTH = 30;
	private final static int HEIGHT = 30;
	private Rectangle rect;
	
	public Mud(DigDugWorld world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.world = world;
		this.hero = hero;
		this.point = point;
		this.rect = new Rectangle((int) this.point.getX(),(int) this.point.getY(), WIDTH, HEIGHT);
	}

	@Override
	public Color getColor() {
		return Color.DARK_GRAY;
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
		// it doesn't move
		
	}

	@Override
	public void updateSize() {
		//it doesn't change size
		
	}

	@Override
	public double getscore() {
		// there is no score related to mud
		return 0;
	}

}
