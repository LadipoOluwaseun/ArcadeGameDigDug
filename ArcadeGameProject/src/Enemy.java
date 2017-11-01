import java.awt.Rectangle;
import java.awt.geom.Point2D;

/**
 * TODO Put here a description of what this class does.
 *
 * @author calarejf.
 *         Created Oct 31, 2017.
 */
public abstract class Enemy extends Stuff {
	public Hero hero;
	protected static final int WIDTH = 30;
	protected static final int HEIGHT = 30;
	protected DigDugEnvironment world;
	public Point2D.Double point;
	protected boolean intercepts;
	protected double amountExpanded;
	protected static final int AMOUNT_TO_EXPAND = 1;
	public Rectangle rect;
	
//	public Rectangle rect;

	
	public Enemy(DigDugEnvironment world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.world = world;
		this.point = new Point2D.Double(point.getX(), point.getY());
		this.intercepts = false;
		this.rect = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);
		

//		this.rect = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);

	}
	
	public void expand(){
		this.rect.grow(AMOUNT_TO_EXPAND, AMOUNT_TO_EXPAND);
	}
	
	@Override
	public Rectangle getShape() {
		return this.rect;
	}
	
//	public Rectangle getShape(){
//		return this.
//	}
}
