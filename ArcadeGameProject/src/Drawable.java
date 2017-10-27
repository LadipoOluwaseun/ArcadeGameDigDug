import java.awt.Color;

import com.sun.javafx.geom.Rectangle;

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
	
	Rectangle getShape();

}
