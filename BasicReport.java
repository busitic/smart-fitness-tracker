package smartfitnesstracker;

import javax.swing.*;

import smartfitnesstracker.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BasicReport extends JFrame {
  
	private JTextArea reportArea;
	private ArrayList<Workout> workoutList;
	
	public BasicReport() {
		setTitle("Smart Fitness Tracker - Basic Report");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
		getContentPane().setBackground(Color.WHITE);
		
		JLabel titleLabel = new JLabel("Fitness Activity Report", JLabel.CENTER);
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		add(titleLabel, BorderLayout.NORTH);
		
		reportArea = new JTextArea();
		reportArea.setEditable(false);
		reportArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(reportArea);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Report Summary"));
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
    	buttonPanel.setBackground(new Color(240, 248, 255));
    	
    	JButton refreshButton = new JButton("Refresh  Progress");
    	refreshButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
    	refreshButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			refreshProgress();
    		}

			private void refreshProgress() {
				// TODO Auto-generated method stub
				
			}
    	});
    	
    
    	
    	JButton backButton = new JButton("Back");
    	backButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
    	backButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    			new Menu();
    		}
    	});
    	
    	buttonPanel.add(refreshButton);
    	buttonPanel.add(backButton);
    	
    	add(buttonPanel, BorderLayout.SOUTH);
    	
		
		
		initializeWorkouts();
		generateReport();
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private void initializeWorkouts() {
		workoutList = new ArrayList<>();
		workoutList.add(new Workout("Running", 30, 300, "2025-04-26"));
		workoutList.add(new Workout("Cycling", 45, 500, "2025-04-27"));
		workoutList.add(new Workout("Gym", 60, 600, "2025-04-28"));
		
	}
	
	
	private void generateReport() {
		StringBuilder sb = new StringBuilder();
		
		int totalDuration = 0;
		double totalCalories = 0.0;
		
		sb.append("=== Workout Breakdown ===\n\n");
		
		
		for (Workout w : workoutList) {
			sb.append("Date: ").append(w.getDate()).append("\n");
			sb.append("Type: ").append(w.getType()).append("\n");
			sb.append("Duration: ").append(w.getDurationMinutes()).append("minutes\n");
			sb.append("Calories: ").append(w.getCaloriesBurned()).append(" kcal\n");
			sb.append("-----------------------");
			
			totalDuration += w.getDurationMinutes();
			totalCalories += w.getCaloriesBurned();
		}
		
		int numberOfWorkouts = workoutList.size();
		double avgCalories = numberOfWorkouts > 0 ? totalCalories / numberOfWorkouts : 0;
		
		sb.append("\n=== Summary ===\n");
		sb.append("Total Workouts: ").append(numberOfWorkouts).append("\n");
		sb.append("Total Duration: ").append(totalDuration).append(" minutes\n");
		sb.append("Total Calories Burned: ").append(totalCalories).append("Kcal\n");
		sb.append("Average Calories per Workout: ").append(String.format("%.2f", avgCalories)).append(" Kcal\n");
		
		reportArea.setText(sb.toString());
	}
	
	
	

}
