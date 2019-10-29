package shapes;

import model.DrawingModel;

public class CmdBringToFront implements Command {

	private Shape shape;
	private DrawingModel model;
	private int i;
	private String commandLog;
	
	public CmdBringToFront(Shape shape, DrawingModel model) {
		
		i = model.getAll().indexOf(shape);
		this.shape = shape;
		this.model = model;
	}
	
	@Override
	public void execute() {
		
		
		model.remove(shape);
		
		model.add(shape);
		
		
		commandLog= "BringToFRONT" + "_EXECUTE_"+ shape;
		

	}

	@Override
	public void unexecute() {
		
		model.remove(shape);
		
		model.addAt(i, shape);
		
	
		
		commandLog= "BringToFRONT" + "_UNEXECUTE_"+ shape;

	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
