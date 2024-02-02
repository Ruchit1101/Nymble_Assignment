public class Activity {
    private
     String activityName;
     String activityDescription;
     double activityCost;
     int activityCapacity;
     Destination destination;
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
    public Destination getDestination(){
        return destination;
    }
}
