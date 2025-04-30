package smartfitnesstracker;

public class Workout {
  private String type;
  private int durationMinutes;
  private double caloriesBurned;
  private String date;
  
  public Workout(String type, int durationMinutes, double caloriesBurned, String date) {
	  this.type = type;
	  this.durationMinutes = durationMinutes;
	  this.caloriesBurned = caloriesBurned;
	  this.date = date;
  }
  
  public String getType() {
	  return type;
  }
  
  public int getDurationMinutes() {
		return durationMinutes;
	}
	 
  public double getCaloriesBurned() {
		 return caloriesBurned;
	}
	 
  public String getDate() {
	  return date;
  }	
}


