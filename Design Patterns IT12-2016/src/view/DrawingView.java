package view;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import model.DrawingModel;
import shapes.Shape;
import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.rectangle.Rectangle;
import shapes.square.Square;

public class DrawingView extends JPanel {
	
	private DrawingModel model;

	public void setModel(DrawingModel model) {
		this.model = model;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Shape currentShape;
		if (model != null) {
			Iterator<Shape> it = model.getAll().iterator();

			while (it.hasNext()) {
				
				currentShape = it.next();
				
				currentShape.drawShape(g);
				
			}
		}
	}

}
