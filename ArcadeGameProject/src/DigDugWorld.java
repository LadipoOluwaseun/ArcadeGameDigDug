import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.Rectangle;

/**
 * 
 * creates the world for all of the "Stuff" to be added to, where everything is implemented and controls 
 * are used
 * 
 * @author smithea2.
 *         Created Oct 27, 2017.
 */

public class DigDugWorld implements DigDugEnvironment, Drawable, Temporal{
	boolean isPaused;
	private static final long UPDATE_INTERVAL_MS = 10;
	private final int WIDTH = 450;
	private final int HEIGHT = 450;
	
	private List<Stuff> stuff = new ArrayList<>();
	private List<Stuff> stuffToAdd = new ArrayList<>();
	private List<Stuff> stuffToRemove = new ArrayList<>();
	private Rectangle background;
	
	private final int NUMBER_OF_OBJECTS_WIDE = 15;
	private final int NUMBER_OF_OBJECTS_HIGH = 15;
	private final double WIDTH_OF_EACH_STUFF = 30;
	private final double HEIGHT_OF_EACH_STUFF = 30;
	public int current;
	Hero hero;
	
	public DigDugWorld(){
		this.current = 1;
		readLevelFile("Level" + this.current + ".txt");
		this.background = new Rectangle(0, 0, this.WIDTH, this.HEIGHT);
		Runnable tickTock = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(UPDATE_INTERVAL_MS);
//						timePassed();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		new Thread(tickTock).start();
	}
	

	public int lives(){
		return 0;
	}
	public double score(){
		return 0;
	}

	@Override
	public synchronized void timePassed() {
		if (!this.isPaused) {
			for (Temporal t : this.stuff) {
				t.timePassed();
			}
		}
		this.stuff.removeAll(this.stuffToRemove);
		this.stuffToRemove.clear();
		this.stuff.addAll(this.stuffToAdd);
		this.stuffToAdd.clear();
	}

	@Override
	public Rectangle getShape() {
		return this.background;
	}

	@Override
	public void addStuff(Stuff stuff) {
		this.stuffToAdd.add(stuff);
		
	}

	@Override
	public void removeStuff(Stuff stuff) {
		this.stuffToRemove.add(stuff);
		
	}

	@Override
	public List<Drawable> getDrawableParts() {
		ArrayList<Drawable> draw = new ArrayList<>();
		draw.addAll(this.stuff);
		return draw;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}
	
	public Dimension getSize(){
		Dimension d = new Dimension(this.WIDTH, this.HEIGHT);
		return d;
	}
	
	public void changeLevel(boolean levelUp) {
		System.out.println(current);
		
		if(levelUp) {
			this.current++;
			this.readLevelFile("Level" + this.current + ".txt");
//			System.out.println(current);
//			this.current++;
		} else {
			this.readLevelFile("Level" + (this.current - 1) + ".txt");
			this.current--;
		}
		System.out.println(this.current);
		
		
	}
	
	public void readLevelFile(String filename) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			

			ArrayList<Stuff>  initialBoardLayout = new ArrayList<>();
			int counter = 0;
			int row = 0;
			int column = 0;
			for (int i = 0; i < this.NUMBER_OF_OBJECTS_HIGH*this.NUMBER_OF_OBJECTS_WIDE; i++) {
				if (counter%this.NUMBER_OF_OBJECTS_WIDE==0){
					row++;
					column=0;
				} else {
					column++;
				}
				counter++;
				
				
				
				Point2D.Double p = new Point2D.Double(column*this.WIDTH_OF_EACH_STUFF, row*this.HEIGHT_OF_EACH_STUFF);
				char currentChar = (char) br.read();
				if (currentChar=='d') {
					Dirt d = new Dirt(this, p, hero);
					initialBoardLayout.add(d);
					this.addStuff(d);
				} else if (currentChar=='O') {
					EmptySpace o = new EmptySpace(this, p);
					initialBoardLayout.add(o);
					this.addStuff(o);
				} else if (currentChar=='H') {
					Hero h = new Hero(this,p);
					this.addStuff(h);
					this.hero = h;
					initialBoardLayout.add(h);
				}
				this.stuff = initialBoardLayout;
			}
			
			System.out.println("FileRead");
//			System.out.println(initialBoardLayout);
			br.close();
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		} catch (IOException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		
	}
	
	public Hero getHero() {
		return this.hero;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return Color.BLACK;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public boolean getIsPaused() {
		// TODO Auto-generated method stub.
		return false;
	}

}