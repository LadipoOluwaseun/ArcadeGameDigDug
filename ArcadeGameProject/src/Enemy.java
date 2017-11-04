
//Dijsktra algorithum for seekinig hero

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
//import util.Random;

/**
 * TODO Put here a description of what this class does.
 *
 * @author calarejf. Created Oct 31, 2017.
 */
public abstract class Enemy extends Stuff {
	public Hero hero;
	protected int width = 30;
	protected int height = 30;
	protected DigDugWorld world;
	public Point2D.Double point;
	protected boolean intercepts;
	protected double amountExpanded;
	protected static final int AMOUNT_TO_EXPAND = 1;
	public Rectangle rect;
	public double rand;
	char lastDirection;
	int lastXVelocity;
	int lastYVelocity;
	public Point2D.Double center;
	private int yVel;
	private int xVel;
	public double counter;
	public ArrayList<Dirt> dirtArray;

	// public Rectangle rect;

	public Enemy(DigDugWorld world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.world = world;
		this.point = new Point2D.Double(point.getX(), point.getY());
		this.intercepts = false;
		this.rect = new Rectangle((int) point.getX(), (int) point.getY(), this.width, this.height);
		this.rand = Math.random();
		this.center = new Point2D.Double(point.getX() + this.width / 2, point.getY() + this.height / 2);
		// this.yVel = 0;
		// this.xVel = 0;
		this.counter = 0;
		this.dirtArray = world.getDirtArray();
		this.lastDirection = 'd';

		// this.rect = new Rectangle((int) point.getX(),(int) point.getY(),
		// WIDTH, HEIGHT);

	}

	public void iterateCounter() {
		this.counter++;
		// System.out.println(this.counter);
	}

	public double getCounter() {
		return this.counter;
	}

	public void resetCounter() {
		this.counter = 0;
	}

	public void expand() {
		if (this.rect.getSize().getHeight() > 45) {
			this.die();
		}
		this.rect.grow(AMOUNT_TO_EXPAND, AMOUNT_TO_EXPAND);
		this.width = this.rect.width;
		this.height = this.rect.height;

	}

	@Override
	public Rectangle getShape() {
		return this.rect;
	}

	public void reversePosition() {
		System.out.println("reversePosition Hero");
		if (this.lastDirection == 'u' || this.lastDirection == 'd') {
			updatePosition(this.lastXVelocity, this.lastYVelocity * (-1));
		} else {
			updatePosition(this.lastXVelocity * (-1), this.lastYVelocity);
		}
	}

	public void updatePositionHelper() {
		// System.out.println("update position helper LastDirection is " +
		// this.lastDirection);
		// TODO Auto-generated method stub.
		getDirectionToMove();
//		System.out.println(this.lastDirection);
		this.xVel = 0;
		this.yVel = 0;
		if (this.lastDirection == 'u') {
			this.yVel = -1;
		}
		if (this.lastDirection == 'd') {
			this.yVel = 1;
		}
		if (this.lastDirection == 'l') {
			this.xVel = -1;
		}
		if (this.lastDirection == 'r') {
			this.xVel = 1;
		}
		updatePosition(xVel, yVel);
	}

	public void getDirectionToMove() {

		Rectangle upRect = new Rectangle(rect.x, rect.y-1, rect.width, rect.height);
		Rectangle downRect = new Rectangle(rect.x, rect.y+1, rect.width, rect.height);
		Rectangle leftRect = new Rectangle(rect.x - 1, rect.y, rect.width, rect.height);
		Rectangle rightRect = new Rectangle(rect.x + 1, rect.y, rect.width, rect.height);
		HashMap<Character, Rectangle> rectHashMap = new HashMap<>();
		rectHashMap.put('u', upRect);
		rectHashMap.put('l', leftRect);		
		rectHashMap.put('d', downRect);

		rectHashMap.put('r', rightRect);
		boolean flag = false;

		//
		// for (Map.Entry<String, Object> entry : map.entrySet()) {
		// String key = entry.getKey();
		// Object value = entry.getValue();
		// // ...
		// }

		for (HashMap.Entry<Character, Rectangle> entry : rectHashMap.entrySet()) {
//			System.out.println("eeGetDirectionToMove");
			if (this.lastDirection == entry.getKey()) {
//				 System.out.println("earlierGetDirectionToMove");
//				System.out.println(this.dirtArray);
				for (Dirt d : this.dirtArray) {
//					System.out.println(d);
//					 System.out.println("getDirectionToMove");
//					System.out.println(this.rect);
//					System.out.println(entry.getValue());
//					System.out.println("d.getShape(): "+d.getShape().toString());
//					System.out.println("entry.getValue(): "+entry.getValue().toString());

					if (d.getShape().intersects(entry.getValue())) {
						
//						System.out.println("Dirt: " + d.getShape().toString() + "Enemy: " + entry.getValue().toString());
						flag = true;
					}
					
				}if (flag == false) {
						return;
					}
				break;
			}
		}
		// }
//		flag = true;
//		System.out.println(flag);
		for (HashMap.Entry<Character, Rectangle> entry : rectHashMap.entrySet()) {
//			System.out.println("Second hashmap loop");
			flag = true;

			for (Dirt d : this.dirtArray) {
				if (d.getShape().intersects(entry.getValue())) {

					flag = false;
				}

			}
			if (flag) {
				System.out.println("inner dirt array2");
				this.lastDirection = entry.getKey();
				return;

			}

		}

		// for (Dirt d : this.dirtArray) {
		// if (!(d.getShape().intersects(upRect))) {
		// return this.lastDirection;
		//
		// }
		// if (this.lastDirection=='u') {
		// return 'r';
		// }
		// if (this.lastDirection=='r') {
		// return 'd';
		// }
		// if (this.lastDirection=='d') {
		// return 'l';
		// }
		// if (this.lastDirection=='l') {
		// return 'u';
		// }
		//
		// }
	}

	@Override
	public void updatePosition(int xVel, int yVel) {
		// System.out.println("help");
		// if(this.xVel == 0 && this.yVel == 0) {
		// xVel = 4;
		// yVel = 4;
		// }
		// rand = Math.random();
		// for(Dirt d: this.world.getDirtArray()) {
		// if(this.getShape().intersects(d.getShape())){
		// if(rand > 0.7 && this.lastDirection == 'l' || rand > 0.7 &&
		// this.lastDirection == 'r') {
		// xVel = -4;
		// yVel = 4;
		// }
		// if(rand < 0.3 && this.lastDirection == 'u' || rand < 0.3 &&
		// this.lastDirection == 'd') {
		// xVel = 4;
		// yVel = -4;
		// }
		// }
		// }

		// this.point = new Point2D.Double(this.point.getX() + xVel,
		// this.point.getY() + yVel);
		// this.center = new Point2D.Double(this.point.getX() + WIDTH,
		// this.point.getY() + HEIGHT);
		// this.rect.grow(10, 10);
		// System.out.println("updatePostion Enemy"+
		// this.getClass().toString());
//		updateLastDirection(xVel, yVel);
		double xPos = this.point.getX();
		double yPos = this.point.getY();
		if (this.point.getX() > 420) {
			xPos = 0;
		}
		if (this.point.getX() < 0) {
			xPos = 420;
		}
		if (this.point.getY() < 0) {
			yPos = 0;
			this.yVel = -this.yVel;
		}
		if (this.point.getY() > 450) {
			yPos = 445;
			this.yVel = -this.yVel;
		}
		// xPos = this.point.getX() + xVel;
		// yPos= this.point.getY() + yVel;
		this.point = new Point2D.Double(xPos + xVel, yPos + yVel);
		this.rect = new Rectangle((int) point.getX(), (int) point.getY(), this.width, this.height);

		// System.out.println("updating position " + this.point);
		this.center = new Point2D.Double(point.getX() + this.width / 2, point.getY() + this.height / 2);
		// this.cord = new Line2D.Double(this.center.getX(), this.center.getY(),
		// this.center.getX(), this.center.getY());
		this.lastXVelocity = this.xVel;
		this.lastYVelocity = this.yVel;

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
}
