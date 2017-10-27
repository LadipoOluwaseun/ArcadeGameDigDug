import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public abstract class DigDugWorld implements DigDugEnvironment, Drawable, Temporal{
	boolean isPaused;
	private static final long UPDATE_INTERVAL_MS = 10;
	private final int WIDTH = 500;
	private final int HEIGHT = 600;
	
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
