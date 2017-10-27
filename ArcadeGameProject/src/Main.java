

/**
 * The main class for your arcade game.
 * 
 * You can design your game any way you like, but make the game start
 * by running main here.
 * 
 * Also don't forget to write javadocs for your classes and functions!
 * 
 * @author Buffalo
 *
 */
import javax.swing.JFrame;

public class Main {

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		DigDugWorld world = new DigDugWorld();
		SimulationPanel worlds = new SimulationPanel(world);
		JFrame frame = new DigDugFrame(worlds, world);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
