import java.time.temporal.Temporal;

public abstract class DigDugWorld implements DigDugEnvironment, Drawable, Temporal{
	boolean isPaused;
	private static final long UPDATE_INTERVAL_MS = 10;
//	private final int width;
//	private final int height;
}
//	private final List<Stuff> stuff = new ArrayList<Stuff>();
//	private final List<Stuff> stuffToAdd = new ArrayList<Stuff>();
//	private final List<Stuff> stuffToRemove = new ArrayList<Stuff>();
//	
//	public DigDugWorld(){
//		
//		this.background = new Rectangle2D.Double(0, 0, this.width, this.height)
//		Runnable tickTock = new Runnable() {
//			@Override
//			public void run() {
//				try {
//					while (true) {
//						Thread.sleep(UPDATE_INTERVAL_MS);
//						timePassed();
//					}
//				} catch (InterruptedException exception) {
//					// Stop when interrupted
//				}
//			}
//		};
//		new Thread(tickTock).start();
//	}
//	
//	public int lives(){
//		return 0;
//	}
//	public double score(){
//		return 0;
//	}
//
//	@Override
//	public synchronized void timePassed() {
//		if (!this.isPaused) {
//			for (Temporal t : this.balls) {
//				t.timePassed();
//			}
//			for(Temporal t : this.boxes) {
//				t.timePassed();
//			}
//		}
//		this.balls.removeAll(this.ballsToRemove);
//		this.ballsToRemove.clear();
//		this.balls.addAll(this.ballsToAdd);
//		this.ballsToAdd.clear();
//		this.boxes.removeAll(this.boxesToRemove);
//		this.ballsToRemove.clear();
//		this.boxes.addAll(this.boxesToAdd);
//		this.boxesToAdd.clear();
//		
//	}
//
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
//
//	@Override
//	public Shape getShape() {
//		return this.background;
//	}
//
//	@Override
//	public void addStuff(Stuff stuff) {
//		this.stuffToAdd.add(stuff);
//		
//	}
//
//	@Override
//	public void removeStuff(Stuff stuff) {
//		this.stuffToRemove.add(stuff);
//		
//	}
//
//	@Override
//	public List<Drawable> getDrawableParts() {
//		ArrayList<Drawable> draw = new ArrayList<Drawable>();
//		draw.addAll(this.stuff);
//		return draw;
//	}
//
//	@Override
//	public void readLevelFile(String filename) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void updateScore() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public long getLong(TemporalField arg0) {
//		// TODO Auto-generated method stub.
//		return 0;
//	}
//
//	@Override
//	public boolean isSupported(TemporalField arg0) {
//		// TODO Auto-generated method stub.
//		return false;
//	}
//
//	@Override
//	public boolean isSupported(TemporalUnit arg0) {
//		// TODO Auto-generated method stub.
//		return false;
//	}
//
//	@Override
//	public Temporal plus(long arg0, TemporalUnit arg1) {
//		// TODO Auto-generated method stub.
//		return null;
//	}
//
//	@Override
//	public long until(Temporal arg0, TemporalUnit arg1) {
//		// TODO Auto-generated method stub.
//		return 0;
//	}
//
//	@Override
//	public Temporal with(TemporalField arg0, long arg1) {
//		// TODO Auto-generated method stub.
//		return null;
//	}
//}
