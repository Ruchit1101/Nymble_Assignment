import java.util.*;

public class Passenger {
    private
     String passengerName;
     int passengerNumber;
     PassengerType type;
     double passengerBalance;
     List<Activity> activities;

   public Passenger(String passengerName, int passengerNumber, PassengerType type){
      this.passengerName = passengerName;
      this.passengerNumber=passengerNumber;
      this.type = type;
      this.passengerBalance = 0.0;
      this.activities = new ArrayList<>();
   }

   public String getName(){
    return passengerName;
   }
   public int getNumber(){
    return passengerNumber;
   }
   public PassengerType getType(){
    return type;
   }
   public double getBalance(){
    return passengerBalance;
   }
  public List<Activity> getActivities(){
    return activities;
  }
  public void registerForActivity(Activity activity){
    if(type == PassengerType.STANDARD || type == PassengerType.GOLD){
        double cost = (type == PassengerType.GOLD) ? totalCost(activity) : activity.getCost();
      if(passengerBalance >= cost){
        activities.add(activity);
        passengerBalance -= cost;
      }
      else{
        System.out.println("Insufficient balance for the activity");
      }
    }
    else if(type == PassengerType.PREMIUM){
        activities.add(activity);
    }
  }
  public double totalCost(Activity activity){
    return activity.getCost() * 0.9;
  }
  public void printpassengerDetails(){
     System.out.println("Passenger Name: " + passengerName);
     System.out.println("Passenger Number: " + passengerNumber);
     System.out.println("Passenger Account Balance: " + passengerBalance);
  }
}
