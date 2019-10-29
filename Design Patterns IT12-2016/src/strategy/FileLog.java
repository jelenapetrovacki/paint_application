package strategy;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.DefaultListModel;

import controller.DrawingController;
import frame.DrawingFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.CmdAddShape;
import shapes.CmdBringToBack;
import shapes.CmdBringToFront;
import shapes.CmdDeleteShape;
import shapes.CmdToBack;
import shapes.CmdToFront;
import shapes.CmdUpdateShape;
import shapes.Command;
import shapes.Shape;
import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;

public class FileLog implements Strategy {

	
	private DrawingFrame frame;
	private DrawingModel model;
	private DrawingController controller;
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public FileLog(DrawingFrame frame, DrawingModel model, DrawingController controller) {
		this.frame = frame;
		this.model = model;
		this.controller = controller;
	}
	
	
	@Override
	public void save(File file) {
		try {
			writer = new BufferedWriter(new FileWriter(file + ".log"));
			DefaultListModel<String> list = frame.getDlmLogList();
			for (int i = 0; i < frame.getDlmLogList().size(); i++) {
				writer.write(list.getElementAt(i));
				writer.newLine();
				
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void open(File file) {
		try {
			reader = new BufferedReader(new FileReader(file));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public void getLine() {
		try {
			
			String parseCommand = reader.readLine();
			if (parseCommand!=null && parseCommand.length()!=0) {
				System.out.println(parseCommand);
				String[] command = parseCommand.split("_");
				Command makeCmd = null;
				int i;
				switch (command[0]) {
				case "ADD":
					Shape shape = parseShape(command[2].split(":")[0], command[2].split(":")[1]);
					makeCmd = new CmdAddShape(shape, model);

					if (command[1].equals("EXECUTE")) {

						controller.doCmd(makeCmd);
						controller.getLog().addElement(((CmdAddShape) makeCmd).getCommandLog());

					} else if (command[1].equals("UNEXECUTE")) {
						controller.undoCmd();
						

					}
					
					frame.getView().repaint();
					break;
				case "UPDATE":
					Shape oldShape = parseShape(command[2].split("->")[0].split(":")[0],
							command[2].split("->")[0].split(":")[1]);
					Shape newShape = parseShape(command[2].split("->")[0].split(":")[0],
							command[2].split("->")[1].split(":")[1]);
					
					//System.out.println( model.getAll());
					//System.out.println(oldShape);
					
					
					if (command[1].equals("EXECUTE")) {

						i = model.getAll().indexOf(oldShape);
						makeCmd = new CmdUpdateShape(model.get(i), newShape);
						controller.doCmd(makeCmd);
						controller.getLog().addElement(((CmdUpdateShape) makeCmd).getCommandLog());
						

					} else if (command[1].equals("UNEXECUTE")) {
						//i = model.getAll().indexOf(newShape);
						//makeCmd = new CmdUpdateShape(oldShape, model.get(i));
						controller.undoCmd();
						

					}
					//

					frame.getView().repaint();
					break;
				case "DELETE":
					Shape delShape = parseShape(command[2].split(":")[0], command[2].split(":")[1]);
					System.out.println(model.getAll());
					System.out.println(delShape);
					System.out.println(model.getAll().indexOf(delShape));
					//i = model.getAll().indexOf(delShape);
					//makeCmd = new CmdDeleteShape(model.get(i), model);
					if (command[1].equals("EXECUTE")) {
						i = model.getAll().indexOf(delShape);
						makeCmd = new CmdDeleteShape(model.get(i), model);
						controller.doCmd(makeCmd);
						controller.getLog().addElement(((CmdDeleteShape) makeCmd).getCommandLog());

					} else if (command[1].equals("UNEXECUTE")) {
						//makeCmd = new CmdDeleteShape(delShape, model);
						controller.undoCmd();
						

					}
					
					frame.getView().repaint();
					break;
				case "MoveToFRONT":
					Shape toFrontShape = parseShape(command[2].split(":")[0], command[2].split(":")[1]);
					i = model.getAll().indexOf(toFrontShape);
					makeCmd = new CmdToFront(model.get(i), model);
					if (command[1].equals("EXECUTE")) {
						i = model.getAll().indexOf(toFrontShape);
						makeCmd = new CmdToFront(model.get(i), model);
						controller.doCmd(makeCmd);
						controller.getLog().addElement(((CmdToFront) makeCmd).getCommandLog());

					} else if (command[1].equals("UNEXECUTE")) {
						controller.undoCmd();
						
					}
					//controller.getLog().addElement(((CmdToFront) makeCmd).getCommandLog());
					frame.getView().repaint();
					break;
				case "MoveToBACK":
					Shape toBackShape = parseShape(command[2].split(":")[0], command[2].split(":")[1]);
					
					if (command[1].equals("EXECUTE")) {
						i = model.getAll().indexOf(toBackShape);
						makeCmd = new CmdToBack(model.get(i), model);
						controller.doCmd(makeCmd);
						controller.getLog().addElement(((CmdToBack) makeCmd).getCommandLog());

					} else if (command[1].equals("UNEXECUTE")) {
						controller.undoCmd();
						
					}
					//controller.getLog().addElement(((CmdToBack) makeCmd).getCommandLog());
					frame.getView().repaint();
					break;
				case "BringToFRONT": 
					Shape bringFrontShape = parseShape(command[2].split(":")[0], command[2].split(":")[1]);
					
					if (command[1].equals("EXECUTE")) {
						i = model.getAll().indexOf(bringFrontShape);
						makeCmd = new CmdBringToFront(model.get(i), model);
						controller.doCmd(makeCmd);
						controller.getLog().addElement(((CmdBringToFront) makeCmd).getCommandLog());

					} else if (command[1].equals("UNEXECUTE")) {
						controller.undoCmd();
						
					}
					//controller.getLog().addElement(((CmdBringToFront) makeCmd).getCommandLog());
					frame.getView().repaint();
					break;
				case "BringToBACK": 
					Shape bringBackShape = parseShape(command[2].split(":")[0], command[2].split(":")[1]);
					bringBackShape.setSelected(true);
					
					if (command[1].equals("EXECUTE")) {
						
						i = model.getAll().indexOf(bringBackShape);
						makeCmd = new CmdBringToBack(model.get(i), model);
						controller.doCmd(makeCmd);
						controller.getLog().addElement(((CmdBringToBack) makeCmd).getCommandLog());
						

					} else if (command[1].equals("UNEXECUTE")) {
						controller.undoCmd();
						
					}
					
					frame.getView().repaint();
					break;
				case "Select":
					Shape selShape = parseShape(command[1].split(":")[0], command[1].split(":")[1]);
					for (int j = model.getAll().size() - 1; j >=0; j--) {
						if(model.get(j).equals(selShape))
						{	model.get(j).setSelected(true);
							controller.setNumberOfSelectedShapes(controller.getNumberOfSelectedShapes()+1);
						}
					}
					controller.getLog().addElement("Select_" + command[1].toString());
					frame.getView().repaint();
					break;
				case "Deselect":
					Shape deselShape = parseShape(command[1].split(":")[0], command[1].split(":")[1]);
					for (int j = model.getAll().size() - 1; j >=0; j--) {
						if(model.get(j).equals(deselShape))
						{	model.get(j).setSelected(false);
						controller.setNumberOfSelectedShapes(controller.getNumberOfSelectedShapes()-1);
						}
					}
					controller.getLog().addElement("Deselect_" + command[1].toString());
					frame.getView().repaint();
					break;
				default:
					break;
				}
			}else 
			{	frame.getBtnGetLog().setEnabled(false);
				controller.getLog().addElement("------Completed------");
			}
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public Shape parseShape(String shape, String value) {
		switch(shape) {
		case "POINT":
			String [] values = value.split("-");
			String [] values2 = values[1].split(" ");
			
			return new Point(Integer.parseInt(values[0].substring(1)), Integer.parseInt(values2[0].substring(0,values2[0].length()-1)),parseColor(values2[1]));
		case "LINE":	
			String [] data = value.split("->");
			
			String [] point1 = data[0].split("-");
			
			String [] point2 = data[1].split("-");
			
			String col = data[2];
			
			return new Line(new Point(Integer.parseInt(point1[0].substring(1)),Integer.parseInt(point1[1].substring(0, point1[1].length()-1))),
					new Point(Integer.parseInt(point2[0].substring(1)),Integer.parseInt(point2[1].substring(0, point2[1].length()-1))),parseColor(col));
			
		
		case "CIRCLE":
			String [] a = value.split(" ");
			String [] center = a[0].split(",");
			int x = Integer.parseInt(center[0].substring(7));
			int y=Integer.parseInt(center[1].substring(0,center[1].length()-1));
			int radius = Integer.parseInt(a[1].substring(7,a[1].length()-1));
			
			Color col1 = parseColor(a[2]);
			Color col2 =parseColor(a[3]);
			
			return new Circle(new Point(x, y), radius, col1,col2);
		case "RECTANGLE":
			String [] e = value.split(" ");
			String [] upLeft = e[0].split(",");
			int x1 = Integer.parseInt(upLeft[0].substring(7));
			int y1 =Integer.parseInt(upLeft[1].substring(0,upLeft[1].length()-1));
			int side = Integer.parseInt(e[1].substring(5,e[1].length()-1));
			int width = Integer.parseInt(e[2].substring(6,e[2].length()-1));
			
			Color colRect = parseColor(e[3]);
			Color colRectArea =parseColor(e[4]);
			
			
			return new Rectangle(new Point(x1, y1), width, side,colRect,colRectArea );
		case "SQUARE":
			String [] t = value.split(" ");
			String [] upLeftSquare = t[0].split(",");
			int x2 = Integer.parseInt(upLeftSquare[0].substring(7));
			int y2 =Integer.parseInt(upLeftSquare[1].substring(0,upLeftSquare[1].length()-1));
			int sideSquare = Integer.parseInt(t[1].substring(5,t[1].length()-1));
			Color colSq = parseColor(t[2]);
			Color colSqArea = parseColor(t[3]);
			
			return new Square(new Point(x2, y2), sideSquare, colSq, colSqArea);
		case "HEXAGON":
			String [] hex = value.split(" ");
			String [] centerHex = hex[0].split(",");
			int x3 = Integer.parseInt(centerHex[0].substring(7));
			int y3=Integer.parseInt(centerHex[1].substring(0,centerHex[1].length()-1));
			int radiusHex = Integer.parseInt(hex[1].substring(7,hex[1].length()-1));
			Color colHex = parseColor(hex[2]);
			Color colHexArea = parseColor(hex[3]);
			
			return new HexagonAdapter(new Hexagon(x3, y3, radiusHex), colHex, colHexArea);
		default:
			return null;
		}
		
	}


	private Color parseColor(String string) {
		String colors = string.substring(15, string.length()-1);
		String [] rgb = colors.split(",");
		
		int r = Integer.parseInt(rgb[0].substring(2, rgb[0].length()));
		int g = Integer.parseInt(rgb[1].substring(2, rgb[1].length()));
		int b = Integer.parseInt(rgb[2].substring(2, rgb[2].length()));
		return new Color(r,g,b);
	}





	
	
	

}
