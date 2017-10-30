import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * 
 * Creates a panel to simulate the DigDugWorld.
 *
 * @author calarejf.
 *         Created Oct 26, 2017.
 */

public class SimulationPanel extends JPanel{

	

	private static final long serialVersionUID = 1L;
	private static final int GAP_WIDTH = 10;
	DigDugWorld world;
	
	/**
	 * Constructs a new simulation where the world for DigDug has the requirements
	 * from the text file read in DigDugWorld 
	 */
	
	public SimulationPanel(DigDugWorld world) {
		this.world = world;
		// Change layout so the buttons and the world are side-by-side.
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		DigDugWorldComponent worldComponent = new DigDugWorldComponent(world);
		// add "rigid stuff" to force minimum spacing
		add(Box.createHorizontalStrut(GAP_WIDTH));
		// add "rigid stuff" to force minimum spacing
		add(Box.createHorizontalStrut(GAP_WIDTH));
		add(worldComponent);
		// adds "stretchy stuff" to force the world to the left
//		add(Box.createGlue());
		// add "rigid stuff" to force minimum spacing
		add(Box.createHorizontalStrut(GAP_WIDTH));
	}
		
//		@Override
//		public void keyPressed(KeyEvent e) {
//			System.out.println(3);
//			char key = e.getKeyChar();
//			if(key == 'u') {
//				System.out.println("level up");
//				this.world.changeLevel(true);
//			}
//			
//			if(key == KeyEvent.VK_D) {
//				this.world.changeLevel(false);
//			}
//			
//			if(key == KeyEvent.VK_UP) {
////				 Hero.moveUp();
//			}
//			
//			if(key == KeyEvent.VK_DOWN) {
////				 Hero.moveDown();
//			}
//			
//			if(key == KeyEvent.VK_RIGHT) {
////				 Hero.moveRight();
//			}
//			
//			if(key == KeyEvent.VK_LEFT) {
////				 Hero.moveLeft();
//			}
//		}
//	
//		@Override
//		public void keyReleased(KeyEvent e) {
//			int key = e.getKeyChar();
//			if(key == KeyEvent.VK_U) {
//				System.out.println(1);
//				world.changeLevel(true);
//			}
//			
//			if(key == KeyEvent.VK_D) {
//				world.changeLevel(false);
//			}
//			
//			if(key == KeyEvent.VK_UP) {
////				 .moveUp();
//			}
//			
//			if(key == KeyEvent.VK_DOWN) {
////				 Hero.moveDown();
//			}
//			
//			if(key == KeyEvent.VK_RIGHT) {
////				 Hero.moveRight();
//			}
//			
//			if(key == KeyEvent.VK_LEFT) {
////				 Hero.moveLeft();
//			}
//			
//		}
//	
//		@Override
//		public void keyTyped(KeyEvent e) {
//			int key = e.getKeyChar();
//			if(key == 'u') {
//				System.out.println(1);
//				world.changeLevel(true);
//			}
//			
//			if(key == KeyEvent.VK_D) {
//				world.changeLevel(false);
//			}
//			
//			if(key == KeyEvent.VK_UP) {
////				 Hero.moveUp();
//			}
//			
//			if(key == KeyEvent.VK_DOWN) {
////				 Hero.moveDown();
//			}
//			
//			if(key == KeyEvent.VK_RIGHT) {
////				 Hero.moveRight();
//			}
//			
//			if(key == KeyEvent.VK_LEFT) {
////				 Hero.moveLeft();
//			}
//			if(key == KeyEvent.VK_Q) {
//				//Hero.extendCord();
//				//time.sleep();
//				//Hero.retractCord();
//			}
//			
//		}
}