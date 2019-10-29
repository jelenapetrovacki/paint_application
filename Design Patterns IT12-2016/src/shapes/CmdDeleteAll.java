package shapes;

import java.util.ArrayList;

import model.DrawingModel;

public class CmdDeleteAll implements Command {

	private ArrayList<Shape> shapes;
	private DrawingModel model;
	private String commandLog;
	
	public CmdDeleteAll(ArrayList<Shape> shapes, DrawingModel model) {
		
		this.shapes = shapes;
		this.model = model;
	}
	
	@Override
	public void execute() {
		model.removeMore(shapes);
		commandLog= "DELETEshapes" + "_EXECUTE_"+ shapes;

	}

	@Override
	public void unexecute() {
		model.addAll(shapes);
		commandLog= "DELETEshapes" + "_UNEXECUTE_"+ shapes;

	}
	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

}
