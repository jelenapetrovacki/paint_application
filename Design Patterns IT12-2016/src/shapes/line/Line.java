package shapes.line;

import java.awt.Color;
import java.awt.Graphics;


import shapes.Shape;
import shapes.point.Point;

public class Line extends Shape  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1547664638114673337L;
	private Point startPoint;
	private Point endPoint;
	
	//	KONSTRUKTORI
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint, endPoint);
		setColor(color);
	}
	

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		startPoint.moveTo(x,y);
		endPoint.moveTo(x,y);
	}

	@Override
	public void moveFor(int forX, int forY) {
		// TODO Auto-generated method stub
		startPoint.moveFor(forX,forY);
		endPoint.moveFor(forX,forY);
	}
	
	// METODE DUZINA I SREDINA LINIJE
	public double length() {
		return startPoint.distance(endPoint);
	}
	public Point midLine(){
		int midX = (startPoint.getX() + endPoint.getX())/2;
		int midY = (startPoint.getY() + endPoint.getY())/2;
		Point middlePoint = new Point(midX, midY);
		return middlePoint;
	}
	
	// IMPLEMENTACIJA AP.M. IZ INTERFEJSA Comparable
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line){
			return (int) (this.length()-((Line) o).length());
		}
		else 
			return 0;
	}
	
	// IMPLEMENTACIJA AP.M. IZ AP.KLASE Shape
	
	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(isSelected())
			selectedShape(g);
	}

	@Override
	public void selectedShape(Graphics g) {
		g.setColor(Color.BLUE);
		startPoint.selectedShape(g);
		endPoint.selectedShape(g);
		midLine().selectedShape(g);
		
	}

	@Override
	public boolean containsPoint(int x, int y) {
		Point helpPoint = new Point(x, y);    //pomocna
		if(startPoint.distance(helpPoint)+endPoint.distance(helpPoint)-length() <= 1)
			return true;
		else 
			return false;
		
	}
	
	//	PREKLOPLJENJE METODE IZ KLASE Object
	
	public String toString() {
		return "LINE:("+startPoint.getX()+"-"+startPoint.getY() + ")->(" + endPoint.getX()+"-"+endPoint.getY()+")->"+getColor().toString();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line forwardLine = (Line) obj;
			if(startPoint.equals(forwardLine.startPoint) && endPoint.equals(forwardLine.endPoint))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	// GET I SET METODE
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public Line clone() {
		Line l = new Line();
		
		l.setStartPoint(new Point(this.getStartPoint().getX(),this.getStartPoint().getY()));
		
		l.setEndPoint(new Point(this.getEndPoint().getX(),this.getEndPoint().getY()));
		
		l.setColor(this.getColor());
		
		return l;
	}
}
