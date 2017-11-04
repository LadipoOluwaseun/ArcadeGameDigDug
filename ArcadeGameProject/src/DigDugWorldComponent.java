import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

//import com.sun.javafx.geom.Rectangle;

/**
 * 
 * Renders the components of the DigDug world on the GUI
 *
 * @author smithea2.
 *         Created Oct 26, 2017.
 */

public class DigDugWorldComponent extends JComponent{
	/**
	 * TODO Put here a description of this field.
	 */
	private static final long serialVersionUID = 1L;
	private DigDugWorld world;
	private static final int FRAMES_PER_SECOND = 30;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;
	private boolean hasShownNullErrorMessage = false;
	private static final int ENEMY_VELOCITY = 4;

	Hero hero;
//	public ArrayList<Dirt> dirtArray;

	DigDugWorldComponent(DigDugWorld world) {
		this.world = world;
		this.hero = world.getHero();
//		addKeyListener(new DigDugKeyHandler(this.world, this.hero));


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

	@Override
	protected void paintComponent(Graphics g) {
		//System.out.println("repaint");
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
//		System.out.println("hi");
		drawDrawable(g2, this.world);
		List<Drawable> drawableParts = this.world.getDrawableParts();
//		System.out.println(this.world.getDrawableParts().toString());
		for (Enemy e: this.world.getEnemyArray()){
//			System.out.println(this.world.getEnemyArray());
			e.updatePositionHelper();
		}
		this.handleCollisions();
		drawCord(g2, this.hero.cord);
		
		for (Drawable d : drawableParts) {
			
//			if (d instanceof Hero) {
//				this.hero = (Hero) d;
////				System.out.println(hero.toString());
//			}
//			System.out.println("Paint component");
			drawDrawable(g2, d);
//			Line2D.Double line = this.hero.cord;
//			drawCord(g2, this.hero.cord);
//			System.out.println(this.hero.);
			
			
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
		java.awt.Rectangle shape = d.getShape();
		if (shape == null) {
			showNullPointerMessage("shape", d);
			return;
		}
//		System.out.println("bye");
		g2.setColor(color);
//		System.out.println(shape.x);
//		System.out.println(shape.width);
		g2.drawRect(shape.x, shape.y, shape.width, shape.height);
		g2.fillRect(shape.x, shape.y, shape.width, shape.height);
		
		
	}
	
	private void handleCollisions() {
		for (Dirt d : this.world.getDirtArray()){
			if (d.getShape().intersects((this.hero.getShape()))) {
				d.die();
			}
			
		}
		for (Enemy e : this.world.getEnemyArray()){
			if (e.getShape().intersectsLine(this.hero.getCord())) {
//				System.out.println("enemy intersect cord handle collision method component");
				if (e.getCounter()%10==0) {
					e.expand();
				}
			}
			if (e.getShape().intersects(this.hero.getShape())) {
				this.hero.die();
			}
		}
		for (Rock r : this.world.getRockArray()){
			if(r.getShape().getMaxY() == this.hero.getShape().getMinY() && 
					r.getShape().getMaxX() <= this.hero.getShape().getMaxX() && 
					r.getShape().getMaxX() >=this.hero.getShape().getMinX() ||
					r.getShape().getMinX() <= this.hero.getShape().getMaxX() &&
					r.getShape().getMinX() >= this.hero.getShape().getMinX() &&
					r.getShape().getMaxY() == this.hero.getShape().getMinY()) {
//				System.out.println("falling Rock");
				r.falling();
//				r.hitDirt();
				r.fall();
//				for()
//					if(r.getShape().getMinY() == )
//				r.fall();
//			}
			}
			while (r.getShape().intersects(this.hero.getShape())) {
				this.hero.reversePosition();
			}
		}
	}
	
	private static void drawCord(Graphics2D g2, Line2D.Double d){
//		System.out.println("drawCordStart");
		g2.setColor(new Color(255, 0, 0));
		g2.draw(d);
//		System.out.println("drawCord End");
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
//	public Hero getHero(){
////		System.out.println("getHero in component");
//		return this.hero;
//	}

}
