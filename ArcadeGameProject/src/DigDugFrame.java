import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the main window for the application. It can display a collection of
 * ball simulations.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public class DigDugFrame extends JFrame {

	private static final int GAP = 10;

	/**
	 * Constructs a frame for displaying the given simulations.
	 * 
	 * @param worlds
	 *            a non-empty list of simulation panels to display
	 */
	public DigDugFrame(SimulationPanel worlds) {
		setTitle("Dig Dug Worlds");

		JPanel content = new JPanel();
		// Changes the layout of the panel so the worlds will stack vertically
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		// add "rigid stuff" to force minimum spacing
		content.add(Box.createVerticalStrut(GAP));
			content.add(worlds);
			content.add(Box.createVerticalStrut(GAP));
		
		add(content);

		add(quitButtonComponent(), BorderLayout.PAGE_END);
		setResizable(false);
		
		pack();
	}

	/**
	 * Adds a quit button to the bottom-right corner of the window.
	 */
	private JComponent quitButtonComponent() {
		Box quitPanel = Box.createHorizontalBox();
		quitPanel
				.setBorder(BorderFactory.createEmptyBorder(0, GAP, GAP, GAP));
		quitPanel.add(Box.createHorizontalGlue());
		JButton quitButton = new JButton("Quit");
		quitPanel.add(quitButton);

		ActionListener quitter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		};
		
		quitButton.addActionListener(quitter);
		return quitPanel;
	}
	
	private JComponent newGameButtonComponent(){
		Box quitPanel = Box.createHorizontalBox();
		quitPanel
				.setBorder(BorderFactory.createEmptyBorder(0, GAP, GAP, GAP));
		quitPanel.add(Box.createHorizontalGlue());
		JButton newGameButton = new JButton("New Game");
		quitPanel.add(newGameButton);

		ActionListener newGamer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		};
		
		newGameButton.addActionListener(newGamer);
		return quitPanel;
	}

}
