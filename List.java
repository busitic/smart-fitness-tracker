package smartfitnesstracker;


import java.awt.Component;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class List extends JPanel {
	
	
	List(){
		
	GridLayout layout = new GridLayout(10,1);
	layout.setVgap(5);
	this.setLayout(layout);
	}
	
	public void updateNumbers() {
		Component[] listItems = this.getComponents();
		for(int i = 0; i< listItems.length; i++) 
		{
		if(listItems[i] instanceof Task) {
			((Task)listItems[i]).changeIndex(i+1);
		}	
		}
		revalidate();
	    repaint();
	}
	public void removeCompletedTasks()
	{
		
		for(Component c : getComponents())
		{
			if(c instanceof Task)
			{
				if(((Task)c).getState())
				{
					remove(c);
					updateNumbers();
				}
			}
		}
		
	}
	
	
	
	
	public void saveTasks() {
		JFileChooser fileChooser = new JFileChooser(new File("test file"));
		int result = fileChooser.showOpenDialog(this); 
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))){
			for(Component item : this.getComponents()) {
				 if (item instanceof Task) {
		                writer.write(((Task) item).getTaskText());
		                writer.newLine();
		                }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
	public void loadTasks() {
		JFileChooser fileChooser = new JFileChooser(new File("D:\\UNIVERSITY COURSEWORK\\test file"));
		int result = fileChooser.showOpenDialog(this); 
		if(result == JFileChooser.APPROVE_OPTION) {
		File selectedFile = fileChooser.getSelectedFile();
	    try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            Task task = new Task();
	            task.getTaskName().setText(line); 
	            this.add(task);
	            
	            
	            
	            task.getDone().addActionListener(e -> {
                    task.changeState();
                    this.revalidate();
                    this.repaint();
                });

                this.add(task);
            }

	        this.revalidate();
            this.repaint();
	        
	        
	        
	        
	        
	    } catch (IOException e) {
    	/*Object[] options = {"ok"};
	        
	        int n = JOptionPane.showOptionDialog(this,
	        	    "file not found",
	        	    "A Silly Question",
	        	    JOptionPane.YES_NO_CANCEL_OPTION,
	        	    JOptionPane.QUESTION_MESSAGE,
	        	    null,
	        	    options,//the titles of buttons
	        	    options[1]);//default button title
		 
		 if (n == 0) {		
	new Main();
	}*/
	    JOptionPane.showMessageDialog(null,"file not found", "error",JOptionPane.PLAIN_MESSAGE);
	    e.printStackTrace();
	    }
	}
		}
	public void loadTasks(File selectedFile) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            Task task = new Task();
	            task.getTaskName().setText(line); 
	            this.add(task);

	            task.getDone().addActionListener(e -> {
	                task.changeState();
	                this.revalidate();
	                this.repaint();
	            });
	        }
	        this.revalidate();
	        this.repaint();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "File could not be loaded", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}
	
}

