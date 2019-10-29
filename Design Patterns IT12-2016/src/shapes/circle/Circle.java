package shapes.circle;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import shapes.SurfaceShape;
import shapes.line.Line;
import shapes.point.Point;

public class Circle extends SurfaceShape {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = -8709482182876785598L;
	private Point center;
	private int radius; //polupr
	
	//KONSTRUKTORI
	
	public Circle() {

	}
	public Circle(Point center, int radius) {
		
		this.center = center;
		this.radius = radius;
	}
	public Circle(Point center, int radius,Color color) {
		
		this(center, radius);
		setColor(color);
	}
	public Circle(Point center, int radius,Color color,Color innerColor) {
		
		this(center, radius,color);
		setInnerColor(innerColor);
	}

	
	//	IMPLEMENTACIJA AP.M. IZ INTERFEJSA Moveable
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}

	@Override
	public void moveFor(int forX, int forY) {
		center.moveFor(forX, forY);
		
	}

	
	//	IMPLEMENTACIJA AP.M. IZ INTERFEJSA Comparable
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle){
			return (int) (this.radius-((Circle) o).radius);
		}
		else 
			return 0;
	}

	//	IMPLEMENTACIJA AP.M. IZ AP.KLASE SurfaceShape
	
	@Override
	public double surfaceArea() {
		return radius*radius*Math.PI;
	}

	@Override
	public double volume() {
		return 2*radius*Math.PI;
	}

	@Override
	public void fill(Graphics g) {
		
		g.setColor(getInnerColor());
		g.fillOval(center.getX()-radius+1, center.getY()-radius+1, 2*radius-2, 2*radius-2);
		
	}

	//	IMPLEMENTACIJA AP.M. IZ AP.KLASE Shape
	
	@Override
	public void drawShape(Graphics g) {
		fill(g);
		g.setColor(getColor());
		g.drawOval(center.getX()-radius, center.getY()-radius, 2*radius, 2*radius);
		
		if(isSelected())
			selectedShape(g);
		
	}

	@Override
	public void selectedShape(Graphics g) {
		new Line(new Point(center.getX(), center.getY()-radius), 
				new Point(center.getX(), center.getY() + radius)).selectedShape(g);
		new Line(new Point(center.getX()-radius, center.getY()), 
				new Point(center.getX()+radius, center.getY())).selectedShape(g);
		
	}

	@Override
	public boolean containsPoint(int x, int y) {
		if(new Point(x,y).distance(getCenter())<=radius)
			return true;
		else
			return false;
	}
	
	
	//	PREKLOPLJENJE METODE IZ KLASE Object
	
	public String toString() {
		return "CIRCLE:Center(" + center.getX()+","+center.getY() + ") Radius(" + radius + ") "+getColor()+" "+getInnerColor();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle forwardCircle = (Circle) obj;
			if(center.equals(forwardCircle.center) && radius == forwardCircle.radius)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	//GET I SET
		
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	// PREKLOPLJENA METODA INTERFEJSA Cloneable
	
	public Circle clone() {
		Circle c = new Circle();
		
		c.setCenter(new Point(this.getCenter().getX(),this.getCenter().getY()));
		
		c.setRadius(this.getRadius());
		c.setColor(this.getColor());
		c.setInnerColor(this.getInnerColor());
		
		return c;
	}

}
