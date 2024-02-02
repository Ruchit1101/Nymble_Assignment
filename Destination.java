import java.util.*;

public class Destination {
    private 
         String destinationName;
         List<Activity>activities;
    
    public Destination(String destinationName){
      this.destinationName = destinationName;
      this.activities = new ArrayList<>();
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
}
