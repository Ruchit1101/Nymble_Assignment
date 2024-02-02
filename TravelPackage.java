import java.util.*;

public class TravelPackage{
   private
//    Travel Package List details
    String travelPackageName;
    int passengerCapacity;
    List<Destination> destinationsList;
    List<Passenger> passengersList;

    public TravelPackage(String name, int cap, List<Destination>destinationsList){
        this.travelPackageName = name;
        this.passengerCapacity = cap;
        this.destinationsList = new ArrayList<>(destinationsList);
    }
    // Printing all the Travel Package details accordingly
   public void printDestination(){
    System.out.println("Travel Package Name: " + travelPackageName);
    System.out.print("Destinations List:- ");
    for(Destination it: destinationsList){
        System.out.print(" -" + it.getName());
        System.out.println(" Activies: ");
        // Printing all the details of the destination as per given guidelines...
        for(Activity activity: it.getActivities()){
             System.out.print(" - Name: " + activity.getName());
             System.out.println(" Cost: "+ activity.getCost());
             System.out.println(" Capacity: " + activity.getCapacity());
             System.out.print(" Details of " + it.getName());
             System.out.println(activity.getDescription());
        }
    }
   }
}