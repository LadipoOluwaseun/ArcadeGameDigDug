

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
		DigDugWorld world = new DigDugWorld(1, true);
		if(args.length == 0) {
			world = new DigDugWorld(1, true);
		} else{
			world = new DigDugWorld(Integer.parseInt(args[0]), Boolean.parseBoolean(args[1]));
		}
//		this.world = new DigDugWorld();
//		SimulationPanel worlds = new SimulationPanel(world);
		JFrame frame = new DigDugFrame(world);
//		newWorld(world);
//		frame.addKeyListener(new DigDugKeyHandler());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
//	private static DigDugWorld newWorld(DigDugWorld world) {
//		if(world.getReadingFile()) {
//			DigDugWorld newWorld= new DigDugWorld();
//			return newWorld;
//		}
//		return world;
////		return newWorld;
//	}
}


