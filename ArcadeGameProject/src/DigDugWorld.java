import java.awt.Shape;
import java.util.List;

public class DigDugWorld implements DigDugEnvironment, Drawable, Temporal{
	boolean isPaused;
	
	public DigDugWorld(){
		
	}
	
	public int lives(){
		return 0;
	}
	public double score(){
		return 0;
	}

	@Override
	public void timePassed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getIsPaused() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStuff(Stuff stuff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStuff(Stuff stuff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Drawable> getDrawableParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readLevelFile(String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}
}
