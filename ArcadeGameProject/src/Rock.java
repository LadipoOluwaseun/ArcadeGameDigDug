import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

//import com.sun.webkit.Timer;

//import javax.swing.Timer;



//import com.sun.javafx.geom.Rectangle;

public class Rock extends Stuff{
	
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	public Point2D.Double point;
	public Hero hero;
	private boolean hitDirt;
//	private Point2D.Double bottomCorner;
	public Rectangle rect;
	boolean falling;
	DigDugWorld world;
//	public int counter;
	
	public Rock(DigDugWorld world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.world = world;
		this.point = point;
		this.hero = hero;
		this.hitDirt = false;
//		this.counter = 0;
//		this.bottomCorner = new Point2D.Double(point.getX() + WIDTH,point.getY() + HEIGHT);
		this.rect = new Rectangle((int) point.getX(), (int) point.getY(), WIDTH, HEIGHT);
		this.falling = false;
	}

//	public void iterateCounter() {
//		this.counter++;
//		// System.out.println(this.counter);
//	}
//
//	public double getCounter() {
//		return this.counter;
//	}
//
//	public void resetCounter() {
//		this.counter = 0;
//	}
	
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
//		System.out.println("falling");
		this.falling = true;
		return this.falling;
	}

//	public void hitDirt() {
//		for(Dirt d: this.world.getDirtArray()) {
//			if(this.getShape().getMaxY() == d.getShape().getMinY() && 
//					this.getShape().getMaxX() == d.getShape().getMaxX() &&
//					this.getShape().getMinX() == d.getShape().getMinX()) {
//				System.out.println(d.getShape().getMaxX() + " " + d.getShape().getMinX() + " " + d.getShape().getMinY());
//				System.out.println(this.getShape().getMaxX() + " " + this.getShape().getMinX() + " " + this.getShape().getMaxY() + "rock");
//				this.hitDirt =true;
//			}			
//		}
//		
//	}

	@Override
	public void updateSize() {
		// size of rock does not change (for now)
	}

	@Override
	public double getscore() {
		// TODO Auto-generated method stub.
		return 0;
	}
	
	public void fall() {
//		System.out.println("falling");
		while(this.falling) {
//			if (this.getCounter()%10==0) {
			for(Dirt d: this.world.getDirtArray()) {
				if(this.getShape().getMaxY() == d.getShape().getMinY() &&
						this.getShape().getMinX() == d.getShape().getMinX() &&
						this.getShape().getMaxX() == d.getShape().getMaxX()) {
					System.out.println("ouch");
//					System.out.println(this.hero.getMax);
					this.falling = false;
					return;
				}
			}
			for(Enemy e: this.world.getEnemyArray()) {
				if(this.getShape().intersects(e.getShape())) {
					e.die();
				}
			}
			if(this.hero.getShape().intersects(this.getShape())) {
				this.hero.die();
			}
			if(this.point.getY() > 450) {
				this.falling = false;
				return;
			}
//			System.out.println("please Fall");
			this.point = new Point2D.Double(this.point.getX(), this.point.getY() + 1);
			this.rect = new Rectangle((int) this.point.getX(), (int) this.point.getY(), WIDTH, HEIGHT);
//			}
		}
	}
	

//	public Point2D.Double[] getBorder() {
////		Point2D.Double[] borderPoints = new Point2D.Double[4];
////		borderPoints[0] = this.getCornerPoint();
////		borderPoints[1] = new Point2D.Double(this.point.getX(), this.point.getY() + HEIGHT);
////		borderPoints[2] = this.bottomCorner;
////		borderPoints[3] = new Point2D.Double(this.point.getX() + WIDTH, this.point.getY());
////		return borderPoints;
//		return null;
//	}
//	
//	public void intercepts(Stuff stuff) {
//		if(this.getShape().getMaxY() == stuff.getShape().getMinY()) {
//			if(stuff == this.hero) {
//				this.hero.die();
//			}
//			if(stuff.getColor() == Color.orange) {
//				this.hitDirt();
//				this.point = new Point2D.Double(stuff.getCenterPoint().getX() - WIDTH/2, stuff.getCenterPoint().getY() - HEIGHT*3/2);
//				this.rect = new Rectangle((int) this.point.getX(), (int) this.point.getY(), WIDTH, HEIGHT);
//			}
//			if(stuff.getColor() == Color.red) {
//				stuff.die();
//			}
//			if(stuff.getColor() == Color.blue) {
//				stuff.die();
//			}
//		}		
//	}

	@Override
	public Point2D getCenterPoint() {
		return new Point2D.Double(this.point.getX() + WIDTH/2, this.point.getY() + HEIGHT/2);
	}

}
