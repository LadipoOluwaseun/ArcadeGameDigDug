import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import com.sun.javafx.geom.Rectangle;


/**
 * 
 * creates and implements methods of the hero in DigDugWorld.
 *
 * @author smithea2.
 *         Created Oct 26, 2017.
 */

public class Hero extends Stuff{
	
	private Point2D.Double point;
	private int y;
	private int x;
	public Rectangle shape;
	public Point2D center;
	private Dimension size;
	private Color color;
	public int score;
	public int changeX;
	public int changeY;
	public Line2D.Double cord;
	public Line2D.Double DEFAULT_CORD;
	public boolean cordExtended;
	public int WIDTH;
	public int HEIGHT;

	public Hero(DigDugEnvironment world, Point2D.Double point) {
		super(world, point);
		this.point = point;
		this.changeX = 0;
		this.changeY = 0;
		this.cordExtended = false;
		this.color = Color.CYAN;
		this.WIDTH = 30;
		this.HEIGHT = 30;
		this.shape = new Rectangle((int) point.getX(), (int) point.getY(), this.WIDTH, this.HEIGHT);
		this.DEFAULT_CORD = new Line2D.Double(new Point2D.Double(this.x, this.y), 
				new Point2D.Double(this.x, this.y));
		this.cord = this.DEFAULT_CORD;
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
	public Rectangle getShape() {
		return this.shape;
	}

	@Override
	public Point2D getCenterPoint() {
		return this.center;
	}

	public void updatePosition() {
		this.x = this.x + this.changeX;
		this.y = this.y + this.changeY;
		this.point = new Point2D.Double(this.x, this.y);
	}

	public void updateSize() {
		this.size = this.size;
	}

	@Override
	public double getscore() {
		return this.score;
	}
	
	public Line2D.Double extendCord() {
		this.cord = new Line2D.Double(new Point2D.Double(this.x, this.y), 
				new Point2D.Double(this.x + this.changeX*10, this.y + this.changeY*10));
		this.cordExtended = true;
		return this.cord;
	}
	
	public Line2D.Double retractCord() {
		this.cord = this.DEFAULT_CORD;
		return this.cord;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
	
	public Line2D.Double getCord(){
		return this.cord;    
	}

}
