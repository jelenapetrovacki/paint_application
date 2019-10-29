package controller;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import frame.DrawingFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.CmdAddShape;
import shapes.CmdBringToBack;
import shapes.CmdBringToFront;
import shapes.CmdDeleteAll;
import shapes.CmdDeleteShape;
import shapes.CmdToBack;
import shapes.CmdToFront;
import shapes.CmdUpdateShape;
import shapes.Command;
import shapes.Observer;
import shapes.Shape;
import shapes.Subject;

import shapes.circle.Circle;
import shapes.circle.DlgAddCircle;
import shapes.circle.DlgUpdateCircle;
import shapes.hexagon.DlgAddHexagon;
import shapes.hexagon.DlgUpdateHexagon;
import shapes.hexagon.HexagonAdapter;
import shapes.line.DlgUpdateLine;
import shapes.line.Line;
import shapes.point.DlgUpdatePoint;
import shapes.point.Point;
import shapes.rectangle.DlgAddRectangle;
import shapes.rectangle.DlgUpdateRectangle;
import shapes.rectangle.Rectangle;
import shapes.square.DlgAddSquare;
import shapes.square.DlgUpdateSquare;
import shapes.square.Square;
import strategy.Context;
import strategy.FileLog;
import strategy.FileSerialization;

public class DrawingController implements Subject {

	private DrawingModel model;
	private DrawingFrame frame;
	
	private String tglBtn;
	private String btn;
	
	private int NumberOfClicks = 0;
	private Point start;
	
	private int numberOfSelectedShapes;
	
	private ArrayList<Observer> observers;
	private ArrayList<Command> undoCommands;
	private ArrayList<Command> redoCommands;
		
	private String UndoOrRedo;
	private String positionZ;
	
	private DefaultListModel<String> log;
	private Context context;
	private FileLog fileLog;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		observers= new ArrayList<Observer>();
		undoCommands= new ArrayList<Command>();
		redoCommands= new ArrayList<Command>();
		log = frame.getDlmLogList();	
	}

	public void mouseClicked(MouseEvent a) {
					
		if(tglBtn != null) {
			
			CmdAddShape newShape;	 
			
			if(tglBtn.equals("Point"))
			{
				Point point = new Point(a.getX(), a.getY(),frame.getBtnBorderColor().getBackground());
				newShape = new CmdAddShape(point,model);
				doCmd(newShape);
				log.addElement(newShape.getCommandLog());
			}
			else if(tglBtn.equals("Line")) {
				if(NumberOfClicks == 0) {
					start = new Point(a.getX(),a.getY());
					NumberOfClicks = 1;
				}
				else if(NumberOfClicks == 1) {
					Line line = new Line(start,new Point(a.getX(),a.getY()),frame.getBtnBorderColor().getBackground());
					NumberOfClicks = 0;
					newShape = new CmdAddShape(line, model);
					doCmd(newShape);
					log.addElement(newShape.getCommandLog());
				}
				
				
			}
			else if(tglBtn.equals("Square")) {
				DlgAddSquare dlgS = new DlgAddSquare();
				dlgS.setVisible(true);
				if(dlgS.isAddCanceled()==false) {
					Square square = new Square(new Point(a.getX(), a.getY()),dlgS.getSideLength(),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());
					if (dlgS.getSideLength() > 0) {
						newShape = new CmdAddShape(square, model);
						doCmd(newShape);
						log.addElement(newShape.getCommandLog());
					}else if (dlgS.getSideLength() < 0)
						JOptionPane.showMessageDialog(null,"Value can't be negative","Warning",JOptionPane.ERROR_MESSAGE );
				}else
					log.addElement("Adding square canceled");
				
			}
			else if(tglBtn.equals("Rectangle")) {
				DlgAddRectangle dlgR = new DlgAddRectangle();
				dlgR.setVisible(true);
				if(dlgR.isAddCanceled()==false) {
					Rectangle rec = new Rectangle(new Point(a.getX(), a.getY()),dlgR.getWidthRectangle(),dlgR.getLengthRectangle(),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());
					System.out.println(frame.getBtnAreaColor().getBackground());
					if (dlgR.getWidthRectangle() > 0 && dlgR.getLengthRectangle() >0) {
						newShape = new CmdAddShape(rec, model);
						doCmd(newShape);
						log.addElement(newShape.getCommandLog());
					}else if (dlgR.getWidthRectangle() <= 0 || dlgR.getLengthRectangle() <=0 )
						JOptionPane.showMessageDialog(null,"Value can't be negative","Warning",JOptionPane.ERROR_MESSAGE );
				}else
					log.addElement("Adding rectangle canceled");
			}
			else if(tglBtn.equals("Circle")) {
				DlgAddCircle dlgC = new DlgAddCircle();
				dlgC.setVisible(true);
				if(dlgC.isAddCanceled()==false) {
					Circle circle = new Circle(new Point(a.getX(), a.getY()),dlgC.getRadiusCircle(),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());
					if (dlgC.getRadiusCircle() >0) {
						newShape = new CmdAddShape(circle, model);
						doCmd(newShape);
						log.addElement(newShape.getCommandLog());
					}else if (dlgC.getRadiusCircle() <= 0)
						JOptionPane.showMessageDialog(null,"Value can't be negative","Warning",JOptionPane.ERROR_MESSAGE );
				}else
					log.addElement("Adding circle canceled");
			}
			else if (tglBtn.equals("Hexagon")) {
				DlgAddHexagon dlgH = new DlgAddHexagon();
				dlgH.setVisible(true);
				if(dlgH.isAddCanceled()==false) {
					
					//HexagonAdapter hexagon = new HexagonAdapter(new Point(a.getX(), a.getY()),dlgH.getRadiusHexagon(),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());
					HexagonAdapter hexagon = new HexagonAdapter(new Hexagon(a.getX(), a.getY(),dlgH.getRadiusHexagon()),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());
					System.out.println(hexagon);
					if (dlgH.getRadiusHexagon() >0) {
						newShape = new CmdAddShape(hexagon, model);
						doCmd(newShape);
						log.addElement(newShape.getCommandLog());
						
					}else if (dlgH.getRadiusHexagon() <= 0)
						JOptionPane.showMessageDialog(null,"Value can't be negative","Warning",JOptionPane.ERROR_MESSAGE );
				}else
					log.addElement("Adding hexagon canceled");
				
			}else if(tglBtn.equals("Select")) {
				for (int i = model.getAll().size() - 1; i >=0; i--) {
					
					if(model.getAll().get(i).containsPoint(a.getX(), a.getY())==true) {
						if(model.getAll().get(i).isSelected()==false) {
							model.getAll().get(i).setSelected(true);
							setNumberOfSelectedShapes(getNumberOfSelectedShapes()+1);
							log.addElement("Select_" + model.get(i).toString());
							System.out.println(numberOfSelectedShapes);
							System.out.println(model.getAll().get(i).isSelected());
							i=0;
							//numberOfSelectedShapes++;
						}else {
							model.getAll().get(i).setSelected(false);
							setNumberOfSelectedShapes(getNumberOfSelectedShapes()-1);
							log.addElement("Deselect_" + model.get(i).toString());
							
							i=0;
						}
				
					}
								
				}
				
			}
			
			
			if(tglBtn.equals("Line") == false && NumberOfClicks == 1)
			{
				//u slucaju da sam odustala posle prvog klika prilikom crtanja linije
				NumberOfClicks = 0;
			}
		}
		

		frame.getView().repaint();

	}

	public void tglButtonClicked(String buttonName) {
		tglBtn = buttonName;
		
	}

	public int getNumberOfSelectedShapes() {
		return numberOfSelectedShapes;
	}

	public void setNumberOfSelectedShapes(int numberOfSelectedShapes) {
		this.numberOfSelectedShapes = numberOfSelectedShapes;
		
		notifyObservers(numberOfSelectedShapes,undoCommands.size(),redoCommands.size());
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers(int selected,int undo,int redo) {
		
		Iterator<Observer> it = observers.iterator();
		while(it.hasNext()) {
			it.next().update(frame,model,selected,undo,redo);
		}
				
	}
	
	//DO UNDO REDO
	public void doCmd(Command c) {
		
		redoCommands.removeAll(redoCommands);
		c.execute();
		undoCommands.add(c);
		notifyObservers(numberOfSelectedShapes,undoCommands.size(),redoCommands.size());
				
	}
	public void undoCmd() {
		
		Command cmd = undoCommands.get(undoCommands.size()-1);
		//deselectAll();
		
		undoCommands.get(undoCommands.size()-1).unexecute();
		if(cmd instanceof CmdAddShape)
		{
			if(((CmdAddShape) cmd).getShape().isSelected()==true)
			{
				((CmdAddShape) cmd).getShape().setSelected(false);
				setNumberOfSelectedShapes(getNumberOfSelectedShapes()-1);
			}
		}else if(cmd instanceof CmdDeleteShape)
		{
			if(((CmdDeleteShape) cmd).getShape().isSelected()==true)
			{
				//((CmdDeleteShape) cmd).getShape().setSelected(false);
				setNumberOfSelectedShapes(getNumberOfSelectedShapes()+1);
			}
		}
		if(cmd instanceof CmdAddShape)
			log.addElement(((CmdAddShape) cmd).getCommandLog());
		else if (cmd instanceof CmdDeleteShape)
			log.addElement(((CmdDeleteShape) cmd).getCommandLog());
		else if(cmd instanceof CmdUpdateShape)
			log.addElement(((CmdUpdateShape) cmd).getCommandLog());
		else if(cmd instanceof CmdToFront)
			log.addElement(((CmdToFront) cmd).getCommandLog());
		else if(cmd instanceof CmdBringToFront)
			log.addElement(((CmdBringToFront) cmd).getCommandLog());
		else if(cmd instanceof CmdBringToBack) 
			log.addElement(((CmdBringToBack) cmd).getCommandLog()); 
		else if(cmd instanceof CmdToBack)
			log.addElement(((CmdToBack) cmd).getCommandLog());
		
		if(cmd instanceof CmdDeleteAll) {
			int n = ((CmdDeleteAll) cmd).getShapes().size();
			setNumberOfSelectedShapes(getNumberOfSelectedShapes()+n);
			//
			System.out.println(n+"    "+getNumberOfSelectedShapes());
		}
		undoCommands.remove(undoCommands.size()-1);
		notifyObservers(numberOfSelectedShapes,undoCommands.size(),redoCommands.size());
		
		redoCommands.add(cmd);
		notifyObservers(numberOfSelectedShapes,undoCommands.size(),redoCommands.size());
		
	}
	public void redoCmd() {
		Command cmd = redoCommands.get(redoCommands.size()-1);
		
		redoCommands.get(redoCommands.size()-1).execute();
		/*if(cmd instanceof CmdUpdateShape)
		{
			if(((CmdUpdateShape) cmd).getShape().isSelected()==true)
			{
				((CmdUpdateShape) cmd).getShape().setSelected(false);
				setNumberOfSelectedShapes(getNumberOfSelectedShapes()-1);
			}
		}*/
		if(cmd instanceof CmdAddShape)
			log.addElement(((CmdAddShape) cmd).getCommandLog());
		else if (cmd instanceof CmdDeleteShape)
			log.addElement(((CmdDeleteShape) cmd).getCommandLog());
		else if(cmd instanceof CmdUpdateShape)
			log.addElement(((CmdUpdateShape) cmd).getCommandLog());
		else if(cmd instanceof CmdToFront)
			log.addElement(((CmdToFront) cmd).getCommandLog());
		else if(cmd instanceof CmdBringToFront)
			log.addElement(((CmdBringToFront) cmd).getCommandLog());
		else if(cmd instanceof CmdBringToBack)
			log.addElement(((CmdBringToBack) cmd).getCommandLog());
		else if(cmd instanceof CmdToBack)
			log.addElement(((CmdToBack) cmd).getCommandLog());
		
		if(cmd instanceof CmdDeleteAll) {
			int n = ((CmdDeleteAll) cmd).getShapes().size();
			setNumberOfSelectedShapes(getNumberOfSelectedShapes()-n);
			System.out.println(n+"    "+getNumberOfSelectedShapes());
		}
		
		redoCommands.remove(redoCommands.size()-1);
		undoCommands.add(cmd);
		notifyObservers(numberOfSelectedShapes,undoCommands.size(),redoCommands.size());
		
	}

	public void UndoRedo(String UndoOrRedo) {
		this.UndoOrRedo= UndoOrRedo;
		
		if(this.UndoOrRedo.equals("Undo")) {
			undoCmd();
		}else if(this.UndoOrRedo.equals("Redo")) {
			redoCmd();
		}
		frame.getView().repaint();
		
	}
	public void deselectAll() {
		for (int i = 0; i < model.getAll().size(); i++) {
			if(model.get(i).isSelected()==true)
			{
				model.get(i).setSelected(false);
				setNumberOfSelectedShapes(getNumberOfSelectedShapes()-1);
				
			}
			
		}
		frame.getView().repaint();
	}
	

	public void buttonClicked(String actionCommand) {
		btn = actionCommand; 
		
		Shape shape;
		CmdUpdateShape newShape;
		CmdDeleteShape deleteShape;
		CmdDeleteAll deleteAll;
		ArrayList<Shape> listOfSelected = new ArrayList<Shape>();
		Object[] options = {"Yes","No"};
		int n;
		
		if(btn.equals("Delete"))
		{
			for (int i = model.getAll().size() - 1; i >=0; i--) {
				
				if(model.get(i).isSelected()==true)
				{	
					listOfSelected.add(model.get(i));
					//model.get(i).setSelected(false);
					
				}
			}
			if(listOfSelected.size()==1) {
				n = JOptionPane.showOptionDialog(null,
					    "Are you sure you want to delete selected shape?",
					    "Delete Confirmation",
					    JOptionPane.YES_NO_OPTION,
					    JOptionPane.QUESTION_MESSAGE,
					    null,     //do not use a custom Icon
					    options,  //the titles of buttons
					    options[0]);
				
				if(n==0) {
					//for(int i = listOfSelected.size() - 1; i >=0; i--) {
						setNumberOfSelectedShapes(getNumberOfSelectedShapes()-1);
						deleteShape= new CmdDeleteShape(listOfSelected.get(0),model);
						doCmd(deleteShape);
						log.addElement(deleteShape.getCommandLog());
						//setNumberOfSelectedShapes(getNumberOfSelectedShapes()-1); 
					//}
				}
			}else if(listOfSelected.size()>1) {
				n = JOptionPane.showOptionDialog(null,
					    "Are you sure you want to delete selected shape?",
					    "Delete Confirmation",
					    JOptionPane.YES_NO_OPTION,
					    JOptionPane.QUESTION_MESSAGE,
					    null,     //do not use a custom Icon
					    options,  //the titles of buttons
					    options[0]);
				
				if(n==0) {
					
					//	int num = getNumberOfSelectedShapes();
						setNumberOfSelectedShapes(getNumberOfSelectedShapes()-listOfSelected.size());
						deleteAll= new CmdDeleteAll(listOfSelected,model);
						doCmd(deleteAll);
						log.addElement(deleteAll.getCommandLog());
						//setNumberOfSelectedShapes(getNumberOfSelectedShapes()-1); 
					
				}
			}
			
		}
		
		for (int i = 0; i < model.getAll().size(); i++) {
			if(model.get(i).isSelected()==true)
			{
				if(btn.equals("Modify")) {
					shape=model.get(i);
					
					if(shape instanceof Point)
					{
						
							DlgUpdatePoint dlg = new DlgUpdatePoint();
							dlg.getTxtXposition().setText(((Point) shape).getX()+"");
							dlg.getTxtYposition().setText(((Point) shape).getY()+"");
							dlg.getBtnBorderColor().setBackground(shape.getColor());
							dlg.setVisible(true);
							if(dlg.isUpdateCanceled()==false) {
								Point newPoint = new Point(dlg.getXposition(),dlg.getYposition(),dlg.getBorderColor());
								newShape = new CmdUpdateShape(model.get(i),newPoint);
								doCmd(newShape);
								model.get(i).setSelected(true);
								log.addElement(newShape.getCommandLog());
							}
							else {
								log.addElement("Point update canceled"); 
								
							}
							
							
						
					}
					else if(shape instanceof Line) {
						DlgUpdateLine dlg = new DlgUpdateLine();
						dlg.getTxtStartX().setText(((Line) shape).getStartPoint().getX()+"");
						dlg.getTxtStartY().setText(((Line) shape).getStartPoint().getY()+"");
						dlg.getTxtEndX().setText(((Line) shape).getEndPoint().getX()+"");
						dlg.getTxtEndY().setText(((Line) shape).getEndPoint().getY()+"");
						dlg.getBtnBorderColor().setBackground(shape.getColor());
						dlg.setVisible(true);
						if(dlg.isUpdateCanceled()==false) {
							Line newLine= new Line(new Point(dlg.getStartX(),dlg.getStartY()),new Point(dlg.getEndX(),dlg.getEndY()),dlg.getBorderColor());
							newShape = new CmdUpdateShape(model.get(i),newLine);
							doCmd(newShape);
							model.get(i).setSelected(true);
							log.addElement(newShape.getCommandLog()); 
						}else {
							log.addElement("Line update canceled"); 
						}
						
					}else if(shape instanceof Rectangle) {
						DlgUpdateRectangle dlg = new DlgUpdateRectangle();
						dlg.getTxtXpositon().setText(((Rectangle) shape).getUpLeft().getX()+"");
						dlg.getTxtYposition().setText(((Rectangle) shape).getUpLeft().getY()+"");
						dlg.getTxtSideLength().setText(((Rectangle) shape).getSide()+"");
						dlg.getTxtSideWidth().setText(((Rectangle) shape).getWidth()+"");
						dlg.getBtnBorderColor().setBackground(shape.getColor());
						dlg.getBtnAreaColor().setBackground(((Rectangle) shape).getInnerColor());
						dlg.setVisible(true);
						if(dlg.isUpdateCanceled()==false) {
							Rectangle newRec = new Rectangle(new Point(dlg.getXposition(),dlg.getYposition()),dlg.getSideWidth(),dlg.getSideLength(),dlg.getBorderColor(),dlg.getAreaColor());
							System.out.println(dlg.getAreaColor());
							newShape = new CmdUpdateShape(model.get(i),newRec);
							doCmd(newShape);
							model.get(i).setSelected(true);
							log.addElement(newShape.getCommandLog());
							
						}else {
							log.addElement("Recatangle update canceled"); 
						}
						
						
						
						
					}else if(shape instanceof Square) {
						DlgUpdateSquare dlg = new DlgUpdateSquare();
						dlg.getTxtXposition().setText(((Square) shape).getUpLeft().getX()+"");
						dlg.getTxtYposition().setText(((Square) shape).getUpLeft().getY()+"");
						dlg.getTxtSide().setText(((Square) shape).getSide()+"");
						dlg.getBtnBorderColor().setBackground(shape.getColor());
						dlg.getBtnAreaColor().setBackground(((Square) shape).getInnerColor());
						
						dlg.setVisible(true);
						if(dlg.isUpdateCanceled()==false) {
							Square newSquare = new Square(new Point(dlg.getXposition(),dlg.getYposition()),dlg.getSide(),dlg.getBorderColorSq(),dlg.getAreaColorSq());
							
							newShape = new CmdUpdateShape(model.get(i),newSquare);
							
							doCmd(newShape);
							model.get(i).setSelected(true);
							log.addElement(newShape.getCommandLog());
						}else {
							log.addElement("Square update canceled"); 
							
						}
						
					}else if(shape instanceof Circle) {
						DlgUpdateCircle dlg = new DlgUpdateCircle();
						
						dlg.getTxtXposition().setText(((Circle) shape).getCenter().getX()+"");
						dlg.getTxtYposition().setText(((Circle) shape).getCenter().getY()+"");
						dlg.getTxtRadius().setText(((Circle) shape).getRadius()+"");
						dlg.getBtnBorderColor().setBackground(shape.getColor());
						dlg.getBtnAreaColor().setBackground(((Circle) shape).getInnerColor());
						
						dlg.setVisible(true);
						System.out.println("kontroler krug 2  " + dlg.getXpositionc()  + dlg.getYpositionc()+dlg.getRadius());
						if(dlg.isUpdateCanceled()==false) {
							Circle newCircle = new Circle(new Point(dlg.getXpositionc(),dlg.getYpositionc()),dlg.getRadius(),dlg.getBorderColor(),dlg.getAreaColor());
							System.out.println("kontroler krug " + dlg.getXpositionc()  + dlg.getYpositionc()+dlg.getRadius());
							newShape = new CmdUpdateShape(model.get(i),newCircle);
												
							doCmd(newShape);
							model.get(i).setSelected(true);
							
							log.addElement(newShape.getCommandLog());
						}else {
							log.addElement("Circle update canceled"); 
						}
						
					}else if(shape instanceof HexagonAdapter) {
						DlgUpdateHexagon dlg = new DlgUpdateHexagon();
						dlg.getTxtXpositon().setText(((HexagonAdapter) shape).getHexagon().getX()+"");
						dlg.getTxtXpositon().setText(((HexagonAdapter) shape).getHexagon().getY()+"");
						dlg.getTxtRadius().setText(((HexagonAdapter) shape).getHexagon().getR()+"");
						
						dlg.getBtnBorderColor().setBackground(((HexagonAdapter) shape).getHexagon().getBorderColor());
						dlg.getBtnAreaColor().setBackground(((HexagonAdapter) shape).getHexagon().getAreaColor());
						dlg.setVisible(true);
						if(dlg.isUpdateCanceled()==false) {
							HexagonAdapter newHex = new HexagonAdapter(new Hexagon(dlg.getX(),dlg.getY(),dlg.getRadius()),dlg.getBorderColor(),dlg.getAreaColor());
							newShape = new CmdUpdateShape(model.get(i),newHex);
							
							
							doCmd(newShape);
							model.get(i).setSelected(true);
							log.addElement(newShape.getCommandLog());
						}else {
							log.addElement("Hexagon update canceled"); 
						}
					}
					
				}
				
			}
		}
		
		frame.getView().repaint();
		
	}

	public void positionZ(String btn) {
		positionZ = btn;
		
		for (int i = model.getAll().size() - 1; i >=0; i--) {
			if(model.get(i).isSelected()==true)
			{ 
				if(positionZ.equals("Bring To Front")) {
					CmdBringToFront bring = new CmdBringToFront(model.get(i), model);
					doCmd(bring);
					log.addElement(bring.getCommandLog());
				}else if(positionZ.equals("To Front")) {
					CmdToFront bring = new CmdToFront(model.get(i), model);
					doCmd(bring);
					log.addElement(bring.getCommandLog());
				}else if(positionZ.equals("To Back")) {
					CmdToBack bring = new CmdToBack(model.get(i), model);
					doCmd(bring);
					log.addElement(bring.getCommandLog());
					System.out.println(log);
					break;
				}else if(positionZ.equals("Bring To Back")) {
					CmdBringToBack bring = new CmdBringToBack(model.get(i), model);
					doCmd(bring);
					log.addElement(bring.getCommandLog());
					System.out.println(bring.getShape());
				}
				
				
			}
		}
		frame.getView().repaint();
	}

	public void save() {
		
		if (!model.getAll().isEmpty()) {
			frame.getChooser().setFileFilter(new FileNameExtensionFilter("SerializeDraw", "ser"));
			
		}
		if (!log.isEmpty()) {
			frame.getChooser().setFileFilter(new FileNameExtensionFilter("FileLog", "log"));
		}
		if(frame.getChooser().showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			if (frame.getChooser().getFileFilter().getDescription().equals("FileLog")) 
				context = new Context(new FileLog(frame, model, this));
			else if (frame.getChooser().getFileFilter().getDescription().equals("SerializeDraw")) 
				context = new Context(new FileSerialization(model));
			
			context.save(frame.getChooser().getSelectedFile());
		}
		frame.getChooser().setVisible(false);
	}

	public void openFile() {
		if(frame.getOpenChooser().showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			model.removeAll();
			log.removeAllElements();
			undoCommands.clear();
			redoCommands.clear();
			notifyObservers(numberOfSelectedShapes,undoCommands.size(),redoCommands.size());
			
			frame.getView().repaint();
			
			if (frame.getOpenChooser().getFileFilter().getDescription().equals("SerializeDraw")) {
				context = new Context(new FileSerialization(model));
				
			}
			else if (frame.getOpenChooser().getFileFilter().getDescription().equals("FileLog")) {
				fileLog = new FileLog(frame, model, this);
				context = new Context(fileLog);
				frame.getBtnGetLog().setEnabled(true);
			}
			
			context.open(frame.getOpenChooser().getSelectedFile());
			log.addElement("Imported file from "+frame.getOpenChooser().getSelectedFile().toString() );
		}	
		frame.getOpenChooser().setVisible(false);
		
	}

	public void readLine() {
	
		fileLog.getLine();
		
	}

	public ArrayList<Command> getUndoCommands() {
		return undoCommands;
	}

	public void setUndoCommands(ArrayList<Command> undoCommands) {
		this.undoCommands = undoCommands;
		
	}

	public ArrayList<Command> getRedoCommands() {
		return redoCommands;
	}

	public void setRedoCommands(ArrayList<Command> redoCommands) {
		this.redoCommands = redoCommands;
	}

	public DefaultListModel<String> getLog() {
		return log;
	}

	public void setLog(DefaultListModel<String> log) {
		this.log = log;
	}

	public Color takeColor(Color oldColor) {
		Color newColor = JColorChooser.showDialog(null, "Choose color", oldColor);
		if(newColor != null)
			return newColor;
		else {
			return oldColor;
		}
		
	}
	
	
	

	
}
