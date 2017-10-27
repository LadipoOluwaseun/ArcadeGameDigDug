import java.awt.geom.Point2D;



public abstract class Character extends Stuff{
	
	public Character(DigDugEnvironment world, Point2D.Double point) {
		super(world, point);
		
	}

	public abstract void updatePosition ();
	
	public abstract void updateSize();
	
	public abstract void updateColor();
}
