import java.awt.Color;
import java.awt.Shape;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class TestingFileRead implements DigDugEnvironment, Drawable, Temporal{
	private final int NUMBER_OF_OBJECTS_WIDE = 16;
	private final int NUMBER_OF_OBJECTS_HIGH = 16;

	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		
	}
	
	@Override
	public void readLevelFile(String filename) {
		FileReader file;
		try {
			file = new FileReader(filename);
			BufferedReader br = new BufferedReader(new FileReader("filename"));
			System.out.println((char)br.read());
			br.close();
			ArrayList<Stuff>  initialBoardLayout = new ArrayList<>();
			for (int i = 0; i < NUMBER_OF_OBJECTS_HIGH*NUMBER_OF_OBJECTS_WIDE; i++) {
				if ((char)br.read()=='d') {
					Dirt d = new Dirt(null, null);
					initialBoardLayout.add(d);
				}
			}
			
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		} catch (IOException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		
		
		
	}

	@Override
	public boolean isSupported(TemporalField field) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public long getLong(TemporalField field) {
		// TODO Auto-generated method stub.
		return 0;
	}

	@Override
	public boolean isSupported(TemporalUnit unit) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public Temporal with(TemporalField field, long newValue) {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public Temporal plus(long amountToAdd, TemporalUnit unit) {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public long until(Temporal endExclusive, TemporalUnit unit) {
		// TODO Auto-generated method stub.
		return 0;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public void addStuff(Stuff stuff) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void removeStuff(Stuff stuff) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public List<Drawable> getDrawableParts() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub.
		
	}

}
