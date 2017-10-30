import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import com.sun.javafx.geom.Rectangle;

/**
 * 
 * creates and implements methods of the hero in DigDugWorld.
 *
 * @author smithea2. Created Oct 26, 2017.
 */

public class Hero extends Stuff implements Runnable {

	public Point2D.Double point;
	// public int y;
	// public int x;
	public Rectangle shape;
	public Point2D center;
	// private Dimension size;
	private Color color;
	public int score;
	public int changeX;
	public int changeY;
	public Line2D.Double cord;
	public Line2D.Double DEFAULT_CORD;
	public boolean cordExtended;
	public int WIDTH;
	public int HEIGHT;
	private int TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS;
	char lastDirection;

	public Hero(DigDugEnvironment world, Point2D.Double point) {
		super(world, point);
		this.point = point;
		this.changeX = 0;
		this.changeY = 0;
		this.cordExtended = false;
		this.color = Color.CYAN;
		this.WIDTH = 30;
		this.HEIGHT = 30;
		this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS = 100;
		this.shape = new Rectangle((int) point.getX(), (int) point.getY(), this.WIDTH, this.HEIGHT);
		this.DEFAULT_CORD = new Line2D.Double(new Point2D.Double(this.point.getX(), this.point.getY()),
				new Point2D.Double(this.point.getX(), this.point.getY()));
		this.cord = this.DEFAULT_CORD;
		// System.out.println("i'm a hero!");
	}

	public void moveUp() {
		System.out.println("watch me move up!");
		this.changeY = 5;
		this.lastDirection = 'u';
	}

	public void moveDown() {
		System.out.println("watch me move down!");
		this.changeY = -5;
		this.lastDirection = 'd';
	}

	public void moveLeft() {
		System.out.println("watch me move left!");
		this.changeX = -5;
		this.lastDirection = 'l';
	}

	public void moveRight() {
		System.out.println("watch me move right!");
		this.changeX = 5;
		this.lastDirection = 'r';
	}

	@Override
	public Rectangle getShape() {
		return this.shape;
	}

	@Override
	public Point2D getCenterPoint() {
		return this.center;
	}

	public void updatePosition() {
		double x = this.point.getX() + this.changeX;
		double y = this.point.getY() + this.changeY;
		this.point = new Point2D.Double(x, y);
		this.changeX = 0;
		this.changeY = 0;
	}

	public void updateSize() {
		// this.size = this.size;
	}

	@Override
	public double getscore() {
		return this.score;
	}

	public Line2D.Double extendCord() {
		this.run();
		return this.cord;

	}
	//
	// public Line2D.Double retractCord() {
	// this.cord = this.DEFAULT_CORD;
	// return this.cord;
	// }

	@Override
	public Color getColor() {
		return this.color;
	}

	public Line2D.Double getCord() {
		// return this.cord;
		return null;
	}

	@Override
	public void run() {
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
		try {
			System.out.println("run method in Hero");

			if (this.lastDirection == 'u') {

				for (int i = 0; i < 30; i++) {
					this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
							new Point2D.Double(this.cord.getX2(), this.cord.getY2() - 1));
					Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
				}
				for (int i = 0; i < 30; i++) {
					this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
							new Point2D.Double(this.cord.getX2(), this.cord.getY2() + 1));
					Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
				}
			} else if (this.lastDirection == 'd') {
				for (int i = 0; i < 30; i++) {
					this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
							new Point2D.Double(this.cord.getX2(), this.cord.getY2() + 1));
					Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
				}
				for (int i = 0; i < 30; i++) {
					this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
							new Point2D.Double(this.cord.getX2(), this.cord.getY2() - 1));
					Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
				}
			} else if (this.lastDirection == 'l') {
				for (int i = 0; i < 30; i++) {
					this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
							new Point2D.Double(this.cord.getX2() - 1, this.cord.getY2()));
					Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
				}
				for (int i = 0; i < 30; i++) {
					this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
							new Point2D.Double(this.cord.getX2() + 1, this.cord.getY2()));
					Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
				}
			} else {
				for (int i = 0; i < 30; i++) {
					this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
							new Point2D.Double(this.cord.getX2() + 1, this.cord.getY2()));
					Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
				}
				for (int i = 0; i < 30; i++) {
					this.cord = new Line2D.Double(new Point2D.Double(this.cord.getX1(), this.cord.getY1()),
							new Point2D.Double(this.cord.getX2() - 1, this.cord.getY2()));
					Thread.sleep(this.TIME_TO_SLEEP_WHILE_EXTENDING_CORD_IN_MILLISECONDS);
				}
			}

		}

		// if(this.cordExtended==false){
		//
		// this.cord = new Line2D.Double(new Point2D.Double(this.x, this.y),
		// new Point2D.Double(this.x + this.changeX*10, this.y +
		// this.changeY*10));
		// this.cordExtended = true;
		//
		// }
		// this.cord = this.DEFAULT_CORD;}

		catch (InterruptedException e) {
			//
		}

	}
}
