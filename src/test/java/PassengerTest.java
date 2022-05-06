import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PassengerTest {

    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;
    private Passenger passenger5;
    private Passenger passenger6;


    private Flight flight1;
    private Flight flight2;
    private Flight flight3;



    @BeforeEach

    public void setUp() {

        passenger1 = new Passenger("Olivia Hull", "OliviaHull32@gmail.com");
        passenger2 = new Passenger("Noah Anderson", "Noahthegamer2452@hotmail.com");
        passenger3 = new Passenger("Leslie Dickens", "Les_Dickens@outlook.com");
        passenger4 = new Passenger("Alex Mathews", "Alex_Mathews@outlook.com");
        passenger5 = new Passenger("Bernard Smith", "Bernie75@gmail.com");
        passenger6 = new Passenger("Shannon Williams", "Shannon_Will@live.com");

        flight1 = new Flight("Portugal");
        flight2 = new Flight("Bali");
        flight3 = new Flight("Cancun");

    }

    @Test

    public void hasName() {
        assertThat(passenger1.getPassengerName()).isEqualTo("Olivia Hull");
        assertThat(passenger2.getPassengerName()).isEqualTo("Noah Anderson");
    }

    @Test

    public void hasContact() {
        assertThat(passenger3.getPassengerContact()).isEqualTo("Les_Dickens@outlook.com");
        assertThat(passenger4.getPassengerContact()).isEqualTo("Alex_Mathews@outlook.com");
    }

    @Test

    public void canCreatePassengerId(){
        assertThat(passenger5.getPassengerId().isEmpty()).isEqualTo(false);
        assertThat(passenger6.getPassengerId().isEmpty()).isEqualTo(false);

    }

    @Test

    public void canAddTicket(){
        passenger1.addTicket(flight1);
        assertThat(passenger1.getPassengerBoughtFlights().size()).isEqualTo(1);

        passenger2.addTicket(flight2);
        assertThat(passenger2.getPassengerBoughtFlights().size()).isEqualTo(1);

        passenger3.addTicket(flight3);
        assertThat(passenger3.getPassengerBoughtFlights().size()).isEqualTo(1);

    }

    @Test

    public void canRemoveTicket(){
        passenger1.removeTicket(flight1);
        assertThat(passenger1.getPassengerBoughtFlights().size()).isEqualTo(0);

        passenger2.removeTicket(flight2);
        assertThat(passenger2.getPassengerBoughtFlights().size()).isEqualTo(0);

        passenger3.removeTicket(flight3);
        assertThat(passenger3.getPassengerBoughtFlights().size()).isEqualTo(0);


    }
}
