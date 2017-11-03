import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

//import com.sun.javafx.geom.Rectangle;

public class Rock extends Stuff{
	
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	public Point2D.Double point;
	public Hero hero;
	private boolean hitDirt;
	private Point2D.Double bottomCorner;
	public Rectangle rect;
	
	public Rock(DigDugEnvironment world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.point = point;
		this.hero = hero;
		this.hitDirt = false;
		this.bottomCorner = new Point2D.Double(point.getX() + WIDTH,point.getY() + HEIGHT);
		this.rect = new Rectangle((int) point.getX(), (int) point.getY(), WIDTH, HEIGHT);
		
	}

	@Override
	public Color getColor() {
		return Color.gray;
	}

	@Override
	public Rectangle getShape() {
		return this.rect;
	}

	public Point2D.Double getCornerPoint() {
		return this.point;
	}
	
	@Override
	public void updatePosition() {
//		if(intercepts(hero) && hero.getCorner() == this.bottomCorner) {
//			while(!this.hitDirt) {
//				this.fall();
//			}s
//		}
	}
	
	public boolean falling() {
		boolean fallValue = true;
		return fallValue;
	}

	private void hitDirt() {
		this.hitDirt =true;
	}

	@Override
	public void updateSize() {
		// size of rock does not change (for now)
	}

	@Override
	public double getscore() {
		// TODO Auto-generated method stub.
		return 0;
	}
	
	@Override
	public Point2D.Double[] getBorder() {
//		Point2D.Double[] borderPoints = new Point2D.Double[4];
//		borderPoints[0] = this.getCornerPoint();
//		borderPoints[1] = new Point2D.Double(this.point.getX(), this.point.getY() + HEIGHT);
//		borderPoints[2] = this.bottomCorner;
//		borderPoints[3] = new Point2D.Double(this.point.getX() + WIDTH, this.point.getY());
//		return borderPoints;
		return null;
	}
//	
	public void intercepts(Stuff stuff) {
		if(this.getShape().getMaxY() == stuff.getShape().getMinY()) {
			if(stuff == this.hero) {
				this.hero.die();
			}
			if(stuff.getColor() == Color.orange) {
				this.hitDirt();
				this.point = new Point2D.Double(stuff.getCenterPoint().getX() - WIDTH/2, stuff.getCenterPoint().getY() - HEIGHT*3/2);
				this.rect = new Rectangle((int) this.point.getX(), (int) this.point.getY(), WIDTH, HEIGHT);
			}
			if(stuff.getColor() == Color.red) {
				stuff.die();
			}
			if(stuff.getColor() == Color.blue) {
				stuff.die();
			}
		}		
	}

	@Override
	public Point2D getCenterPoint() {
		return new Point2D.Double(this.point.getX() + WIDTH/2, this.point.getY() + HEIGHT/2);
	}

}
