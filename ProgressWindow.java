package smartfitnesstracker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProgressWindow extends JFrame {
  
    private JTextArea progressArea;
    private ArrayList<Workout> workoutList;
    
    
    public ProgressWindow() {
    	setTitle("Smart Fitness Tracker - Monitor Progress");
    	setSize(500, 400);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(new BorderLayout(10,10));
    	getContentPane().setBackground(new Color(240, 248, 255));
    	
    	JLabel titleLabel = new JLabel("Fitness Progress Summary", JLabel.CENTER);
    	titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
    	titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    	add(titleLabel, BorderLayout.NORTH);
    	
    	progressArea = new JTextArea();
    	progressArea.setEditable(false);
    	progressArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
    	progressArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    	JScrollPane scrollPane = new JScrollPane(progressArea);
    	scrollPane.setBorder(BorderFactory.createTitledBorder("Progress Details"));
    	
    	add(scrollPane, BorderLayout.CENTER);
    	
    	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
    	buttonPanel.setBackground(new Color(240, 248, 255));
    	
    	JButton refreshButton = new JButton("Refresh  Progress");
    	refreshButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
    	refreshButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			refreshProgress();
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
    	
    	showProgress();
    	
    	setVisible(true);
    	setLocationRelativeTo(null);
    }
    
   private void initializeWorkouts() {
	   workoutList = new ArrayList<>();
	   workoutList.add(new Workout("Running", 30, 300, "2025-04-26"));
	   workoutList.add(new Workout("Cycling", 45, 500, "2025-04-27"));
	   workoutList.add(new Workout("Gym", 60, 600, "2025-04-28"));
	   
   }
   
   private void showProgress() {
	   int totalDuration = 0;
	   double totalCalories = 0.0;
	   
	   for (Workout w : workoutList) {
	   totalDuration += w.getDurationMinutes();
	   totalCalories += w.getCaloriesBurned();
   }
   
   int numberOfWorkouts = workoutList.size();
   double avgCalories = numberOfWorkouts > 0 ? totalCalories / numberOfWorkouts : 0;
   
   progressArea.append("=== fitness Progress Summary ===\n");
   progressArea.append("Total Workouts: " + numberOfWorkouts + "\n");
   progressArea.append("Total Duration: " + totalDuration + " minutes\n");
   progressArea.append("Total Calories Burned: " + totalCalories + "Kcal\n");
   progressArea.append("Average Calories per Workout: " + String.format("%.2f", avgCalories)+"Kcal\n");
}

  private void refreshProgress() {
	  showProgress();
  } 
   

}
