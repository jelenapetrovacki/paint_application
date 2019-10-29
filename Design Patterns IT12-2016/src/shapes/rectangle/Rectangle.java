package shapes.rectangle;

import java.awt.Color;
import java.awt.Graphics;

import shapes.line.Line;
import shapes.point.Point;
import shapes.square.Square;


public class Rectangle extends Square {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3043214007860198390L;
	private int width; //sirina

	
	// KONSTRUKTORI
	public Rectangle() {

	}
	
	public Rectangle(Point upLeft, int width, int height) {
		super.upLeft = upLeft;
		this.width = width;
		side = height;
	}
	
	public Rectangle(Point upLeft, int width, int height, Color color) {
		this(upLeft, width, height);
		setColor(color);
	}
	public Rectangle(Point upLeft, int width, int height, Color color, Color innerColor) {
		this(upLeft, width, height,color);
		setInnerColor(innerColor);
	}

	//	IMPLEMENTACIJA AP.M. IZ INTERFEJSA Moveable
	
	public void moveTo(int x, int y) {
		upLeft.moveTo(x, y);
	}
	public void moveFor(int forX, int forY) {
		upLeft.moveFor(forX, forY);
		
	}
	
	// 	PREKLOPLJENE METODE IZ KLASE Square !!!!
	
	public double surfaceArea() {
		return side * width;
	}
	public double volume() {
		return 2*side + 2*width;
	}
	public Line diagonal() {
		Point downRight = new Point(upLeft.getX()+width, upLeft.getY()+side);
		return new Line(upLeft, downRight);
	}
	public void drawShape(Graphics g) {
		fill(g);
		g.setColor(getColor());
		g.drawRect(upLeft.getX(), upLeft.getY(), width,side);
		if (isSelected())
			selectedShape(g);
	}
	public void selectedShape(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(getUpLeft(), new Point(getUpLeft().getX()+width, getUpLeft().getY())).selectedShape(g);
		new Line(getUpLeft(), new Point(getUpLeft().getX(), getUpLeft().getY()+side)).selectedShape(g);
		new Line(new Point(getUpLeft().getX()+width, getUpLeft().getY()), diagonal().getEndPoint()).selectedShape(g);
		new Line(new Point(getUpLeft().getX(), getUpLeft().getY()+side), diagonal().getEndPoint()).selectedShape(g);
	}
	public void fill(Graphics g) {
		
		g.setColor(getInnerColor());
		g.fillRect(upLeft.getX()+1, upLeft.getY()+1,  width-1,side-1);
	}
	public boolean containsPoint(int x,int y) {
		if(this.getUpLeft().getX()<=x && this.getUpLeft().getX() + width >=x 
				&& this.getUpLeft().getY()<=y && this.getUpLeft().getY() + side >=y)
			return true;
		else 
			return false;
	}
	
	//	PREKLOPLJENJE METODE IZ KLASE Object
	
	public String toString() {
		return "RECTANGLE:UpLeft(" + upLeft.getX()+","+upLeft.getY() + ") Side(" + side + ")"+ " Width(" + width + ") "+getColor()+" "+getInnerColor();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle forwardRectangle = (Rectangle) obj;
			if(upLeft.equals(forwardRectangle.upLeft) && 
					side == forwardRectangle.side && 
							width == forwardRectangle.width)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	
	//	GET I SET METODE
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	// PREKLOPLJENA METODA INTERFEJSA Cloneable
	
	
	public Rectangle clone() {
		System.out.println("ssss");
		Rectangle r = new Rectangle();
		
		r.setUpLeft(new Point(this.getUpLeft().getX(),this.getUpLeft().getY()));
		r.setSide(this.getSide());
		r.setWidth(this.getWidth());
		r.setColor(this.getColor());
		r.setInnerColor(this.getInnerColor());
		System.out.println(r);
		
		return r;
	}

}
