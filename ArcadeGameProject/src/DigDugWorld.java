import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.sun.javafx.geom.Rectangle;

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
	private ArrayList<Dirt> dirtArray;
	private ArrayList<Enemy> enemyArray;
	private ArrayList<Rock> rockArray;
	private static final int DISTANCE_TO_MOVE_HERO_WHEN_BUTTON_IS_PRESSED = 5;

	
	public DigDugWorld(){
		this.dirtArray = new ArrayList<>();
		this.enemyArray = new ArrayList<>();
		this.rockArray = new ArrayList<>();
		this.current = 1;
		readLevelFile("Level" + this.current + ".txt", true);
		this.background = new Rectangle(0, 0, this.WIDTH, this.HEIGHT);
		Runnable tickTock = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(UPDATE_INTERVAL_MS);
						timePassed();
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

	public static int getDistanceToMoveHeroWhenButtonIsPressed() {
		return DISTANCE_TO_MOVE_HERO_WHEN_BUTTON_IS_PRESSED;
	}

	@Override
	public void addStuff(Stuff stuff) {
		this.stuffToAdd.add(stuff);
		
	}

	@Override
	public void removeStuff(Stuff stuff) {
		this.stuffToRemove.add(stuff);
		
	}
	
	public ArrayList<Rock> getRockArray() {
		return this.rockArray;
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
	
	public ArrayList<Dirt> getDirtArray(){
		return this.dirtArray;
	}
	
	public Dimension getSize(){
		Dimension d = new Dimension(this.WIDTH, this.HEIGHT);
		return d;
	}
	
	public void changeLevel(boolean levelUp) {
		System.out.println(this.current);
		try{
		if(levelUp) {
			this.current++;
			this.readLevelFile("Level" + this.current + ".txt", levelUp);
//			System.out.println(current);
//			this.current++;
		} else {
			this.readLevelFile("Level" + (this.current - 1) + ".txt", levelUp);
			this.current--;
		}
		System.out.println(this.current);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void readLevelFile(String filename, boolean levelUp) {

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
				
				
				
				Point2D.Double q = new Point2D.Double(column*this.WIDTH_OF_EACH_STUFF, row*this.HEIGHT_OF_EACH_STUFF);
				char currentChar = (char) br.read();
				if (currentChar=='d') {
					Dirt d = new Dirt(this, q, this.hero);
					this.dirtArray.add(d);
					initialBoardLayout.add(d);
					this.addStuff(d);
				} else if (currentChar=='O') {
					EmptySpace o = new EmptySpace(this, q);
					initialBoardLayout.add(o);
					this.addStuff(o);
				} else if (currentChar=='H') {
					Hero h = new Hero(this,q);
//					Thread thread = new Thread(h);
//					thread.start();
					this.addStuff(h);
					this.hero = h;
					initialBoardLayout.add(h);
				} else if (currentChar=='F') {
					Fygar f = new Fygar(this, q, this.hero);
					this.enemyArray.add(f);
					initialBoardLayout.add(f);
					this.addStuff(f);
				} else if (currentChar=='P') {
					Pookas p = new Pookas(this, q, this.hero);
					this.enemyArray.add(p);
					initialBoardLayout.add(p);
					this.addStuff(p);
				} else if (currentChar=='R'){
					Rock r = new Rock(this, q, this.hero);
					this.rockArray.add(r);
					initialBoardLayout.add(r);
					this.addStuff(r);
				}
				this.stuff = initialBoardLayout;
			}
			
			System.out.println("FileRead");
//			System.out.println(initialBoardLayout);
			br.close();
		} catch (FileNotFoundException exception) {
			if(levelUp){
			this.current--;}
			else {
				this.current++;
			}
			// TODO Auto-generated catch-block stub.
//			exception.printStackTrace();
		} catch (IOException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		
	}
	
	public Hero getHero() {
		return this.hero;
	}
	
	public ArrayList<Enemy> getEnemyArray(){
		return this.enemyArray;
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


	@Override
	public Rectangle getShape() {
		// TODO Auto-generated method stub.
		return hero.getShape();
	}





}