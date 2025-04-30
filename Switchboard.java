package smartfitnesstracker;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Switchboard extends JFrame{

	private ButtonPanel btnpanel;
	private List list;
	private Titlebar title;
	
	private List taskList;
	
	private JButton addtask, clear, save, load, back;
	
	Switchboard(){
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
		
		title = new Titlebar();
		list = new List();
		btnpanel = new ButtonPanel();
		this.add(title, BorderLayout.NORTH);
		this.add(btnpanel,BorderLayout.SOUTH);
		
		this.add(list,BorderLayout.CENTER);
		
		
		
		addtask = btnpanel.getNewTask();
		clear = btnpanel.getClear();
		save = btnpanel.getSave(); 
		load = btnpanel.getLoad();
		back = btnpanel.getback();
		
		addListeners();
		
		
		 taskList = new List();
		
		this.setVisible(true);
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		addtask.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				Task task = new Task();
				list.add(task);
				list.updateNumbers();
				
				task.getDone().addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						task.changeState();
						revalidate();
					}
				});
				revalidate();
				repaint();
			}
			
		});
		
		clear.addMouseListener(new MouseAdapter()
		{
		    @Override
		    public void mousePressed(MouseEvent e)
		    {
		        list.removeCompletedTasks();
		        repaint();
		    }
		});
		
		save.addMouseListener(new MouseAdapter()
		{
		    @Override
		    public void mousePressed(MouseEvent e)
		    {
		       list.saveTasks();
		      
		    }
		});
		
		
		back.addMouseListener(new MouseAdapter()
		{
		    @Override
		    public void mousePressed(MouseEvent e)
		    {
		      new Menu();
		      dispose();
		      
		    }
		});
		
		
		
		load.addMouseListener(new MouseAdapter()
		{
		    @Override
		    public void mousePressed(MouseEvent e)
		    {
		       list.loadTasks();
		       list.revalidate();
		       repaint();
		    }
		});
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
	public void loadProgram(String filepath) {
	    File programFile = new File(filepath);
	    if (programFile.exists()) {
	        list.loadTasks(programFile);  // use the list from this class
	    } else {
	        JOptionPane.showMessageDialog(this, "Program file not found!", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
}