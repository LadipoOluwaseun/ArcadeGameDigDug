import java.awt.geom.Point2D;

/**
 * 
 * creates and implements methods of the hero in DigDugWorld.
 *
 * @author ladipooo.
 *         Created Oct 26, 2017.
 */

public interface Relocatable {

	/**
	 * Re-centers this object to the given.
	 * 
	 * @param point
	 */
	void moveTo(Point2D.Double point);

	/**
	 * Returns the center point of this object.
	 * 
	 * @return the center point
	 */
	Point2D getCenterPoint();

}
