import java.awt.Color;
import java.awt.Shape;

/**
 * @author smithea2.
 *         Created Oct 26, 2017.
 */

public interface Drawable {
	
	/**
	 * Returns the shape the should be drawn to represent this object.
	 * 
	 * @return the shape to draw
	 */
	Color getColor();
	
	Shape getShape();

}
