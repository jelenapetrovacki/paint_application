package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Shape implements Moveable, Comparable, Cloneable, Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8233851235496097855L;
	private Color color = Color.BLACK;
	private boolean selected;//false
	
	
	
	//	KONSTRUKTORI
	public Shape() {
		
	}
	public Shape(Color color) {
		this.color = color;
	}
	

	
	//	DEKLARACIJA APSTRAKTNIH METODA
	public abstract void drawShape(Graphics g);
	public abstract void selectedShape(Graphics g);
	public abstract boolean containsPoint(int x, int y);
	public abstract Shape clone();
	

	// GET I SET METODE
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
		
	}

}
