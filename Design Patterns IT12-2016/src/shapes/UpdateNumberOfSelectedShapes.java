package shapes;


import controller.DrawingController;
import frame.DrawingFrame;
import model.DrawingModel;

public class UpdateNumberOfSelectedShapes implements Observer {

	
	DrawingController controler;
	
	
	@Override
	public void update(DrawingFrame frame, DrawingModel model,int numberOfSelectedShapes,int undoCmd,int redoCmd) {
		
		controler = new DrawingController(model, frame);
		
		
		
		frame.getBtnDelete().setEnabled(numberOfSelectedShapes>0);
		
		frame.getBtnUpdate().setEnabled(numberOfSelectedShapes==1);
		
		int numberOfShapes = model.getAll().size();
		frame.getBtnToBack().setEnabled(numberOfSelectedShapes==1 && numberOfShapes > 1);
		frame.getBtnToFront().setEnabled(numberOfSelectedShapes==1 && numberOfShapes > 1);
		frame.getBtnBringToBack().setEnabled(numberOfSelectedShapes==1 && numberOfShapes > 1);
		frame.getBtnBringToFront().setEnabled(numberOfSelectedShapes==1 && numberOfShapes > 1);
		
		frame.getBtnUndo().setEnabled(undoCmd>0);
		frame.getBtnRedo().setEnabled(redoCmd > 0);

	}

}
