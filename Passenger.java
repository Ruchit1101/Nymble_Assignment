import java.util.*;

public class Passenger {
    
    /* 2/6. Each passenger has a name and a passenger number. */
  private   String passengerName;
  private   int passengerNumber;
  private   PassengerType type;
  private   double passengerBalance;
  private   List<Activity> activities;

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
  /*7.	A passenger can be a standard, gold or premium passenger. 
          1.	A standard passenger has a balance. And each time a standard passenger signs up for an activity the cost is deducted from their balance. They cannot sign up for an activity if they do not have sufficient balance.
          2.  A gold passenger has a balance. Each time a gold passenger signs up for an activity, a 10% discount is applied on the cost of the activity and the discounted amount is deducted from their balance. They cannot sign up for an activity if they do not have sufficient balance.
         3.  A premium passenger can sign up for activities for free
 */
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
  /*3.	Print the details of an individual passenger including their 
     a.	name,
     b.	passenger number,
     c.	balance (if applicable),
 */
  public void printpassengerDetails(){
     System.out.println("Passenger Name: " + passengerName);
     System.out.println("Passenger Number: " + passengerNumber);
    if(passengerBalance > 0)
     System.out.println("Passenger Account Balance: " + passengerBalance);
  }
  /* 3 d.	list of each activity they have signed up for,
       including the destination the at which the activity is 
       taking place and the price the passenger paid for the activity. */
  public void individualActivity(){
    System.out.println("Activities Signed Up For: ");
    for(Activity it:activities){
      System.out.println("Activity Name: " + it.getName());
      System.out.println("Destination: " + it.getDestination());
      System.out.print("Total Bill: ");
      if(type == PassengerType.GOLD)
       System.out.println(totalCost(it));
      else 
        System.out.println(it.getCost());
    }
  }
  //4. Each Passenger Can Sign Up for Zero or More Activities at Each Destination of the Travel Package
  public void distinctActivityTrack(Activity act){
    if(!activities.contains(act)){
      if(act.getCapacity() > countPassengerForActivity(act)){
        activities.add(act);
        if(type == PassengerType.STANDARD){
          passengerBalance -= act.getCost();
        }
        else if(type == PassengerType.GOLD){
          double discount = totalCost(act);
          passengerBalance -= discount;
        }
      }
      //5. Once an activity has reached it's capacity no more passengers can sign up for it.
      else{
        System.out.println("Activity " + act.getName() + " is already at full capacity. Please select other activity");
      }
    }
    else{
      System.out.println(passengerName + " is already signed up for activity " + act.getName());
    }
  }
    //  For counting activity of individual passengers
   private int countPassengerForActivity(Activity act){
    int count =0;
    for(Passenger pas: act.getDestination().getPassengers()){
        if(pas.getActivities().contains(act))
          count += 1;
    }
    return count;
   }
}
