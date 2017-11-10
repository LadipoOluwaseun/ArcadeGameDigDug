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
	private JPanel scorePanel;
	/**
	 * Constructs a frame for displaying the given simulations.
	 * 
	 * @param world
	 *            a non-empty list of simulation panels to display
	 */
	
	
	public DigDugFrame(DigDugWorld world) {
		this.scorePanel = playerPanelComponent(world, world.getLives(), world.getScore());
		
		setTitle("Dig Dug Worlds");
		DigDugWorldComponent component = new DigDugWorldComponent(world);
		component.setPreferredSize(new Dimension(600, 600));
		add(component);
		DigDugKeyHandler keyboard = new DigDugKeyHandler(world, this);
		component.addKeyListener(keyboard);
		JLabel pause = new JLabel();
		pause.setText("GAME PAUSED PRESS RESUME TO CONTINUE");
		
		
		

		add(quitButtonComponent(world), BorderLayout.SOUTH);
		add(scorePanel, BorderLayout.NORTH);
		
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
				String[] args = new String[0];
				Main.main(args);
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
		final JLabel pause = new JLabel();
		
		Font font  =  new Font("TI-83p Mini Sans",  Font.BOLD,30);
		pause.setText("GAME PAUSED " + "\n" + "\n" + "PRESS RESUME" + "\n" +"\n" + " TO CONTINUE");
		pause.setFont(font);
		
		ActionListener pauser = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isPaused = temporalObj.getIsPaused();
				isPaused = !isPaused;
				temporalObj.setIsPaused(isPaused);
				if (isPaused) {
					add(pause);	
					pause.setSize(1000, 1000);
					pack();
					repaint();
					pauseResumeButton.setText("Resume");
				} else {
					remove(pause);
					pack();
					repaint();
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
	
	public JPanel playerPanelComponent(DigDugWorld world, int nLives, double nScore){
		
		Font font  =  new Font("TI-83p Mini Sans",  Font.BOLD,30);
		JPanel playerPanel = new JPanel();
		
		playerPanel.setBackground(Color.LIGHT_GRAY);
		
		
		JLabel lives = new JLabel();
		JLabel score = new JLabel();
		
		//title.setText("DIG DUG");
		lives.setText("Number of Lives: " + nLives + "  ");
		lives.setFont(font);
		score.setText("Score: " + nScore + "  ");
		score.setFont(font);
		
		playerPanel.add(lives);
		playerPanel.add(score);
		
		
		return playerPanel;
	}

	public JPanel getScorePanel() {
		return scorePanel;
	}

	public void setScorePanel(JPanel panel) {
		this.remove(scorePanel);
		scorePanel = panel;
		this.add(panel, BorderLayout.NORTH);
	}

}

