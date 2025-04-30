package smartfitnesstracker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GoalsWindow extends JFrame{
private JButton gain, lose, athlete, back;
private JLabel titleLabel;
private ButtonPanel btnpanel;
	GoalsWindow(){
		  this.setSize(400, 300);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLayout(new BorderLayout(10, 10));

	        // Title label at the top
	        titleLabel = new JLabel("What are your fitness tracking goals?", SwingConstants.CENTER);
	        this.add(titleLabel, BorderLayout.NORTH);

	        // Buttons
	        gain = new JButton("Gain Weight");
	        lose = new JButton("Lose Weight");
	        athlete = new JButton("Increase Athleticism");
	        btnpanel = new ButtonPanel();

	        Dimension buttonSize = new Dimension(120, 40);
	        gain.setPreferredSize(buttonSize);
	        lose.setPreferredSize(buttonSize);
	        athlete.setPreferredSize(buttonSize);

	        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Centered with gaps
	        buttonPanel.add(gain);
	        buttonPanel.add(lose);
	        buttonPanel.add(athlete);
	        
	        back = new ButtonPanel().getback(); 
	        this.add(back, BorderLayout.SOUTH);
	        
	        
	        
	        this.add(buttonPanel, BorderLayout.CENTER);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	        
	        gain.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Switchboard switchboard = new Switchboard();
	                String filepath = "Z:\\ztester folder\\weightgainprogram";
	                switchboard.loadProgram(filepath);
	                switchboard.setVisible(true);
	                dispose();  // Close this window
	            }
	        });
	        
	        lose.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Switchboard switchboard = new Switchboard();
	                String filepath = "Z:\\ztester folder\\weightlossprogram";
	                switchboard.loadProgram(filepath);
	                switchboard.setVisible(true);
	                dispose();  // Close this window
	            }
	        });
	        
	        athlete.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Switchboard switchboard = new Switchboard();
	                String filepath = "Z:\\ztester folder\\athleteprogram";
	                switchboard.loadProgram(filepath);
	                switchboard.setVisible(true);
	                dispose();  // Close this window
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
	}
	
}
