import java.util.*;

/*1.	Each travel package has a name, a passenger capacity, an itinerary
 (list of destinations) and a list of it's passenger */
public class TravelPackage{
   private String travelPackageName;
   private int passengerCapacity;
   private List<Destination> destinationsList;
   private List<Passenger> passengersList;

    public TravelPackage(String name, int cap, List<Destination>destinationsList){
        this.travelPackageName = name;
        this.passengerCapacity = cap;
        this.destinationsList = new ArrayList<>(destinationsList);
    }
   /*1. Print itinerary of the travel package including: 
        1. travel package name, 
        2. destinations  */
   public void printItinerary(){
    System.out.println("Travel Package Name: " + travelPackageName);
    System.out.print("Destinations List:- ");
    for(Destination dest: destinationsList){
        System.out.print(" -" + dest.getName());
        System.out.println(" Activies: ");
        //  details of the activities available at each destination, like name, cost, capacity and description..
        for(Activity activity: dest.getActivities()){
             System.out.print(" - Name: " + activity.getName());
             System.out.println(" Cost: "+ activity.getCost());
             System.out.println(" Capacity: " + activity.getCapacity());
             System.out.print(" Details of " + dest.getName());
             System.out.println(activity.getDescription());
        }
    }
   }
  /*  2. Print the passenger list of the travel package including: 
         1. package name, 
         2. passenger capacity, 
         3. number of passengers currently enrolled and 
         4. name and number of each passenger*/
   public void printpassengerList(){
     System.out.println("Travel Package Name: " + travelPackageName);
     System.out.println("Passenger Capacity: " + passengerCapacity);
     System.out.println("Number of enrolled Passengers " + passengersList.size());
     for(Passenger pas : passengersList){
        System.out.println("Passenger Name: " + pas.getName());
        System.out.println("Passenger Number: " + pas.getNumber());
     }
   }
   /*1.	Print the details of all the activities that still have spaces available, including how many spaces are available. */
   public void printAvailableActivities(){
     System.out.println("Activities with space are: ");
     for(Destination dest:destinationsList){
        for(Activity act : dest.getActivities()){
            int space = act.getCapacity() - countPassengerForActivity(act);
         
            if(space > 0){
                System.out.println("Activity name: " + dest.getName());
                System.out.println("Available Spaces: "+ space);
            }
        }
     }
   }
//    For counting activity of individual passengers
   private int countPassengerForActivity(Activity act){
    int count =0;
    for(Passenger pas: passengersList){
        if(pas.getActivities().contains(act))
          count += 1;
    }
    return count;
   }
}