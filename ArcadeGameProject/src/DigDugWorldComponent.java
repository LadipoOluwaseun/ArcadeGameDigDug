import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * 
 * Renders the components of the DigDug world on the GUI
 *
 * @author smithea2.
 *         Created Oct 26, 2017.
 */

public class DigDugWorldComponent extends JComponent{
	private DigDugWorld world;
	private static final int FRAMES_PER_SECOND = 30;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;
	private boolean hasShownNullErrorMessage = false;

	DigDugWorldComponent(DigDugWorld world) {
		this.world = world;
//	setPreferredSize(world.getSize());
//	setMaximumSize(world.getSize());

	// Creates a separate "thread of execution" to trigger periodic
	// repainting of this component.
	Runnable repainter = new Runnable() {
		@Override
		public void run() {
			// Periodically asks Java to repaint this component
			try {
				while (true) {
					Thread.sleep(REPAINT_INTERVAL_MS);
					repaint();
				}
			} catch (InterruptedException exception) {
				// Stop when interrupted
			}
		}
	};
	new Thread(repainter).start();
}

protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;

	drawDrawable(g2, this.world);

	List<Drawable> drawableParts = this.world.getDrawableParts();
	for (Drawable d : drawableParts) {
		drawDrawable(g2, d);
	}
}

/**
 * This helper method draws the given drawable object on the given graphics
 * area.
 * 
 * @param g2
 *            the graphics area on which to draw
 * @param d
 *            the drawable object
 */
private void drawDrawable(Graphics2D g2, Drawable d) {
	Color color = d.getColor();
	if (color == null) {
		showNullPointerMessage("color", d);
		return;
	}
	Shape shape = d.getShape();
	if (shape == null) {
		showNullPointerMessage("shape", d);
		return;
	}
	
	g2.fill(shape);
}

/**
 * Displays an error message explaining that the Ball's color/shape was null
 * so it could not be drawn. Show the message only once per component.
 */
private void showNullPointerMessage(String nullAttribute, Drawable d) {
	if (!this.hasShownNullErrorMessage) {
		this.hasShownNullErrorMessage = true;
		String message = "I could not draw this Drawable object of type "
				+ d.getClass().getName() + " because its " + nullAttribute
				+ " is null.\n";
		JOptionPane.showMessageDialog(null, message,
				"Null pointer exception", JOptionPane.ERROR_MESSAGE);
	}
}


}
