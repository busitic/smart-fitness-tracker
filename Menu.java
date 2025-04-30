package smartfitnesstracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Menu extends JFrame{
	private JButton track, goals, progress, report;
	private JPanel panel;
	Menu(){
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
        track = new JButton("Track Workout");
        goals = new JButton("Goals");
        progress = new JButton("Progress");
        report = new JButton("Report");

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 20)); // Layout the buttons vertically
        panel.setBorder(new EmptyBorder(30, 50, 30, 50));
        panel.add(track);
        panel.add(goals);
        panel.add(progress);
        panel.add(report);
        this.add(panel, BorderLayout.CENTER);
        
        
        track.setFont(new Font("Arial", Font.BOLD, 16));
		track.setBackground(new Color(0, 123, 255));
		track.setForeground(Color.BLACK);
		track.setFocusPainted(false);
		track.setPreferredSize(new Dimension(250, 50));
		track.setBorder(new EmptyBorder(10, 10, 10, 10));
		track.setOpaque(true);
		this.setVisible(true);
		
        
		goals.setFont(new Font("Arial", Font.BOLD, 16));
		goals.setBackground(new Color(0, 123, 255));
		goals.setForeground(Color.BLACK);
		goals.setFocusPainted(false);
		goals.setPreferredSize(new Dimension(250, 50));
		goals.setBorder(new EmptyBorder(10, 10, 10, 10));
		goals.setOpaque(true);
		this.setVisible(true);
		
		progress.setFont(new Font("Arial", Font.BOLD, 16));
		progress.setBackground(new Color(0, 123, 255));
		progress.setForeground(Color.BLACK);
		progress.setFocusPainted(false);
		progress.setPreferredSize(new Dimension(250, 50));
		progress.setBorder(new EmptyBorder(10, 10, 10, 10));
		progress.setOpaque(true);
		this.setVisible(true);
		
		
		 report.setFont(new Font("Arial", Font.BOLD, 16));
		 report.setBackground(new Color(0, 123, 255));
		 report.setForeground(Color.BLACK);
		 report.setFocusPainted(false);
		 report.setPreferredSize(new Dimension(250, 50));
		 report.setBorder(new EmptyBorder(10, 10, 10, 10));
		 report.setOpaque(true);
		this.setVisible(true);
        
        
        track.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                new Switchboard();
                dispose();
            }
        });

        goals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the class for "Goals" (replace with your actual class)
                new GoalsWindow();
                dispose();
            }
        });

       progress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the class for "Progress" (replace with your actual class)
                new ProgressWindow();
                dispose();
            }
        });

        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the class for "Report" (replace with your actual class)
                new BasicReport();
                dispose();
            }
        });

        // Make the JFrame visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	/*private JButton createStyledButton(String text) {
		JButton button = new JButton(text);
		track.setFont(new Font("Arial", Font.BOLD, 16));
		track.setBackground(new Color(0, 123, 255));
		track.setForeground(Color.BLACK);
		button.setFocusPainted(false);
		button.setPreferredSize(new Dimension(250, 50));
		button.setBorder(new EmptyBorder(10, 10, 10, 10));
		button.setOpaque(true);
		this.setVisible(true);
		
		return button;
	}*/
	
	
	
}