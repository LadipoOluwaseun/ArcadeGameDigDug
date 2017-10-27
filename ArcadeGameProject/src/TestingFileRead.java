import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.sg.prism.DirtyHint;
import com.sun.jndi.url.dns.dnsURLContext;

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
					Dirt d = new Dirt;
					initialBoardLayout.add(d);
				}
			}
			
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		
		
		
	}

}
