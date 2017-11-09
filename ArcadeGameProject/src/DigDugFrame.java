//JUSTIN TODO finish NewGame button

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	public DigDugFrame(DigDugWorld world) {
		setTitle("Dig Dug Worlds");
		//JPanel ppn = playerPanelComponent(world);
		DigDugWorldComponent component = new DigDugWorldComponent(world);
		component.setPreferredSize(new Dimension(600, 600));
		add(component);
		DigDugKeyHandler keyboard = new DigDugKeyHandler(world);
		component.addKeyListener(keyboard);


		add(quitButtonComponent(world), BorderLayout.SOUTH);
		add(playerPanelComponent(world), BorderLayout.NORTH);
		
		addKeyListener(keyboard);

		pack();
		component.requestFocus();
	}

	/**
	 * Adds a quit button to the bottom-right corner of the window.
	 */
	private JPanel quitButtonComponent(DigDugWorld world) {
		JPanel quitPanel = new JPanel();
		
		JButton quitButton = new JButton("Quit");
		quitPanel.add(quitButton);
		
		JButton newGameButton = new JButton("New Game");
		quitPanel.add(newGameButton);
		
		quitPanel.add(makePauseResumeButton(world));
		
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
		
		quitPanel.setBackground(Color.LIGHT_GRAY);
		return quitPanel;
	}
	private JButton makePauseResumeButton(final Temporal temporalObj) {
		final JButton pauseResumeButton = new JButton("Pause");
		ActionListener pauser = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isPaused = temporalObj.getIsPaused();
				isPaused = !isPaused;
				temporalObj.setIsPaused(isPaused);
				if (isPaused) {
					pauseResumeButton.setText("Resume");
				} else {
					pauseResumeButton.setText("Pause");
				}

			}
		};
		pauseResumeButton.addActionListener(pauser);
		Dimension preferredButtonSize = pauseResumeButton.getPreferredSize();
		Dimension maxButtonSize = new Dimension(preferredButtonSize.width * 2,
		preferredButtonSize.height);
		pauseResumeButton.setMaximumSize(maxButtonSize);
		return pauseResumeButton;
	}
	
	private JPanel playerPanelComponent(DigDugWorld world){
		
		Font font  =  new Font("TI-83p Mini Sans",  Font.BOLD,30);
		JPanel playerPanel = new JPanel();
		
		playerPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel title = new JLabel();
		JLabel lives = new JLabel();
		JLabel score = new JLabel();
		
		//title.setText("DIG DUG");
		lives.setText("Number of Lives: " + world.getLives() + "  ");
		lives.setFont(font);
		score.setText("Score: " + world.getScore() + "  ");
		score.setFont(font);
		
		playerPanel.add(lives);
		playerPanel.add(score);
		
		
		return playerPanel;
	}
}

