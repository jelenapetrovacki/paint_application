package app;

import java.util.Iterator;

import javax.swing.JFrame;

import controller.DrawingController;
import frame.DrawingFrame;

import model.DrawingModel;

import shapes.UpdateNumberOfSelectedShapes;

public class DrawingApp {
	
	public static void main(String[] args) {
		
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		
		frame.getView().setModel(model);
		
		DrawingController controller = new DrawingController(model, frame);
		
		frame.setController(controller);

		UpdateNumberOfSelectedShapes up = new UpdateNumberOfSelectedShapes();
		controller.addObserver(up);
		
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

}
}
