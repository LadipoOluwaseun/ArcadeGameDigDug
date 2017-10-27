import java.awt.geom.Point2D;


public abstract class Stuff implements Drawable, Temporal, Relocatable {
	private DigDugEnvironment world;
	private Point2D stuffPoint;
	private boolean isPaused;
	/**
	 * Constructs stuff centered at the given point in the given world.
	 * 
	 * @param world
	 * 
	 * @param centerPoint
	 */
	public Stuff(DigDugEnvironment world, Point2D point) {
		this.world = world;
		this.stuffPoint = point;
	}
	
	protected DigDugEnvironment getWorld() {
		return this.world;
	}
	
	protected void setPoint(Point2D point) {
		this.stuffPoint = point;
	}
	//need to implement the methods below
	@Override
	public void timePassed() {
			
	}

	@Override
	public void die() {
		
	}

	@Override
	public boolean getIsPaused() {
		return isPaused;
		
	}

	@Override
	public void setIsPaused(boolean setIsPaused) {
		isPaused = setIsPaused;
	}
	
	@Override
	public void moveTo(Point2D point) {
		Point2D newPoint = new Point2D.Double(point.getX(),point.getY());
		this.setPoint(newPoint);
	}
	
	/**
	 * Returns the score of this stuff.
	 * 
	 * @return the score
	 */
	public abstract double getscore();
}
