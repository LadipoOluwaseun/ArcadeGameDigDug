//JUSTIN TODO finish NewGame button

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the main window for the application. It can display a collection of
 * ball simulations.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public class DigDugFrame extends JFrame {

	private static final int GAP = 0;

	/**
	 * Constructs a frame for displaying the given simulations.
	 * 
	 * @param world
	 *            a non-empty list of simulation panels to display
	 */
	public DigDugFrame(SimulationPanel sp, DigDugWorld world) {
		setTitle("Dig Dug Worlds");

		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(600, 600));
		// Changes the layout of the panel so the worlds will stack vertically
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		// add "rigid stuff" to force minimum spacing
//		content.add(Box.createVerticalStrut(GAP));
//			content.add(worlds);
		content.add(sp, BorderLayout.CENTER);
//		content.add(Box.createVerticalStrut(GAP));
		add(quitButtonComponent(world), BorderLayout.SOUTH);
		
		add(content);

		
		addKeyListener(new DigDugKeyHandler(world));
//		setResizable(false);
		
		pack();
	}

	/**
	 * Adds a quit button to the bottom-right corner of the window.
	 */
	private JPanel quitButtonComponent(DigDugWorld world) {
		JPanel quitPanel = new JPanel();
//		quitPanel
//				.setBorder(BorderFactory.createEmptyBorder(0, GAP, GAP, GAP));
//		quitPanel.add(Box.createHorizontalGlue());
		JButton quitButton = new JButton("Quit");
//		quitPanel.add(quitButton);
		
		JButton newGameButton = new JButton("New Game");
//		quitPanel.add(newGameButton);

		ActionListener newGamer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
//				System.exit(0);
				Main.main(null);
			}
		};
		

		ActionListener quitter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		};
		
		quitButton.addActionListener(quitter);
		newGameButton.addActionListener(newGamer);
//		quitPanel.addKeyListener(new DigDugKeyHandler(world));
		return quitPanel;
	}

	


}

