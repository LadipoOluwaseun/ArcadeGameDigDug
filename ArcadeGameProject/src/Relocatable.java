import java.awt.geom.Point2D;

public interface Relocatable {

	/**
	 * Re-centers this object to the given.
	 * 
	 * @param point
	 */
	void moveTo(Point2D point);

	/**
	 * Returns the center point of this object.
	 * 
	 * @return the center point
	 */
	Point2D getCenterPoint();

}
