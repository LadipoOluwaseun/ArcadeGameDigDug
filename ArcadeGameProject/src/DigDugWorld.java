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
	private final static int WIDTH = 450;
	private final static int HEIGHT = 450;
	private final static int DIRT_WIDTH = 15;
	private final static int DIRT_HEIGHT = 15;
	
	private List<Stuff> stuff = new ArrayList<>();
	private List<Stuff> stuffToAdd = new ArrayList<>();
	private List<Stuff> stuffToRemove = new ArrayList<>();
	private Rectangle background;
	
	private final static int NUMBER_OF_OBJECTS_WIDE = 15;
	private final static int NUMBER_OF_OBJECTS_HIGH = 15;
	private final static double WIDTH_OF_EACH_STUFF = 30;
	private final static double HEIGHT_OF_EACH_STUFF = 30;
	public int current;
	Hero hero;
	double score;
	private ArrayList<Dirt> dirtArray;
	private ArrayList<Enemy> enemyArray;
	private ArrayList<Rock> rockArray;
	private ArrayList<Fruit> fruitArray;
	private ArrayList<EmptySpace> emptySpaceArray;
	private ArrayList<Fygar> fygarArray;
	private static final int DISTANCE_TO_MOVE_HERO_WHEN_BUTTON_IS_PRESSED = 5;
	private boolean readingFile;
	private int rockArrayLength;
	private int numRocksFallen;
	private boolean levelUp;
	private int lives = 3;
	private ArrayList<Ice> iceArray;

	
	public DigDugWorld(int currentLevel, boolean levelUp){
		System.out.println("currentLevel = " + currentLevel);
		this.current = currentLevel;
		this.dirtArray = new ArrayList<>();
		this.enemyArray = new ArrayList<>();
		this.rockArray = new ArrayList<>();
		this.emptySpaceArray = new ArrayList<>();
		this.fygarArray = new ArrayList<>();
		this.fruitArray = new ArrayList<>();
		this.iceArray = new ArrayList<>();
		this.readingFile = false;
		this.rockArrayLength = 0;
//		this.current = 1;
		this.levelUp = levelUp;
		System.out.println("this.current = " + this.current);
		readLevelFile("Level" + currentLevel + ".txt");
		this.background = new Rectangle(0, 0, WIDTH, HEIGHT);
		this.numRocksFallen = 0;
		
//		this.hero = new Hero(this, new Point2D.Double(210, 120));
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
	public void addFruit() {
		this.stuffToAdd.addAll(this.fruitArray);
	}

	@Override
	public void removeStuff(Stuff stuff) {
		this.stuffToRemove.add(stuff);
		if(this.dirtArray.contains(stuff)) {
			this.dirtArray.remove(stuff);
			this.emptySpaceArray.add(new EmptySpace(this, 
					new Point2D.Double(stuff.getCenterPoint().getX()- WIDTH_OF_EACH_STUFF/2,
							stuff.getCenterPoint().getY() - HEIGHT_OF_EACH_STUFF/2)));
		}
		if(this.hero == stuff) {
			this.hero = new Hero(this, new Point2D.Double(210, 120));
		}
		if(this.enemyArray.contains(stuff)) {
			this.enemyArray.remove(stuff);
			if(this.enemyArray.isEmpty() && !this.readingFile) {
				this.changeLevel(true);
			}
		}
		if(this.fygarArray.contains(stuff)) {
			this.fygarArray.remove(stuff);
		}
		
		if(this.emptySpaceArray.contains(stuff)) {
			this.emptySpaceArray.remove(stuff);
		}
		
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

//	@Override
//	public void updateScore() {
//		// TODO Auto-generated method stub
//		
//	}
	
	public ArrayList<Dirt> getDirtArray(){
		return this.dirtArray;
	}
	
	public ArrayList<Fygar> getFygarArray() {
		return this.fygarArray;
	}
	
	public Dimension getSize(){
		Dimension d = new Dimension(WIDTH, HEIGHT);
		return d;
	}
	
	public void changeLevel(boolean levelUp) {
//		this.clearWorld();
		System.out.println(this.current);
		try{
		if(levelUp) {
			this.current++;
			if(this.current > 3) {
				this.current = 3;
			}
//			this.readLevelFile("Level" + this.current + ".txt", levelUp);
//			System.out.println("old this.current = " + this.current);
//			new DigDugWorld(this.current, levelUp);
			String[] args = new String[2];
//			String var = this.current + ' ';
			args[0] = Integer.toString(this.current);
			args[1] = Boolean.toString(levelUp);
			Main.main(args);
//			System.out.println(current);
//			this.current++;
		} else {
//			this.readLevelFile("Level" + (this.current - 1) + ".txt", levelUp);
			this.current--;
			if(this.current < 1) {
				this.current = 1;
			}
			String[] args = new String[2];
//			String var = this.current + ' ';
			args[0] = Integer.toString(this.current);
			args[1] = Boolean.toString(levelUp);
			Main.main(args);
//			new DigDugWorld(this.current, levelUp);
		}
		System.out.println(this.current);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
//	public int getLevel() {
//		return this.current;
//	}
	
//	public void clearWorld() {
//		ArrayList<Stuff> stuffList = new ArrayList<>();
//		stuffList.addAll(this.dirtArray);
//		stuffList.addAll(this.emptySpaceArray);
//		stuffList.addAll(this.enemyArray);
//		for(Stuff s: stuffList) {
//			this.removeStuff(s);
//		}
//		this.dirtArray = new ArrayList<>();
//		this.emptySpaceArray = new ArrayList<>();
//		this.enemyArray = new ArrayList<>();
//		this.rockArray = new ArrayList<>();
//		this.hero = new Hero(this, new Point2D.Double(210, 120));
//	}
	
	public void readLevelFile(String filename) {
		this.readingFile = true;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			

			ArrayList<Stuff>  initialBoardLayout = new ArrayList<>();
			int counter = 0;
			int row = 0;
			int column = 0;
			for (int i = 0; i < NUMBER_OF_OBJECTS_HIGH*NUMBER_OF_OBJECTS_WIDE; i++) {
				if (counter%NUMBER_OF_OBJECTS_WIDE==0){
					row++;
					column=0;
				} else {
					column++;
				}
				counter++;
				
				
				
				Point2D.Double q = new Point2D.Double(column*WIDTH_OF_EACH_STUFF, row*HEIGHT_OF_EACH_STUFF);
				char currentChar = (char) br.read();
				if (currentChar=='d') {
					Dirt d = new Dirt(this, q, this.hero);
					Dirt d1 = new Dirt(this, new Point2D.Double(q.getX()+DIRT_WIDTH, q.getY()), this.hero);
					Dirt d2 = new Dirt(this, new Point2D.Double(q.getX(), q.getY()+DIRT_HEIGHT), this.hero);
					Dirt d3 = new Dirt(this, new Point2D.Double(q.getX()+DIRT_WIDTH, q.getY()+DIRT_HEIGHT), this.hero);
					this.dirtArray.add(d);
					this.dirtArray.add(d1);
					this.dirtArray.add(d2);
					this.dirtArray.add(d3);
					initialBoardLayout.add(d);
					initialBoardLayout.add(d1);
					initialBoardLayout.add(d2);
					initialBoardLayout.add(d3);
					this.addStuff(d);
					this.addStuff(d1);
					this.addStuff(d2);
					this.addStuff(d3);
				} else if (currentChar=='O') {
					EmptySpace o = new EmptySpace(this, q);
//					this.emptySpaceArray.add(o);
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
					Enemy f = new Fygar(this, q, this.hero);
					this.enemyArray.add(f);
					this.fygarArray.add((Fygar) f);
					initialBoardLayout.add(f);
					this.addStuff(f);
				} else if (currentChar=='P') {
					Enemy p = new Pookas(this, q, this.hero);
					this.enemyArray.add(p);
					initialBoardLayout.add(p);
					this.addStuff(p);
				} else if (currentChar=='R'){
					Rock r = new Rock(this, q, this.hero);
					this.rockArray.add(r);
					initialBoardLayout.add(r);
					this.addStuff(r);
//				} else if (currentChar=='U'){
//					Fruit f = new Fruit(this, q, this.hero);
//					this.fruitArray.add(f);
//					initialBoardLayout.add(f);
//					this.addStuff(f);
				} else if (currentChar=='I') {
					Ice ice = new Ice(this, q, this.hero);
					this.iceArray.add(ice);
					initialBoardLayout.add(ice);
					this.addStuff(ice);
				}
				this.rockArrayLength = this.rockArray.size();
//				for(Enemy e: this.enemyArray) {
//					e.updatePosition(10, 10);
//				}
				this.stuff = initialBoardLayout;
			}
			this.readingFile = false;
			System.out.println("FileRead");
//			System.out.println(initialBoardLayout);
			br.close();
		} catch (FileNotFoundException exception) {
			if(this.levelUp){
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
	
	/**
	 * Returns the value of the field called 'iceArray'.
	 * @return Returns the iceArray.
	 */
	public ArrayList<Ice> getIceArray() {
		return this.iceArray;
	}


	/**
	 * Sets the field called 'iceArray' to the given value.
	 * @param iceArray The iceArray to set.
	 */
	public void setIceArray(ArrayList<Ice> iceArray) {
		this.iceArray = iceArray;
	}


	public Hero getHero() {
		return this.hero;
	}
	
	public int getLives(){
		return this.lives;
	}
	
	public void setLives(int nlives){
		this.lives = nlives;
	}
	public ArrayList<Enemy> getEnemyArray(){
		return this.enemyArray;
	}
	
	public ArrayList<Fruit> getFruitArray() {
		if(this.numRocksFallen>1 ) {
		Fruit f = new Fruit(this, this.hero);
		this.fruitArray.add(f);
		}
		return this.fruitArray;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return Color.BLACK;
	}

	@Override
	public void die() {
		//
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	@Override
	public boolean getIsPaused() {
		return this.isPaused;
	}


	@Override
	public Rectangle getShape() {
		// TODO Auto-generated method stub.
		return this.hero.getShape();
	}
	
	public double getScore(){
		return this.score;
	}


	@Override
	public void updateScore(double scoreAdd) {
		this.score = this.score + scoreAdd;
		
	}
	public boolean getReadingFile() {
		return this.readingFile;
	}
	
	public int getRockInitialCount() {
		return this.rockArrayLength;
	}


	/**
	 * Returns the value of the field called 'numRocksFallen'.
	 * @return Returns the numRocksFallen.
	 */
	public int getNumRocksFallen() {
		return this.numRocksFallen;
	}


	/**
	 * Sets the field called 'numRocksFallen' to the given value.
	 * @param numRocksFallen The numRocksFallen to set.
	 */
	public void setNumRocksFallen(int numRocksFallen) {
		this.numRocksFallen = numRocksFallen;
	}


	




}