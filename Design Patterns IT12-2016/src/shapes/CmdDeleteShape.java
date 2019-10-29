package shapes;

import model.DrawingModel;
import shapes.point.Point;

public class CmdDeleteShape implements Command {

	private Shape shape;
	private DrawingModel model;
	private String commandLog;
	
	public CmdDeleteShape(Shape shape, DrawingModel model) {
		
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		model.remove((Shape)shape);
		
		commandLog= "DELETE" + "_EXECUTE_"+ shape;

	}

	@Override
	public void unexecute() {
		model.add(shape);
		
		commandLog= "DELETE" + "_UNEXECUTE_"+ shape;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
