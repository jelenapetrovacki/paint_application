package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShape extends Shape {
	
	private Color innerColor = Color.WHITE;
	
		
	//	DEKLARACIJA APSTRAKTNIH METODA
	public abstract double surfaceArea(); 
	public abstract double volume(); 
	public abstract void fill(Graphics g);
	
	//	GET I SET METODE
	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

}
