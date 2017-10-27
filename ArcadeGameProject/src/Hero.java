import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Hero extends Character{
	
	private Point2D.Double point;
	private int y;
	private int x;
	public Shape shape;
	public Point2D center;
	private Dimension size;
	private Color color;
	public int score;
	public int changeX;
	public int changeY;
	public Line2D.Double cord;

	public Hero(DigDugEnvironment world, Point2D.Double point) {
		super(world, point);
		this.point = point;
		this.changeX = 0;
		this.changeY = 0;
	}
	
	public void moveUp() {
		this.changeY = 1;
	}
	
	public void moveDown() {
		this.changeY = -1;
	}
	
	public void moveLeft() {
		this.changeX = -1;
	}
	
	public void moveRight() {
		this.changeX = 1;
	}

	@Override
	public Shape getShape() {
		return this.shape;
	}

	@Override
	public Point2D getCenterPoint() {
		return this.center;
	}

	@Override
	public void updatePosition() {
		this.x = this.x + this.changeX;
		this.y = this.y + this.changeY;
		this.point = new Point2D.Double(this.x, this.y);
	}

	@Override
	public void updateSize() {
		this.size = this.size;
	}

	@Override
	public void updateColor() {
		this.color = this.color;
		
	}

	@Override
	public double getscore() {
		return this.score;
	}
	
	public void extendCord() {
		this.cord = new Line2D.Double(new Point2D.Double(this.x, this.y), 
				new Point2D.Double(this.x + this.changeX*10, this.y + this.changeY*10));
	}

	@Override
	public Color getColor() {
		return this.color;
	}

}
