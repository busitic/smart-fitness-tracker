package smartfitnesstracker;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;


public class ButtonPanel extends JPanel {
	JButton addnewtask, clearcompleted, save, load, back;
	
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	ButtonPanel(){
		this.setPreferredSize(new Dimension(400,60));
		
		
		
		
		
		//adding buttons
		this.add(Box.createVerticalStrut(20));
		addnewtask = new JButton("add new task");
		clearcompleted = new JButton("clear tasks");
		save =  new JButton("save");
		load =  new JButton("load");
		back =  new JButton("back");
		
		save.setBorder(emptyBorder);
		load.setBorder(emptyBorder);
		addnewtask.setBorder(emptyBorder);
		back.setBorder(emptyBorder);
		clearcompleted.setBorder(emptyBorder);
		
		this.add(addnewtask);
		this.add(clearcompleted);
		this.add(save);
		this.add(load);
		this.add(back);
	}
	public JButton getNewTask() {
		return addnewtask;
	}
	public JButton getClear() {
		return clearcompleted;
	}
	public JButton getSave() {
		return save;
	}
	public JButton getLoad() {
		return load;
	}
	public JButton getback() {
		return back;
	}

}