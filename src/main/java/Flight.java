import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    //properties 
private String flightId;
private String destination;
private List<Passenger> passengers;


    //constructor
    public Flight(String destination){
        this.passengers = new ArrayList<>();
        this.destination = destination;
        createFlightId();

    }

    //Method to create flightId
    public void createFlightId(){

        int length = 7;
        boolean useLetters = true;
        boolean useNumbers = true;
        this.flightId = RandomStringUtils.random(length, useLetters, useNumbers).toUpperCase();

    }

    //Getters
    public String getFlightId() {
        return flightId;
    }

    public String getDestination() {
        return destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }


    //Method to add passengers
    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }





    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", destination='" + destination + '\'' +
                ", passengers=" + passengers +
                '}';

    }


}
