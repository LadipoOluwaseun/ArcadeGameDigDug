import java.awt.Color;
import java.awt.geom.Point2D;

//import com.sun.javafx.geom.Rectangle;

public class Pookas extends Enemy{
private int counterAtTimeIceStarted;

//	public Rectangle rect;

	
//	public Hero hero;
//	private static final int WIDTH = 30;
//	private static final int HEIGHT = 30;
//	private DigDugEnvironment world;
//	public Point2D.Double point;
//	private boolean intercepts;
	
	
	public Pookas(DigDugWorld world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.counterAtTimeIceStarted = 0;
//		this.rect = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);
//		this.world = world;
//		this.point = new Point2D.Double(point.getX(), point.getY());
//		this.intercepts = false;
	}

	@Override
	public Color getColor() {
		if (super.isIce) {
			int timeElapsed = this.counter-this.counterAtTimeIceStarted;
			if (timeElapsed<=255) {
				
			
			return new Color(255-timeElapsed, 255-timeElapsed, 255-timeElapsed);
			}
			super.isIce = false;
			this.lastDirection = 'u';
		}
		this.counterAtTimeIceStarted = this.counter;

		if (this.isGhost) {
			return Color.pink;
		}
		return Color.blue;
	}

//	@Override
//	public Rectangle getShape() {
//		return new Rectangle((int) this.point.getX(),(int) this.point.getY(), WIDTH, HEIGHT);
//	}
	
//	@Override
//	public Rectangle getShape() {
//		return this.rect;
//	}

//	@Override
//	public Point2D.Double getCenterPoint() {
//		return null;
//	}
	
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
		return 1000;
	}

}
