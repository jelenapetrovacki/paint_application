package shapes.point;

import java.awt.Color;
import java.awt.Graphics;

import model.DrawingModel;
import shapes.Shape;

public class Point extends Shape {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1495426378760059668L;
	private int x;
	private int y;

	//	KONSTRUKTORI
	
	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, Color color) {
		this(x, y);
		
		setColor(color);
	}	
	
	//	IMPLEMENTACIJA APSTRAKTNIH METODA IZ INTERFEJSA Moveable
	
	public void moveTo(int x, int y) {
		this.x = x;
		setY(y);
	}
	public void moveFor(int poX, int poY) {
		this.x += poX;
		this.y = this.y + poY;
	}
	
	// METODA UDALJENOST
	
	public double distance(Point t) {
		int dX = x - t.x;
		int dY = t.y - y;
		double d = Math.sqrt(dX*dX + dY*dY);
		return d;
	}
	 
	//	IMPLEMENTACIJA APSTAKTNIH METODA IZ APSTAKTNE KLASE Shape
	
	public void drawShape(Graphics g) {
		//g.setColor(pronadjiBoju(getBoja()));
		g.setColor(getColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y+2, x, y-2);
		
		if(isSelected()) //true
			selectedShape(g);//ako kad crtam tacku hocu i da je automatski selektovana pozivam ovo da bi isrtao plave kvadratice
	
	}
	
	public void selectedShape(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
		
	}
	public boolean containsPoint(int x,int y ) {
		if(this.distance(new Point(x, y))<=2)
			return true;
		else
			return false;
	}
	
	//	IMPLEMENTACIJA AP.M. IZ INTERFEJSA Comaparable
	
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point startPoint = new Point(0, 0);
			return (int) (this.distance(startPoint) - ((Point) o).distance(startPoint));
		}
		else
			return 0;
	}
	
	//	GET I SET METODE
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	//	PREKLOPLJENE METODE KLASE Object
	
	public String toString() {
		return "POINT:"+"(" + x + "-" + y + ") "+getColor().toString();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point forwardPoint = (Point)obj;   ///prosledjena tacka
			if (x==forwardPoint.getX() &&
				y==forwardPoint.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	// PREKLOPLJENA METODA INTERFEJSA Cloneable
	
	public Point clone() {
		Point p = new Point();
		
		p.setX(this.getX());
		p.setY(this.getY());
		p.setColor(this.getColor());
		
		System.out.println("Metoda clone"+p);
		
		return p;
	}

}
