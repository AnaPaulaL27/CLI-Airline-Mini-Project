import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Passenger {

    //Properties
    private String name;
    private String contact;
    private String passengerId;
    private List<Flight> boughtFlights;


    //Constructor
    public Passenger(String name, String contact){
        this.name = name;
        this.contact = contact;
        this.boughtFlights = new ArrayList<>();
        createPassengerId();
    }

    //Method to create passengerId
    public void createPassengerId(){

        int length = 7;
        boolean useLetters = true;
        boolean useNumbers = true;
        this.passengerId = RandomStringUtils.random(length, useLetters, useNumbers).toUpperCase();

    }

    //Getters

    public String getPassengerName() {
        return this.name;
    }

    public String getPassengerId() {
        return this.passengerId;
    }

    public String getPassengerContact() {
        return this.contact;
    }

    public List<Flight> getPassengerBoughtFlights() {
        return this.boughtFlights;
    }

    //Method to addTicket
    // List<Flight> boughtFlights ----- boughtFlights.add()  // List<Integer> l1 ---- l1.add(233)
    public void  addTicket(Flight flight){
        boughtFlights.add(flight);}

    //Method to removeTicket
    public void removeTicket(Flight flight){
        boughtFlights.remove(flight);

    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", passengerId='" + passengerId + '\'' +
                '}';
    }
}

