import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

//import com.sun.javafx.geom.Rectangle;

/**
 * 
 * creates and implements methods of the hero in DigDugWorld.
 *
 * @author smithea2. Created Oct 26, 2017.
 */

public class Hero extends Stuff{

	public Point2D.Double point;
	// public int y;
	// public int x;
	public Rectangle shape;
	public Point2D.Double center;
	// private Dimension size;
	private Color color;
	public int score;
	public int changeX;
	public int changeY;
	public Line2D.Double cord;
	// public Line2D.Double DEFAULT_CORD;
//	public boolean cordExtended;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
//	private static final int TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS = 100;
	char lastDirection;
	int lastXVelocity;
	int lastYVelocity;
	DigDugWorld world;

	public Hero(DigDugWorld world, Point2D.Double point) {
		super(world, point);
		this.point = point;
		this.changeX = 0;
		this.changeY = 0;
//		this.cordExtended = false;
		this.color = Color.CYAN;
//		this.WIDTH = 30;
//		this.HEIGHT = 30;
//		this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS = 100;
		this.center = new Point2D.Double(point.getX() + WIDTH / 2, point.getY() + HEIGHT / 2);
		this.shape = new Rectangle((int) point.getX(), (int) point.getY(), WIDTH, HEIGHT);
		this.cord = new Line2D.Double(new Point2D.Double(this.center.getX(), this.center.getY()),
				new Point2D.Double(this.center.getX(), this.center.getY()));
		System.out.println(this.point);
		this.world = world;
//		System.out.println("new Hero");
		// this.cord = this.DEFAULT_CORD;

		// System.out.println("i'm a hero!");
	}

	// public void moveUp() {
	// System.out.println("watch me move up!");
	// this.changeY = 5;
	// this.lastDirection = 'u';
	// }
	//
	// public void moveDown() {
	// System.out.println("watch me move down!");
	// this.changeY = -5;
	// this.lastDirection = 'd';
	// }
	//
	// public void moveLeft() {
	// System.out.println("watch me move left!");
	// this.changeX = -5;
	// this.lastDirection = 'l';
	// updatePosition();
	// }

	// public void moveRight() {
	// System.out.println("watch me move right!");
	// this.changeX = 5;
	// this.lastDirection = 'r';
	// updatePosition();
	// }

	@Override
	public Rectangle getShape() {
		this.shape = new Rectangle((int) this.point.getX(), (int) this.point.getY(), WIDTH, HEIGHT);
//		System.out.println(rect.);
		return this.shape;
	}

	@Override
	public Point2D getCenterPoint() {
		return this.center;
	}
	
	
	@Override
	public void updatePosition() {
		double x = this.point.getX();
		double y = this.point.getY();
		this.point = new Point2D.Double(x, y);
	}

	@Override
	public void updatePosition(int xVel, int yVel) {
		updateLastDirection(xVel, yVel);
		double x = this.point.getX() + xVel;
		double y = this.point.getY() + yVel;
		if (this.point.getX() > 420) {
			x = 0;
		}
		if (this.point.getX() < 0) {
			x = 420;
		}
		if (this.point.getY() < 0) {
			y = 0;
		}
		if (this.point.getY() > 450) {
			y = 445;
		}
		this.point = new Point2D.Double(x, y);
//		System.out.println("updating position " + this.point);
		this.center = new Point2D.Double(this.point.getX() + WIDTH / 2, this.point.getY() + HEIGHT / 2);
		this.cord = new Line2D.Double(this.center.getX(), this.center.getY(), this.center.getX(), this.center.getY());
		this.lastXVelocity = xVel;
		this.lastYVelocity = yVel;

	}

	public void updateLastDirection(int xVel, int yVel) {
		if (xVel < 0) {
			this.lastDirection = 'l';
		}
		if (xVel > 0) {
			this.lastDirection = 'r';
		}
		if (yVel < 0) {
			this.lastDirection = 'u';
		}
		if (yVel > 0) {
			this.lastDirection = 'd';
		}
	}
	
	public void reversePosition(){
		System.out.println("reversePosition Hero");
		if (this.lastDirection=='u' || this.lastDirection=='d') {
			updatePosition(this.lastXVelocity*3, this.lastYVelocity*(-1)*3);
		}
		else {
			updatePosition(this.lastXVelocity*(-1)*3, this.lastYVelocity*3);
		}
	}

	@Override
	public void updateSize() {
		// this.size = this.size;
	}
	
	@Override 
	public void die(){
		System.out.println("die");
		this.point = new Point2D.Double(210.0, 120.0);
		world.setLives(world.getLives() - 1);
	}

	@Override
	public double getscore() {
		return this.score;
	}

	public Line2D.Double extendCord() {
		if (this.cord.getX2()-this.cord.getX1()==0 && this.cord.getY2()-this.cord.getY1()==0) {
			
		
		if (this.lastDirection == 'u') {

			this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
					new Point2D.Double(this.cord.getX2(), this.cord.getY2() - HEIGHT*2));

		}
		if (this.lastDirection == 'd') {
			this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
					new Point2D.Double(this.cord.getX2(), this.cord.getY2() + HEIGHT*2));

		}
		if (this.lastDirection == 'l') {
			this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
					new Point2D.Double(this.cord.getX2() - WIDTH*2, this.cord.getY2()));

		}
		if (this.lastDirection == 'r') {
			this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
					new Point2D.Double(this.cord.getX2() + WIDTH*2, this.cord.getY2()));
		}}

		return this.cord;

	}
	
	public char getLastDirection(){
		return this.lastDirection;
	}

	//
	public Line2D.Double retractCord() {
		this.cord = new Line2D.Double(new Point2D.Double(this.center.getX(), this.center.getY()),
				new Point2D.Double(this.center.getX(), this.center.getY()));
		// this.cord = this.DEFAULT_CORD;
		return this.cord;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	public Line2D.Double getCord() {
//		return null;
		return this.cord;
		// return null;
	}

//	@Override
//	public Point2D.Double[] getBorder() {
//		Point2D.Double[] borderPoints = new Point2D.Double[4];
//		borderPoints[0] = new Point2D.Double(this.point.getX(), this.point.getY());
//		borderPoints[1] = new Point2D.Double(this.point.getX(), this.point.getY() + this.HEIGHT);
//		borderPoints[2] = new Point2D.Double(this.point.getX() + this.WIDTH, this.point.getY() + this.HEIGHT);
//		borderPoints[3] = new Point2D.Double(this.point.getX() + this.WIDTH, this.point.getY());
//		return borderPoints;
//	}

//	@Override
//	public void run() {
		// try {
		// /*
		// * Main "brains" inside an infinite loop, so the thread keeps
		// * running:
		// */
		// while (true) {
		// // Work of the thread can include calls to other methods:
		// String timeS = getTimeStamp();
		// System.out.println(timeS + ": " + this.message);
		//
		// /*
		// * After the work is done, put the thread to sleep so other
		// * threads can work. (Or the CPU can rest if no other threads
		// * are active.)
		// */
		// Thread.sleep(this.pauseInMS);
		// }
		// } catch (InterruptedException exception) {
		// /*
		// * This Runnable object just exits when interrupted, so there isn't
		// * anything to do here. Sometimes threads will use _very_ long sleep
		// * times, with interrupts used to wake them up and do something. That
		// * is, we don't always exit when interrupted.
		// */
		// }

		// try {
		// System.out.println("run method in Hero");
		//
		// if (this.lastDirection == 'u') {
		//
		// for (int i = 0; i < 30; i++) {
		// this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(),
		// this.cord.getY1()),
		// new Point2D.Double(this.cord.getX2(), this.cord.getY2() - 1));
		// Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
		// }
		// for (int i = 0; i < 30; i++) {
		// this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(),
		// this.cord.getY1()),
		// new Point2D.Double(this.cord.getX2(), this.cord.getY2() + 1));
		// Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
		// }
		// } else if (this.lastDirection == 'd') {
		// for (int i = 0; i < 30; i++) {
		// this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(),
		// this.cord.getY1()),
		// new Point2D.Double(this.cord.getX2(), this.cord.getY2() + 1));
		// Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
		// }
		// for (int i = 0; i < 30; i++) {
		// this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(),
		// this.cord.getY1()),
		// new Point2D.Double(this.cord.getX2(), this.cord.getY2() - 1));
		// Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
		// }
		// } else if (this.lastDirection == 'l') {
		// for (int i = 0; i < 30; i++) {
		// this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(),
		// this.cord.getY1()),
		// new Point2D.Double(this.cord.getX2() - 1, this.cord.getY2()));
		// Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
		// }
		// for (int i = 0; i < 30; i++) {
		// this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(),
		// this.cord.getY1()),
		// new Point2D.Double(this.cord.getX2() + 1, this.cord.getY2()));
		// Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
		// }
		// } else {
		// for (int i = 0; i < 30; i++) {
		// this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(),
		// this.cord.getY1()),
		// new Point2D.Double(this.cord.getX2() + 1, this.cord.getY2()));
		// Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
		// }
		// for (int i = 0; i < 30; i++) {
		// this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(),
		// this.cord.getY1()),
		// new Point2D.Double(this.cord.getX2() - 1, this.cord.getY2()));
		// Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
		// }
		// }
		//
		// }

		// if(this.cordExtended==false){
		//
		// this.cord = new Line2D.Double(new Point2D.Double(this.x, this.y),
		// new Point2D.Double(this.x + this.changeX*10, this.y +
		// this.changeY*10));
		// this.cordExtended = true;
		//
		// }
		// this.cord = this.DEFAULT_CORD;}

		// catch (InterruptedException e) {
		// //
		// }

//	}

}
