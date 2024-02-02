import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class PassengerTest {

    @Test
    public void testRegisterForActivityStandardPassenger() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "TestDescription", 50.0, 20, destination);
        Passenger passenger = new Passenger("John Doe", 1, PassengerType.STANDARD);

        passenger.registerForActivity(activity);

        assertTrue(passenger.getActivities().contains(activity));
        assertEquals(0.0, passenger.getBalance(), 0.01);
    }

    @Test
    public void testRegisterForActivityGoldPassenger() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "TestDescription", 50.0, 20, destination);
        Passenger passenger = new Passenger("Jane Doe", 2, PassengerType.GOLD);

        passenger.registerForActivity(activity);

        assertTrue(passenger.getActivities().contains(activity));
        assertEquals(45.0, passenger.getBalance(), 0.01);
    }

    @Test
    public void testRegisterForActivityPremiumPassenger() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "TestDescription", 50.0, 20, destination);
        Passenger passenger = new Passenger("Premium Passenger", 3, PassengerType.PREMIUM);

        passenger.registerForActivity(activity);

        assertTrue(passenger.getActivities().contains(activity));
        assertEquals(0.0, passenger.getBalance(), 0.01);
    }

    @Test
    public void testDistinctActivityTrack() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "TestDescription", 50.0, 20, destination);
        Passenger passenger = new Passenger("John Doe", 1, PassengerType.STANDARD);

        passenger.distinctActivityTrack(activity);

        assertTrue(passenger.getActivities().contains(activity));
        assertEquals(0.0, passenger.getBalance(), 0.01);
    }

}
