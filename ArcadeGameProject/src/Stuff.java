import java.awt.geom.Point2D;


/**
 * 
 * the abstract superclass over all of the objects that are drawn on the DigDugWorld
 * 
 * @author smithea2.
 *         Created Oct 27, 2017.
 */

public abstract class Stuff implements Drawable, Temporal, Relocatable {
	private DigDugEnvironment world;
	private Point2D.Double stuffPoint;
	private boolean isPaused;
	private Hero hero;
	/**
	 * Constructs stuff centered at the given point in the given world.
	 * 
	 * @param world
	 * 
	 * @param centerPoint
	 */
	public Stuff(DigDugEnvironment world, Point2D.Double point) {
		this.world = world;
		this.stuffPoint = point;
	}
	
	public Stuff(DigDugEnvironment world, Point2D.Double point, Hero heroman) {
		this.world = world;
		this.stuffPoint = point;
		this.hero = heroman;
	}

	protected DigDugEnvironment getWorld() {
		return this.world;
	}
	
	protected void setPoint(Point2D.Double newPoint) {
		this.stuffPoint = newPoint;
	}
	
	//need to implement the methods below
	@Override
	public void timePassed() {
//		System.out.println("time");
		if (!this.isPaused) {
		updateSize();
		updatePosition();
		}
	}
	
	public void updatePosition(int xVel, int yVel) {
		//ignored for now
	}

	@Override
	public void die() {
		//
	}

	@Override
	public boolean getIsPaused() {
		return this.isPaused;
		
	}

	@Override
	public void setIsPaused(boolean setIsPaused) {
		this.isPaused = setIsPaused;
	}
	
	@Override
	public void moveTo(Point2D.Double point) {
		Point2D.Double newPoint = new Point2D.Double(point.getX(),point.getY());
		this.setPoint(newPoint);
	}
	
	public abstract void updatePosition();

	/**
	 * Updates the size of this object, if necessary, due to the passing of a
	 * "moment" in time.
	 */
	public abstract void updateSize();
	
	/**
	 * Returns the score of this stuff.
	 * 
	 * @return the score
	 */
	public abstract double getscore();

	public abstract Point2D.Double[] getBorder();
	
//	public abstract void intercepts(Stuff stuff);
}
