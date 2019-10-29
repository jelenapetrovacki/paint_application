package shapes;

import java.util.Collection;
import java.util.Collections;

import model.DrawingModel;

public class CmdToFront implements Command{

	private Shape shape;
	private DrawingModel model;
	private int i;
	private String commandLog;
	
	public CmdToFront(Shape shape, DrawingModel model) {
		
		i = model.getAll().indexOf(shape);
		this.shape = shape;
		this.model = model;
	}
	
	@Override
	public void execute() {
		
		if (i<model.getAll().size()-1) {
			Collections.swap(model.getAll(), i, i + 1);
			
			commandLog = "MoveToFRONT" + "_EXECUTE_" + model.get(i);
		}
		
		
	}

	@Override
	public void unexecute() {
		if (i >= 0) {
			Collections.swap(model.getAll(), i , i+1);
			
			commandLog = "MoveToFRONT" + "_UNEXECUTE_" + model.get(i);
		}
		
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
