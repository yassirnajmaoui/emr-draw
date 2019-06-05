package models.file.strategy;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;

public class SaveTextStrategy implements SaveStrategy {

	@Override
	public void save(ShapeContainer shapeArray, ConnexionContainer connexionArray) {
		JFileChooser savebox = new JFileChooser();
		//savebox.setCurrentDirectory(new File("/src"));
		FileNameExtensionFilter ft = new FileNameExtensionFilter( "Text Files", "txt" );
		savebox.addChoosableFileFilter(ft);
		savebox.setAcceptAllFileFilterUsed(false);
		int retrival = savebox.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try { 
			FileWriter fw = new FileWriter(savebox.getSelectedFile()+".txt");
			fw.write(shapeArray.toString() + connexionArray.toString());
			fw.close();
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		System.out.println("Success...!");
		}			
	}
}

