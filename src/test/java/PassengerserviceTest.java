import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PassengerserviceTest {

Passenger passenger1, passenger2;
PassengerService passengerService;
Flight flight;
FlightService flightService;

    @BeforeEach

    public void setUp() {

         passenger1 = new Passenger("Sujan", "sujangurung10@gmail.com");
         passenger2 = new Passenger("Jhon", "sujJhon4310@gmail.com");
         passengerService = new PassengerService();
         flight = new Flight("London");
         flightService = new FlightService();



    }


    @Test


    public void dummy() {
    }

    @Test
    public void canBookFlight(){
        passengerService.bookFlight(flight,passenger1);
        assertThat(flight.getPassengers().size()).isEqualTo(1);
    }

    @Test
    public void canCancelFlight(){
        passengerService.bookFlight(flight,passenger1);
        passengerService.bookFlight(flight,passenger2);
        passengerService.cancelFlight(flight, passenger1);
        assertThat(flight.getPassengers().size()).isEqualTo(1);
    }

}
