import java.util.ArrayList;
import java.util.List;

public class PassengerService {

    //Properties
    private List<Passenger> passengers;

    //constructor
    public PassengerService(){
        this.passengers = new ArrayList<>();
    }


    //Method to book a flight
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
    public void removePassenger(Passenger passenger){passengers.remove(passenger);}

    public void bookFlight(Flight flight, Passenger passenger){
        flight.addPassenger(passenger);
        passenger.addTicket(flight);
    }

    //Method to cancel a flight
    public void cancelFlight(Flight flight, Passenger passenger) {
        flight.getPassengers().remove(passenger);
        passenger.removeTicket(flight);
    }

    // Method to get passenger by id
    public Passenger getPassengerById(String Id){
        Passenger passenger = this.passengers.stream()
                .filter(p -> p.getPassengerId().equals(Id))
                .toList().get(0);
        return passenger;
    }




}
