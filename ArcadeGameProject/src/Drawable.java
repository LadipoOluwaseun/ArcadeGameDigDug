import java.awt.Color;
import java.awt.Shape;

public interface Drawable {
	
	/**
	 * Returns the shape the should be drawn to represent this object.
	 * 
	 * @return the shape to draw
	 */
	Shape getShape();

}
