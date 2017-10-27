

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
		SimulationPanel worlds = constructSimulations();
		JFrame frame = new DigDugFrame(worlds);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * This helper method constructs a list of simulation objects that will each
	 * simulate a world of bouncing balls.
	 * 
	 * @return a list of worlds
	 */
	private static SimulationPanel constructSimulations() {
		SimulationPanel sp = new SimulationPanel();
		
		return sp;
	}

}
