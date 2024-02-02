import java.util.*;

/*2.	Each destination has a name, and a list of the activities available at that destination. */
public class Destination {
     
    private String destinationName;
    private List<Activity>activities;
    private List<Passenger> passengers;

    public Destination(String destinationName){
      this.destinationName = destinationName;
      this.activities = new ArrayList<>();
      this.passengers = new ArrayList<>();
    }
    public String getName(){
        return destinationName;
    }
    public void addActivity(Activity activity){
        activities.add(activity);
    }
    public List<Activity> getActivities(){
        return activities;
    }
    public List<Passenger> getPassengers(){
        return passengers;
    }
}
