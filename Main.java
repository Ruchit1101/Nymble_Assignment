import java.util.*;

public class Main {
    public static void main(String[] args) {
       
        Destination destination1 = createDestination("Destination1");
        Destination destination2 = createDestination("Destination2");

        
        List<TravelPackage> travelPackages = createTravelPackages(List.of(destination1, destination2));

       
        addPassengersToTravelPackages(travelPackages);

        
        for (TravelPackage travelPackage : travelPackages) {
            System.out.println("------ Travel Package Details ------");
            travelPackage.printItinerary();
            travelPackage.printpassengerList();
            travelPackage.printAvailableActivities();
            System.out.println("------------------------------------\n");
        }
    }

    private static Destination createDestination(String name) {
        Destination destination = new Destination(name);

        
        Activity activity1 = new Activity("Activity1", "Description1", 50.0, 20, destination);
        Activity activity2 = new Activity("Activity2", "Description2", 75.0, 15, destination);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        return destination;
    }

    private static List<TravelPackage> createTravelPackages(List<Destination> destinations) {
        List<TravelPackage> travelPackages = new ArrayList<>();

        
        TravelPackage travelPackage1 = new TravelPackage("Package1", 30, destinations, new ArrayList<>());
        TravelPackage travelPackage2 = new TravelPackage("Package2", 25,destinations, new ArrayList<>());

       
        travelPackages.add(travelPackage1);
        travelPackages.add(travelPackage2);

        return travelPackages;
    }

    private static void addPassengersToTravelPackages(List<TravelPackage> travelPackages) {
        Scanner sc = new Scanner(System.in);

        for (TravelPackage travelPackage : travelPackages) {
            System.out.println("Enter the number of passengers for " + travelPackage.getTravelPackageName() + ": ");
            int numPassengers = sc.nextInt();

            for (int i = 0; i < numPassengers; i++) {
                System.out.println("Enter passenger name: ");
                String passengerName = sc.next();

                System.out.println("Enter passenger number: ");
                int passengerNumber = sc.nextInt();

                System.out.println("Enter passenger type (1 for STANDARD, 2 for GOLD, 3 for PREMIUM): ");
                int passengerTypeInput = sc.nextInt();

                PassengerType passengerType = getPassengerTypeFromInput(passengerTypeInput);

                Passenger passenger = new Passenger(passengerName, passengerNumber, passengerType);
                travelPackage.getPassengersList().add(passenger);
            }
        }
    }

    private static PassengerType getPassengerTypeFromInput(int passengerTypeInput) {
        switch (passengerTypeInput) {
            case 1:
                return PassengerType.STANDARD;
            case 2:
                return PassengerType.GOLD;
            case 3:
                return PassengerType.PREMIUM;
            default:
                throw new IllegalArgumentException("Invalid passenger type input");
        }
    }
}
