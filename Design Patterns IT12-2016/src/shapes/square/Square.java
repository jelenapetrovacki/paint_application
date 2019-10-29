package shapes.square;

import java.awt.Color;
import java.awt.Graphics;


import shapes.SurfaceShape;
import shapes.line.Line;
import shapes.point.Point;

public class Square extends SurfaceShape{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2804767573161370865L;
	protected Point upLeft;
	protected int side;
	
	//	KONSTRUKTORI
	
	public Square () {
		
	}
	public Square (Point upLeft,int side) {
		this.upLeft = upLeft;
		this.side = side;
	}
	public Square (Point upLeft,int side, Color color) {
		this(upLeft, side);
		setColor(color);
		//setBojaUnutrasnjosti(bojaUnutrasnosti);
		
	}
	public Square (Point upLeft,int side, Color color, Color innerColor) {
		this(upLeft, side, color);
		
		setInnerColor(innerColor);
		
	}
	
	
	
	//	METODE DIJAGONALA I CENTAR KVADRATA
	
	public Line diagonal() {
		Point downRight = new Point(upLeft.getX()+side, upLeft.getY()+side);
		return new Line(upLeft, downRight);
	}
	public Point center() {
		return diagonal().midLine();
	}
	
	
	//	IMPLEMENTACIJA AP.M. IZ INTERFEJSA Moveable
	
	
	@Override
	public void moveTo(int x, int y) {
		upLeft.moveTo(x, y);
		
	}

	@Override
	public void moveFor(int forX, int forY) {
		upLeft.moveFor(forX, forY);
		
	}
	//	IMPLEMENTACIJA AP.M. IZ INTERFEJSA Comparable
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Square){
			return (int) (this.surfaceArea()-((Square) o).surfaceArea());
		}
		else 
			return 0;
	}

	// IMPLEMENTACIJA AP.M. IZ AP.KLASE SurfaceShape
		
	@Override
	public double surfaceArea() {
		return side * side;
	}

	@Override
	public double volume() {
		return 4 * side;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upLeft.getX()+1, upLeft.getY()+1, side-1, side-1);
		
	}
	//	IMPLEMENTACIJA AP.M. IZ AP.KLASE Shape

	@Override
	public void drawShape(Graphics g) {
		fill(g);
		g.setColor(getColor());
		g.drawRect(upLeft.getX(), upLeft.getY(), side, side);
		
		if (isSelected())
			selectedShape(g);
		
	}

	@Override
	public void selectedShape(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(getUpLeft(), new Point(getUpLeft().getX()+side, getUpLeft().getY())).selectedShape(g);
		new Line(getUpLeft(), new Point(getUpLeft().getX(), getUpLeft().getY()+side)).selectedShape(g);
		new Line(new Point(getUpLeft().getX()+side, getUpLeft().getY()), diagonal().getEndPoint()).selectedShape(g);
		new Line(new Point(getUpLeft().getX(), getUpLeft().getY()+side), diagonal().getEndPoint()).selectedShape(g);
		
	}

	@Override
	public boolean containsPoint(int x, int y) {
		if(this.getUpLeft().getX()<=x && this.getUpLeft().getX() + side >=x 
				&& this.getUpLeft().getY()<=y && this.getUpLeft().getY() + side >=y)
			return true;
		else 
			return false;
	}
	
	//	GET I SET METODE
	
	public Point getUpLeft() {
		return upLeft;
	}
	public void setUpLeft(Point upLeft) {
		this.upLeft = upLeft;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	
	//	PREKLOPLJENE METODE IZ KLASE Object
	
	public String toString() {
		return "SQUARE:UpLeft(" + upLeft.getX()+","+upLeft.getY() + ") Side(" + side + ") "+getColor()+" "+getInnerColor();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Square) {
			Square forwardSquare = (Square) obj;
			if(upLeft.equals(forwardSquare.upLeft) && side == forwardSquare.side)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	// PREKLOPLJENA METODA INTERFEJSA Cloneable
	
	public Square clone() {
		Square s = new Square();
		
		s.setUpLeft(new Point(this.getUpLeft().getX(),this.getUpLeft().getY()));
		System.out.println(this.getSide() + "side");
		s.setSide(this.getSide());
		//s.setColor(this.getColor());
		//s.setInnerColor(this.getInnerColor());
		
		return s;
	}
}
