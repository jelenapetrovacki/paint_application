package shapes;

import java.util.Collections;

import model.DrawingModel;

public class CmdToBack implements Command {

	

	private Shape shape;
	private DrawingModel model;
	private int i;
	private String commandLog;
	
	public CmdToBack(Shape shape, DrawingModel model) {
		
		i = model.getAll().indexOf(shape);
		this.shape = shape;
		this.model = model;
	}
	
	@Override
	public void execute() {
		if(i!=0) {
			Collections.swap(model.getAll(), i, i-1);
			
			commandLog= "MoveToBACK" + "_EXECUTE_"+ model.get(i-1);
			
			
		}
	}

	@Override
	public void unexecute() {
		if(i<=model.getAll().size()-1) {
			Collections.swap(model.getAll(), i, i-1);
			
			commandLog= "MoveToBACK" + "_UNEXECUTE_"+ model.get(i);
		}
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

}
