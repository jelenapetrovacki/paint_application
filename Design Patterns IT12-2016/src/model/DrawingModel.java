package model;

import java.util.ArrayList;

import shapes.Shape;

public class DrawingModel {

	private ArrayList <Shape> listOfShapes = new ArrayList<Shape>();
	
	public void add (Shape s) {
		listOfShapes.add(s);
	}
	public void addAt (int i,Shape s) {
		listOfShapes.add(i, s);
	}
	public void addAll (ArrayList<Shape> list) {
		listOfShapes.addAll(list);
	}
	public void removeAll () {
		listOfShapes.removeAll(listOfShapes);
	}
	public void removeMore(ArrayList<Shape> list) {
		listOfShapes.removeAll(list);
	}
	public void remove(Shape s) { 
		
		listOfShapes.remove(s);
	}
	public ArrayList<Shape> getAll() {
		return listOfShapes;
	}
	public Shape get(int i) {
		 return listOfShapes.get(i);
	}
}
