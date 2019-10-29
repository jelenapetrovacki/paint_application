package strategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.DrawingModel;
import shapes.Shape;

public class FileSerialization implements Strategy{

	private FileOutputStream outputFile;
	private FileInputStream inputFile;
	private DrawingModel model;
	
	public FileSerialization(DrawingModel model) {
		this.model = model;
	}
	
	@Override
	public void save(File file) {
		try {
			outputFile = new FileOutputStream(file + ".ser");
			ObjectOutputStream output = new ObjectOutputStream(outputFile);
			output.writeObject(model.getAll());
			output.close();
			outputFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void open(File file) {
		try {
			inputFile = new FileInputStream(file);
			ObjectInputStream input = new ObjectInputStream(inputFile);
			model.addAll((ArrayList<Shape>) input.readObject());
	       
	        input.close();
	        inputFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
