import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.Destination;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightServiceTest {

    private Flight flight1;
    private Flight flight2;
    private Flight flight3;
    private Flight flight4;
    private Flight flight5;
    private Flight flight6;
    private FlightService flightService;

    private Destination destination1;


    @BeforeEach

    public void setUp() {

        flight1 = new Flight("Sao Tome");
        flight2 = new Flight("Vietnam");
        flight3 = new Flight("Sri Lanka");
        flight4 = new Flight("Thailand");
        flight5 = new Flight("Maldives");
        flight6 = new Flight("Thailand");



        flightService = new FlightService();
    }

    @Test
    public void canAddFlight() {
        flightService.addFlight(flight1);
        assertThat(flightService.getFlights().size()).isEqualTo(1);

        flightService.addFlight(flight2);
        assertThat(flightService.getFlights().size()).isEqualTo(2);

        flightService.addFlight(flight3);
        assertThat(flightService.getFlights().size()).isEqualTo(3);

    }

    @Test
    public void canRemoveFlight() {
        flightService.removeFlight(flight1);
        assertThat(flightService.getFlights().size()).isEqualTo(0);

        flightService.removeFlight(flight2);
        assertThat(flightService.getFlights().size()).isEqualTo(0);

        flightService.removeFlight(flight3);
        assertThat(flightService.getFlights().size()).isEqualTo(0);

    }


    @Test
    public void canSearchByDestination(){
        flightService.addFlight(flight1);
        assertThat(flightService.searchDestination("Sao Tome").size()).isEqualTo(1);


    }




}
