import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a list of destinations with activities
        Destination destination1 = createDestination("Destination1");
        Destination destination2 = createDestination("Destination2");

        // Create a list of travel packages
        List<TravelPackage> travelPackages = createTravelPackages(List.of(destination1, destination2));

        // Add passengers to travel packages
        addPassengersToTravelPackages(travelPackages);

        // Print details of travel packages
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

        // Create activities for the destination
        Activity activity1 = new Activity("Activity1", "Description1", 50.0, 20, destination);
        Activity activity2 = new Activity("Activity2", "Description2", 75.0, 15, destination);

        // Add activities to the destination
        destination.addActivity(activity1);
        destination.addActivity(activity2);

        return destination;
    }

    private static List<TravelPackage> createTravelPackages(List<Destination> destinations) {
        List<TravelPackage> travelPackages = new ArrayList<>();

        // Create travel packages with different capacities
        TravelPackage travelPackage1 = new TravelPackage("Package1", 30, destinations, new ArrayList<>());
        TravelPackage travelPackage2 = new TravelPackage("Package2", 25,destinations, new ArrayList<>());

        // Add travel packages to the list
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
