package smartfitnesstracker;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class Titlebar extends JPanel {
	JLabel titleText;
	
	Titlebar(){
		this.setPreferredSize(new Dimension(400,100));
		
		
		titleText = new JLabel("To do list");
		titleText.setPreferredSize(new Dimension(200,80));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		this.add(titleText);
	}
	
	
	
}