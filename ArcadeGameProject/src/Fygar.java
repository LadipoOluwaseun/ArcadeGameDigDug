import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.Random;

//import com.sun.javafx.geom.Rectangle;

public class Fygar extends Enemy{
	
	private boolean fireOut;
	private Line2D.Double fire;
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	private int counter;
	private int counterAtTimeFireStarted;
	private boolean isBreathingFire;
	private int counterAtTimeIceStarted;

//	public Rectangle rect;

	
//	public DigDugEnvironment world;
//	public Point2D.Double point;
//	private static final int WIDTH = 30;
//	private static final int HEIGHT = 30;
	
	public Fygar(DigDugWorld world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		fireOut = false;
		fire = new Line2D.Double(new Point2D.Double(this.center.getX(), this.center.getY()),
				new Point2D.Double(this.center.getX(), this.center.getY()));
		this.counter = 0;
		this.counterAtTimeFireStarted = 0;
		this.isBreathingFire = false;
		this.counterAtTimeIceStarted = 0;
		
		
//		this.rect = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);

//		this.point = point;
		// TODO Auto-generated constructor stub.
	}

//	@Override
//	public Rectangle getShape() {
//		return this.rect;
//	}
	
	@Override
	public Color getColor() {
		if (super.isIce) {
			int timeElapsed = this.counter-this.counterAtTimeIceStarted;
			if (timeElapsed<=255) {
				
			
			return new Color(255-timeElapsed, 255-timeElapsed, 255-timeElapsed);
			}
			super.isIce = false;
			
		}
		this.counterAtTimeIceStarted = this.counter;
		if(this.isGhost){
			return Color.pink;
		}
		// TODO Auto-generated method stub.
		return Color.GREEN;
	}
	

	
	public void handleBreatheFire() {
		counter++;
		Random rand = new Random();		
		if (this.isBreathingFire && this.counter-this.counterAtTimeFireStarted<20) {
			this.breatheFire();
		}
		else if (this.counter-this.counterAtTimeFireStarted>=20) {
			this.isBreathingFire = false;
			this.counterAtTimeFireStarted = this.counter;
		} else
			
		if(rand.nextInt(1000) < 3) {
			this.breatheFire();
		} else {
			this.counterAtTimeFireStarted = this.counter;
		}
	}
	
	
	public Line2D.Double breatheFire() {
		this.isBreathingFire = true;
		if (this.fire.getX2()-this.fire.getX1()==0 && this.fire.getY2()-this.fire.getY1()==0) {
			
		
		if (this.lastDirection == 'u') {

			this.fire = new Line2D.Double(new Point2D.Double(this.fire.getX1(), this.fire.getY1()),
					new Point2D.Double(this.fire.getX2(), this.fire.getY2() - HEIGHT*2));

		}
		if (this.lastDirection == 'd') {
			this.fire = new Line2D.Double(new Point2D.Double(this.fire.getX1(), this.fire.getY1()),
					new Point2D.Double(this.fire.getX2(), this.fire.getY2() + HEIGHT*2));

		}
		if (this.lastDirection == 'l') {
			this.fire = new Line2D.Double(new Point2D.Double(this.fire.getX1(), this.fire.getY1()),
					new Point2D.Double(this.fire.getX2() - WIDTH*2, this.fire.getY2()));

		}
		if (this.lastDirection == 'r') {
			this.fire = new Line2D.Double(new Point2D.Double(this.fire.getX1(), this.fire.getY1()),
					new Point2D.Double(this.fire.getX2() + WIDTH*2, this.fire.getY2()));
		}}

		return this.fire;

	}
	
	public Line2D.Double retractFire() {
		this.fire = new Line2D.Double(new Point2D.Double(this.center.getX(), this.center.getY()),
				new Point2D.Double(this.center.getX(), this.center.getY()));
		return this.fire;
	}
	
	public Line2D.Double getFire() {
		return this.fire;
	}

//	@Override
//	public Rectangle getShape() {
//		return new Rectangle((int) this.point.getX(), (int) this.point.getY(), WIDTH, HEIGHT);
//	}

//	@Override
//	public Point2D.Double getCenterPoint() {
//		// TODO Auto-generated method stub.
//		System.out.println(new Point2D.Double(this.point.getX() + WIDTH/2, this.point.getY() + HEIGHT / 2));
//		return new Point2D.Double(this.point.getX() + WIDTH/2, this.point.getY() + HEIGHT / 2);
//	}

	@Override
	public void updatePosition() {
//		System.out.println("fire");
		this.fire = new Line2D.Double(this.center.getX(), this.center.getY(), this.center.getX(), this.center.getY());
		
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public double getscore() {
		// TODO Auto-generated method stub.
		return 1000;
	}


	public Double[] getBorder() {
		// TODO Auto-generated method stub.
		return null;
	}

}