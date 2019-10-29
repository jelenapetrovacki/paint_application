package shapes;

import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;

public class CmdUpdateShape implements Command {

	private Shape oldState;
	private Shape newState;
	private Shape originalState;
	private String commandLog ;
	
	public CmdUpdateShape(Shape oldState, Shape newState) {
		
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		
		originalState=oldState.clone();
		
				
		if(oldState instanceof Point) {
			System.out.println(oldState+"old");
			System.out.println(newState + "new");
			((Point) oldState).setX(((Point) newState).getX());
			((Point) oldState).setY(((Point) newState).getY());
			System.out.println(oldState);
			oldState.setColor(newState.getColor()); 
			
		}
		else if(oldState instanceof Line) {

			((Line) oldState).getStartPoint().setX(((Line) newState).getStartPoint().getX());
			((Line) oldState).getStartPoint().setY(((Line) newState).getStartPoint().getY());
			((Line) oldState).getEndPoint().setX(((Line) newState).getEndPoint().getX());
			((Line) oldState).getEndPoint().setY(((Line) newState).getEndPoint().getY());
			oldState.setColor(newState.getColor());
		}
		else if(oldState instanceof Rectangle)
		{
			
			
			((Rectangle) oldState).getUpLeft().setX(((Rectangle) newState).getUpLeft().getX());
			((Rectangle) oldState).getUpLeft().setY(((Rectangle) newState).getUpLeft().getY());
			((Rectangle) oldState).setSide(((Rectangle) newState).getSide());
			((Rectangle) oldState).setWidth(((Rectangle) newState).getWidth());
			oldState.setColor(newState.getColor());
			((SurfaceShape) oldState).setInnerColor(((SurfaceShape) newState).getInnerColor());
		}
		else if(oldState instanceof Square) {
			
			((Square) oldState).getUpLeft().setX(((Square) newState).getUpLeft().getX());
			((Square) oldState).getUpLeft().setY(((Square) newState).getUpLeft().getY());
			((Square) oldState).setSide(((Square) newState).getSide());
			
			System.out.println(newState.getColor());
			oldState.setColor(newState.getColor());
			System.out.println(oldState.getColor());
			((SurfaceShape) oldState).setInnerColor(((SurfaceShape) newState).getInnerColor());
		}
		else if(oldState instanceof Circle) {

			((Circle) oldState).getCenter().setX(((Circle) newState).getCenter().getX());
			((Circle) oldState).getCenter().setY(((Circle) newState).getCenter().getY());
			((Circle) oldState).setRadius(((Circle) newState).getRadius());
			oldState.setColor(newState.getColor());
			((SurfaceShape) oldState).setInnerColor(((SurfaceShape) newState).getInnerColor());
		}
		else if(oldState instanceof HexagonAdapter) {

			((HexagonAdapter) oldState).getHexagon().setX(((HexagonAdapter) newState).getHexagon().getX());
			((HexagonAdapter) oldState).getHexagon().setY(((HexagonAdapter) newState).getHexagon().getY());
			((HexagonAdapter) oldState).getHexagon().setR(((HexagonAdapter) newState).getHexagon().getR());
			((HexagonAdapter) oldState).getHexagon().setBorderColor(((HexagonAdapter) newState).getHexagon().getBorderColor());
			((HexagonAdapter) oldState).getHexagon().setAreaColor(((HexagonAdapter) newState).getHexagon().getAreaColor());
			
		}
		//oldState.setSelected(false);
		
		commandLog= "UPDATE" + "_EXECUTE_"+ originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		//oldState=originalState.clone();
		
		if(oldState instanceof Point) {
			((Point) oldState).setX(((Point) originalState).getX());
			((Point) oldState).setY(((Point) originalState).getY());
			oldState.setColor(originalState.getColor()); 
			
		}
		else if(oldState instanceof Line) {

			((Line) oldState).getStartPoint().setX(((Line) originalState).getStartPoint().getX());
			((Line) oldState).getStartPoint().setY(((Line) originalState).getStartPoint().getY());
			((Line) oldState).getEndPoint().setX(((Line) originalState).getEndPoint().getX());
			((Line) oldState).getEndPoint().setY(((Line) originalState).getEndPoint().getY());
			oldState.setColor(originalState.getColor());
		}
		
		else if(oldState instanceof Square) {
			((Square) oldState).getUpLeft().setX(((Square) originalState).getUpLeft().getX());
			((Square) oldState).getUpLeft().setY(((Square) originalState).getUpLeft().getY());
			((Square) oldState).setSide(((Square) originalState).getSide());
			System.out.println("or"+originalState.getColor());
			oldState.setColor(originalState.getColor());
			
			System.out.println(oldState.getColor());
			((SurfaceShape) oldState).setInnerColor(((SurfaceShape) originalState).getInnerColor());
			//System.out.println("UNDO" + ((SurfaceShape) oldState).getInnerColor());
			System.out.println("UNDO" + ((SurfaceShape) oldState).getInnerColor());
		}else if(oldState instanceof Rectangle)
		{
			((Rectangle) oldState).getUpLeft().setX(((Rectangle) originalState).getUpLeft().getX());
			((Rectangle) oldState).getUpLeft().setY(((Rectangle) originalState).getUpLeft().getY());
			((Rectangle) oldState).setSide(((Rectangle) originalState).getSide());
			((Rectangle) oldState).setWidth(((Rectangle) originalState).getWidth());
			oldState.setColor(originalState.getColor());
			((SurfaceShape) oldState).setInnerColor(((SurfaceShape) originalState).getInnerColor());
		}
		else if(oldState instanceof Circle) {

			((Circle) oldState).getCenter().setX(((Circle) originalState).getCenter().getX());
			((Circle) oldState).getCenter().setY(((Circle) originalState).getCenter().getY());
			((Circle) oldState).setRadius(((Circle) originalState).getRadius());
			oldState.setColor(originalState.getColor());
			((SurfaceShape) oldState).setInnerColor(((SurfaceShape) originalState).getInnerColor());
		}
		else if(oldState instanceof HexagonAdapter) {

			((HexagonAdapter) oldState).getHexagon().setX(((HexagonAdapter) originalState).getHexagon().getX());
			((HexagonAdapter) oldState).getHexagon().setY(((HexagonAdapter) originalState).getHexagon().getY());
			((HexagonAdapter) oldState).getHexagon().setR(((HexagonAdapter) originalState).getHexagon().getR());
			((HexagonAdapter) oldState).getHexagon().setBorderColor(((HexagonAdapter) originalState).getHexagon().getBorderColor());
			((HexagonAdapter) oldState).getHexagon().setAreaColor(((HexagonAdapter) originalState).getHexagon().getAreaColor());
			
		}
		/*if(originalState.isSelected()) {
			oldState.setSelected(true);
		}*/
		commandLog= "UPDATE" + "_UNEXECUTE_"+ oldState + "->" + originalState;

	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

	public Shape getOldState() {
		return oldState;
	}

	public void setOldState(Shape oldState) {
		this.oldState = oldState;
	}

	public Shape getNewState() {
		return newState;
	}

	public void setNewState(Shape newState) {
		this.newState = newState;
	}

	public Shape getOriginalState() {
		return originalState;
	}

	public void setOriginalState(Shape originalState) {
		this.originalState = originalState;
	}

}
