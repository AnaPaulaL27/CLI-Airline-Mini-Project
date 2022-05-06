import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightTest {




Flight flight1, flight2;
Passenger passenger1;


    @BeforeEach

    public void setUp() {

        flight1 = new Flight("India");
        flight2 = new Flight("Dubai");

        passenger1 = new Passenger("Sujan", "sujangurung10@gmail.com");


    }

    @Test

    public void canCreateFlightID(){
    flight1.createFlightId();
    assertThat(flight1.getFlightId().length()).isEqualTo(7);

}

    @Test

    public void canAddPassengers(){
        flight1.addPassenger(passenger1);
        assertThat(flight1.getPassengers().size()).isEqualTo(1);


    }
}