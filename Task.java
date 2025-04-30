package smartfitnesstracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task extends JPanel {
	private JLabel index;
	private JTextField taskName;
	private JButton done;
	
	private boolean checked;
	Task(){
	this.setPreferredSize(new Dimension(200, 50));
    this.setBackground(Color.red);

    this.setLayout(new BorderLayout());

    checked = false;

    index = new JLabel("");
    index.setPreferredSize(new Dimension(50, 20));
    index.setHorizontalAlignment(JLabel.CENTER);
    this.add(index, BorderLayout.WEST);

    setTaskName(new JTextField("Clik to add a task here"));
    getTaskName().setBorder(BorderFactory.createEmptyBorder());
    getTaskName().setBackground(Color.red);

    this.add(getTaskName(), BorderLayout.CENTER);

    done = new JButton("done");
    done.setPreferredSize(new Dimension(50, 20));
    done.setBorder(BorderFactory.createEmptyBorder());

    this.add(done, BorderLayout.EAST);
	}
	public JButton getDone(){
		return done;
	}
	public void changeIndex(int num) {
		
		this.index.setText(num +"");
		this.revalidate();
	}
	
	public void changeState() {
		this.setBackground(Color.green);
		getTaskName().setBackground(Color.green);
		checked = true;
	}
	public boolean getState()
	{
		return checked;
	}
	public String getTaskText() {
	    return getTaskName().getText(); 
	}
	public JTextField getTaskName() {
		return taskName;
	}
	public void setTaskName(JTextField taskName) {
		this.taskName = taskName;
	}
	
}