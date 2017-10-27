import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * creates the world for all of the "Stuff" to be added to, where everything is implemented and controls 
 * are used
 * 
 * @author smithea2.
 *         Created Oct 27, 2017.
 */

public abstract class DigDugWorld implements DigDugEnvironment, Drawable, Temporal{
	boolean isPaused;
	private static final long UPDATE_INTERVAL_MS = 10;
	private final int WIDTH = 500;
	private final int HEIGHT = 600;
	
	private final int NUMBER_OF_OBJECTS_WIDE = 15;
	private final int NUMBER_OF_OBJECTS_HIGH = 15;
	
	private final List<Stuff> stuff = new ArrayList<Stuff>();
	private final List<Stuff> stuffToAdd = new ArrayList<Stuff>();
	private final List<Stuff> stuffToRemove = new ArrayList<Stuff>();
	private Shape background;
	
	public DigDugWorld(){
		
		this.background = new Rectangle2D.Double(0, 0, this.WIDTH, this.HEIGHT);
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

	public ArrayList<Stuff> readLevelFile(String filename) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			System.out.println((char)br.read());

			ArrayList<Stuff>  initialBoardLayout = new ArrayList<>();
			for (int i = 0; i < this.NUMBER_OF_OBJECTS_HIGH*this.NUMBER_OF_OBJECTS_WIDE; i++) {
				if ((char)br.read()=='d') {
					Dirt d = new Dirt(null, null);
					initialBoardLayout.add(d);
				} else if ((char)br.read()=='O') {
					EmptySpace o = new EmptySpace(null, null);
					initialBoardLayout.add(o);
				} else if ((char)br.read()=='H') {
					Hero h = new Hero(null, null);
					initialBoardLayout.add(h);
				}
				return initialBoardLayout;
			}
			
			System.out.println("FileRead");
			System.out.println(initialBoardLayout);
			br.close();
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		} catch (IOException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		
		return new ArrayList<Stuff>();
		
	}

	
//	@Override
//	public synchronized void timePassed() {
//		if (!this.isPaused) {
//			for (Temporal t : this.stuff) {
//				t.timePassed();
//			}
//		}
//		this.stuff.removeAll(this.stuffToRemove);
//		this.stuffToRemove.clear();
//		this.stuff.addAll(this.stuffToAdd);
//		this.stuffToAdd.clear();
//		this.stuffToRemove.clear();
//
//		
//	}

//	@Override
//	public void die() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setIsPaused(boolean isPaused) {
//		this.isPaused = isPaused;
//		
//	}
//
//	@Override
//	public boolean getIsPaused() {
//		return this.isPaused;
//	}

//	@Override
//	public Shape getShape() {
//		return this.background;
//	}

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
		ArrayList<Drawable> draw = new ArrayList<Drawable>();
		draw.addAll(this.stuff);
		return draw;
	}

//	@Override
//	public void readLevelFile(String filename) {
//		FileReader file = new FileReader(filename);
//		Scanner s = new Scanner(file);
//		
//		
//	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}
	
	public Dimension getSize(){
		Dimension d = new Dimension(this.WIDTH, this.HEIGHT);
		return d;
	}
}
