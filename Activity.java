/*Each activity has a name, a description, a cost and a capacity */
public class Activity {
    
    private String activityName;
    private String activityDescription;
    private double activityCost;
    private int activityCapacity;
    private Destination destination;
     public Activity(String activityName, String activityDescription, double activityCost, int activityCapacity, Destination destination){
        this.activityName = activityName;
        this.activityDescription = activityDescription;
        this.activityCost = activityCost;
        this.destination = destination;
     }
    public String getName(){
        return activityName;
    }
    public String getDescription(){
        return activityDescription;
    }
    public double getCost(){
        return activityCost;
    }
    public int getCapacity(){
      return  activityCapacity;
   }
//    Each Activity is Available at One Destination Only
    public Destination getDestination(){
        return destination;
    }
}
