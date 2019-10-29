package shapes.hexagon;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.plaf.SeparatorUI;

import hexagon.Hexagon;
import shapes.SurfaceShape;
import shapes.point.Point;

public class HexagonAdapter extends SurfaceShape {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4694146008771418802L;
	private Hexagon hexagon;
	public HexagonAdapter() {
		
	}
	public HexagonAdapter(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	public HexagonAdapter(Hexagon hexagon, Color outerColor, Color innerColor) {
		this(hexagon);
		//setColor(outerColor);
		hexagon.setBorderColor(outerColor);
		//setInnerColor(innerColor);
		hexagon.setAreaColor(innerColor);
	}
	public HexagonAdapter(Point startPoint,int radius) {
		
		hexagon = new Hexagon(startPoint.getX(),startPoint.getY(),radius);
	}
	public HexagonAdapter(Point startPoint,int radius,Color color) {
		this(startPoint,radius);
		setColor(color);
	}
	public HexagonAdapter(Point startPoint,int radius,Color color,Color innerColor) {
		this(startPoint,radius,color);
		setInnerColor(innerColor);
	}
	

	@Override
	public void moveTo(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);
		
	}

	@Override
	public void moveFor(int forX, int forY) {
		hexagon.setX(hexagon.getX() + forX);
		hexagon.setY(hexagon.getY() + forY);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Hexagon){
			Hexagon help  = (Hexagon) o;
			return this.hexagon.getR() - help.getR();
		}
		else 
			return 0;
		
	}

	@Override
	public double surfaceArea() {
		
		return 0;
	}

	@Override
	public double volume() {
		
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		
		
	}

	@Override
	public void drawShape(Graphics g) {
		hexagon.paint(g);
			
	}

	@Override
	public void selectedShape(Graphics g) {
		
	}

	@Override
	public boolean containsPoint(int x, int y) {
		return hexagon.doesContain(x, y);
	}
	public String toString() {
		return "HEXAGON:Center(" + hexagon.getX() + ","+hexagon.getY() + ") Radius(" + hexagon.getR() + ") "+hexagon.getBorderColor()+" "+hexagon.getAreaColor();
	}
	public boolean equals(Object obj) {
		//return hexagon.equals(obj);
		if(obj instanceof HexagonAdapter){
			Hexagon help = ((HexagonAdapter) obj).getHexagon();
			if(this.hexagon.getX()== help.getX()&& this.hexagon.getY()==help.getY() && this.hexagon.getR()==help.getR() &&
					this.hexagon.getBorderColor() == help.getBorderColor() && this.hexagon.getAreaColor() == help.getAreaColor())
				return true;
			else
				return false;
		}
		else 
			return false;
	}
	
	public HexagonAdapter clone() {
		HexagonAdapter h = new HexagonAdapter(new Hexagon(this.getHexagon().getX(),this.getHexagon().getY(),this.getHexagon().getR()),this.getHexagon().getBorderColor(),this.getHexagon().getAreaColor());
		
		
		return h;
	}
	
	public Hexagon getHexagon() {
		return hexagon;
	}
	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	@Override
	public boolean isSelected() {
		return hexagon.isSelected();
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		hexagon.setSelected(selected);
	}

}
