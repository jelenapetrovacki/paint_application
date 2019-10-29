package shapes;

import model.DrawingModel;

public class CmdBringToBack implements Command {

	
	private Shape shape;
	private DrawingModel model;
	private int i;
	private String commandLog;
	
	public CmdBringToBack(Shape shape, DrawingModel model) {
		
		i = model.getAll().indexOf(shape);
		this.shape = shape;
		this.model = model;
	}
	
	@Override
	public void execute() {
		
		i=model.getAll().indexOf(shape);
		System.out.println(i+ "  "+model.getAll().indexOf(shape));
		model.remove(shape);
		
		model.addAt(0,shape);
		
		
		commandLog= "BringToBACK" + "_EXECUTE_"+ shape;

	}

	@Override
	public void unexecute() {
		
		System.out.println(model.getAll().indexOf(shape));
		
		
		model.remove(shape);
		model.addAt(i, shape);
		
	System.out.println(i+ "  "+model.getAll().indexOf(shape));
		
		commandLog= "BringToBACK" + "_UNEXECUTE_"+ shape;

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
