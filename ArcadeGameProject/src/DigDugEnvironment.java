import java.util.List;

public interface DigDugEnvironment {
	void addStuff(Stuff stuff);
	
	void removeStuff(Stuff stuff);
	
	List<Drawable> getDrawableParts();
	
	void readLevelFile(String filename);
	
	void updateScore();
}
