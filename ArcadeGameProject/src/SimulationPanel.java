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
	
	public SimulationPanel() {
		// Change layout so the buttons and the world are side-by-side.
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		DigDugWorld world = new DigDugWorld();
		DigDugWorldComponent worldComponent = new DigDugWorldComponent(world);
		// add "rigid stuff" to force minimum spacing
		add(Box.createHorizontalStrut(GAP_WIDTH));
		// add "rigid stuff" to force minimum spacing
		add(Box.createHorizontalStrut(GAP_WIDTH));
//		add(worldComponent);
		// adds "stretchy stuff" to force the world to the left
		add(Box.createGlue());
		// add "rigid stuff" to force minimum spacing
		add(Box.createHorizontalStrut(GAP_WIDTH));
	}
}