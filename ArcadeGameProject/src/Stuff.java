import java.awt.geom.Point2D;


public abstract class Stuff implements Drawable, Temporal, Relocatable {
	private DigDugEnvironment world;
	private Point2D.Double stuffPoint;
	private boolean isPaused;
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
	
	protected DigDugEnvironment getWorld() {
		return this.world;
	}
	
	protected void setPoint(Point2D.Double newPoint) {
		this.stuffPoint = newPoint;
	}
	//need to implement the methods below
	@Override
	public void timePassed() {
			//ignored
	}

	@Override
	public void die() {
		//not yet implemented
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
	
	/**
	 * Returns the score of this stuff.
	 * 
	 * @return the score
	 */
	public abstract double getscore();
}
