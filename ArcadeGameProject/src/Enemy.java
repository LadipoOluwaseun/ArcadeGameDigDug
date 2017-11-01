import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * TODO Put here a description of what this class does.
 *
 * @author calarejf.
 *         Created Oct 31, 2017.
 */
public abstract class Enemy extends Stuff{
	public Hero hero;
	protected static final int WIDTH = 30;
	protected static final int HEIGHT = 30;
	protected DigDugWorld world;
	public Point2D.Double point;
	protected boolean intercepts;
	protected double amountExpanded;
	protected static final int AMOUNT_TO_EXPAND = 1;
	public Rectangle rect;
	public Random rand;
	char lastDirection;
	int lastXVelocity;
	int lastYVelocity;
	public Point2D.Double center;
	private int yVel;
	private int xVel;
	public double counter;
	
//	public Rectangle rect;

	
	public Enemy(DigDugWorld world, Point2D.Double point, Hero hero) {
		super(world, point, hero);
		this.world = world;
		this.point = new Point2D.Double(point.getX(), point.getY());
		this.intercepts = false;
		this.rect = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);
		this.rand = new Random();
		this.center = new Point2D.Double(point.getX() + WIDTH / 2, point.getY() + HEIGHT / 2);
		this.yVel = 0;
		this.xVel = 0;
		this.counter = 0;
		

//		this.rect = new Rectangle((int) point.getX(),(int) point.getY(), WIDTH, HEIGHT);

	}
	
	public void iterateCounter() {
		this.counter++;
	}
	
	public double getCounter() {
		return this.counter;
	}
	
	public void resetCounter() {
		this.counter = 0;
	}
	
	public void expand(){
		if(this.rect.getSize().getHeight() > 45) {
			this.die();
		}
		this.rect.grow(AMOUNT_TO_EXPAND, AMOUNT_TO_EXPAND);
	}
	
	@Override
	public Rectangle getShape() {
		return this.rect;
	}
	
	public void reversePosition(){
		System.out.println("reversePosition Hero");
		if (this.lastDirection=='u' || this.lastDirection=='d') {
			updatePosition(this.lastXVelocity, this.lastYVelocity*(-1));
		}
		else {
			updatePosition(this.lastXVelocity*(-1), this.lastYVelocity);
		}
	}
	
	
	
	@Override
	public void updatePosition() {
//		if(this.xVel == 0 && this.yVel == 0) {
//			
//		}
		System.out.println("Enemy Update" + this.getShape());
//		this.point = new Point2D.Double(this.point.getX() + xVel, this.point.getY() + yVel);
//		this.center = new Point2D.Double(this.point.getX() + WIDTH, this.point.getY() + HEIGHT);
//		this.rect.grow(10, 10);
//		System.out.println("updatePostion Enemy"+ this.getClass().toString());
		updateLastDirection(this.xVel, this.yVel);
		double xPos = this.point.getX();
		double yPos= this.point.getY();
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
//		xPos = this.point.getX() + xVel;
//		yPos= this.point.getY() + yVel;
		this.point = new Point2D.Double(xPos + this.xVel, yPos + this.yVel);
		this.rect = new Rectangle((int) this.point.getX(),(int) this.point.getY(), WIDTH, HEIGHT);

//		System.out.println("updating position " + this.point);
		this.center = new Point2D.Double(this.point.getX() + WIDTH / 2, this.point.getY() + HEIGHT / 2);
//		this.cord = new Line2D.Double(this.center.getX(), this.center.getY(), this.center.getX(), this.center.getY());
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
