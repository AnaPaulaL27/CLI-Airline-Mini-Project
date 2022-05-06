import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FlightSystem {


    private Scanner scanner;
    private PassengerService passengerService;
    private FlightService flightService;



    public FlightSystem(){
        this.flightService = new FlightService();
        flightService.addFlight(new Flight("London"));
        flightService.addFlight(new Flight("London"));
        flightService.addFlight(new Flight("London"));
        flightService.addFlight(new Flight("India"));
        flightService.addFlight(new Flight("India"));
        flightService.addFlight(new Flight("Thailand"));
        flightService.addFlight(new Flight("Thailand"));
        flightService.addFlight(new Flight("Dubai"));
        flightService.addFlight(new Flight("Dubai"));
        flightService.addFlight(new Flight("Pakistan"));
        flightService.addFlight(new Flight("Home"));
        flightService.addFlight(new Flight("Dubai"));
        flightService.addFlight(new Flight("Manchester"));
        this.passengerService = new PassengerService();
        this.scanner = new Scanner(System.in);
    }

    // TODO: Introduction to CLI
    public void intro(){
        System.out.println("               _                          _ \n" +
                "              | |                        | |\n" +
                " __      _____| | ___ ___  _ __ ___   ___| |\n" +
                " \\ \\ /\\ / / _ | |/ __/ _ \\| '_ ` _ \\ / _ | |\n" +
                "  \\ V  V |  __| | (_| (_) | | | | | |  __|_|\n" +
                "   \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___(_)");
        System.out.println("Welcome to British Airways");
        System.out.println("Would you like a Passenger Service or a Flight Service");
        start();
    }

    // TODO: Beginning Command-Line Interface
    public void start(){
        System.out.println("Type '1' if you are a customer and '2' if admin");
        System.out.println("1.Customer      2.Admin");
        int firstOption = scanner.nextInt();
        this.customerOrAdmin(firstOption);

    }

    // TODO: Checking if user is customer or admin
    public void customerOrAdmin(int option) {
        if (option == 1) {
            System.out.println("Are you an existing customer?");
            System.out.println("Enter \'Yes\' or \'No\'");
            String existingCustomerResponse = scanner.next().toLowerCase();
            this.customerAction(existingCustomerResponse);

        }else if (option == 2){
            this.adminAction();
            this.takeAnymoreActionsOrEnd();

        }else{
            System.out.println("Wrong number!!!!!");
            this.start();
        }

    }

    // TODO: Customer Action response to question (existing customer?)
    private void customerAction(String response) {

        // "are you an existing customer?"
        if(response.equals("yes")) {
            System.out.println("What is your passenger id?");
            String passengerId = scanner.next().toUpperCase();
            System.out.println("What action would you like to take?");

            System.out.println("Enter 1 for Cancel flight or       Enter 2 to book another flight");

            int option = scanner.nextInt();

            if(option == 1){
                this.cancelFlight();
            }
            else if(option == 2){
                this.bookingFlight("yes");
//                this.bookFlightByExistingPassengerID(passengerId);
            }
            else{
                this.takeAnymoreActionsOrEnd();
            }

        }
        else if(response.equals("no")) {
            System.out.println("Do you want to book with us?");
            System.out.println("Enter \'Yes\' or \'No\'");
            String answer = scanner.next().toLowerCase();
            bookingFlight(answer);
        }
        else {
            this.start();
        }
    }

    // TODO: Booking flight
    public void bookingFlight(String answer){
        // "Are you an existing customer?"
        if(answer.equals("yes")){
            System.out.println("Do you have a preferred destination? ");
            System.out.println("Enter \'Yes\' or \'No\'");
            String preferredAnswer = scanner.next().toLowerCase();
            if (preferredAnswer.equals("yes")) {
                System.out.println("Enter your destination");
                String destination = scanner.next();

                this.searchByDestination(destination);
                this.bookingFlightByFlightId();

            }else {
                this.displayAllAvailbleFlights();
                this.bookingFlightByFlightId();
            }

        } else this.takeAnymoreActionsOrEnd();

    }

    // TODO: To book flight by flightId
    public void bookingFlightByFlightId(){

        System.out.println("Enter the flight ID to book a flight");

        String userPreferredFlightId = scanner.next().toUpperCase();


        if (checkIfFlightIdExists(userPreferredFlightId)){
            Flight userFlight = flightService.getFlightById(userPreferredFlightId);
            // create the passenger
            System.out.println("Enter your name");
            String passengerName = scanner.next();
            System.out.println("Enter your email address");
            String passengerContact = scanner.next();

            // new passenger and book flight via Passenger Service
            Passenger passenger = new Passenger(passengerName, passengerContact);
            passengerService.addPassenger(passenger);
            passengerService.bookFlight(userFlight, passenger);
            System.out.println("Thank you for flying with us \uD83D\uDE0A");
            System.out.println(" +-+-+-+-+-+-+-+-+-+\n" +
                    " |i|m|p|o|r|t|a|n|t|\n" +
                    " +-+-+-+-+-+-+-+-+-+");
            System.out.println("Here is your Passenger ID :  " + passenger.getPassengerId());

            // go back to the very top layer
            this.takeAnymoreActionsOrEnd();
        }else{
            System.out.println("Invalid Flight ID");
            this.bookingFlight("yes");
        }
    }

    public boolean checkIfFlightIdExists(String Id){
        boolean idExist = false;
        for(Flight flight: flightService.getFlights()){
            if(flight.getFlightId().equals(Id)) {
                idExist = true;
                break;
            }
        }
        return idExist;
    }

//    // update
//    // book flight according to the existing passengerID
//    public void bookFlightByExistingPassengerID(String passengerId){
//        System.out.println("Enter the flight ID to book a flight");
//
//        String userPreferredFlightId = scanner.next().toUpperCase();
//        if (checkIfFlightIdExists(userPreferredFlightId)){
//
//            Flight userFlight = flightService.getFlightById(userPreferredFlightId);
//            Passenger passenger = passengerService.getPassengerById(passengerId);
//
//            // book flight via Passenger Service
//            passengerService.bookFlight(userFlight, passenger);
//            System.out.println("Thank you for flying with us \uD83D\uDE0A");
//
//            // go back to the very top layer
//            this.takeAnymoreActionsOrEnd();
//        }else{
//            System.out.println("Invalid Flight ID");
//            this.bookFlightByExistingPassengerID(passengerId);
//        }
//
//    }


    // TODO: Cancel flight
    public void cancelFlight(){
            System.out.println("Enter the FlightId to cancel your flight");
            String passengerFlightId = scanner.next();
            if(checkIfFlightIdExists(passengerFlightId)){
                flightService.removeFlight(flightService.getFlightById(passengerFlightId));
                System.out.println("Your flight has been Cancelled");
                System.out.println("------------------------------");
                System.out.println("------------------------------");
                System.out.println("------------------------------");


                this.takeAnymoreActionsOrEnd();

            }

            else{
                System.out.println("Invalid FlightId");
                this.cancelFlight();
            }
    }

    // TODO: To display all available flights

    public void displayAllAvailbleFlights(){
        System.out.println("---Flight ID---|---Destination---");
        flightService.getFlights()
                .stream()
                .forEach(f -> System.out.println("     " + f.getFlightId() + "      " + f.getDestination()));

    }


    //TODO Search by destination
    public void searchByDestination(String destination){


            List<Flight> matchedDestinationFlights = flightService.searchDestination(destination);

            if(matchedDestinationFlights.size() == 0){
                System.out.println("Sorry we don't fly there!");
//                this.bookingFlight("yes");
                this.takeAnymoreActionsOrEnd();

            }
            else{
                System.out.println("---Flight ID---|---Destination---");
                matchedDestinationFlights.stream()
                        .forEach(flight -> {

                            System.out.println("    " + flight.getFlightId() + "          " + flight.getDestination());
                        });
                System.out.println("                                                         ");
                System.out.println("");

//                this.bookingFlightByFlightId();

        }
    }


    // TODO: admin actions
    // PassengerService--has List<Flight> flights----has flights.getPassenger(List<Passenger>)-- passenger.getName() && passenger.getId()
    public void adminAction(){
        System.out.println("What action would you like to take?");
        System.out.println("Enter 1 to addFlight     or 2 to View booked flight");
        int option = scanner.nextInt();
        if(option == 1) adminAddFlight();
        else if(option == 2) adminViewBookedFlight();
    }
    

    //TODO Admin can add flights

    public void adminAddFlight(){
        System.out.println("Please enter the destination of the flight.");
        String destination = scanner.next();
        flightService.addFlight(new Flight(destination));
        this.takeAnymoreActionsOrEnd();
    }

    public void adminViewBookedFlight(){
        System.out.println("----Name------|------ID-----");
        flightService.getFlights()
                .forEach(flight -> flight.getPassengers()
                        .forEach(passenger -> System.out.println("    "+passenger.getPassengerName()
                                + "           "+passenger.getPassengerId())));
    }

//    public void adminAddFlight(){
//
////        System.out.println("Do you want to add a flight?");
////        String adminAnswer = scanner.next().toLowerCase();
////        if(adminAnswer.equals("yes")){
//        System.out.println("Please enter the destination of the flight.");
//        String destination = scanner.next();
//        flightService.addFlight(new Flight(destination));
//        this.takeAnymoreActionsOrEnd();
////
////        }else{
////            this.takeAnymoreActionsOrEnd();
////        }
//    }


    public void writePassengerDetailsToFile() throws Exception{
        File file = new File("src/passengerBookedFlightsRecord.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);

        PrintWriter printWriter = new PrintWriter(fileWriter);


        for (Flight flight : flightService.getFlights()){
            if(flight.getPassengers().size() == 0) continue;
            printWriter.println("Flight  Details");
            printWriter.println("---Flight ID---|---Destination---");
            printWriter.println("    " + flight.getFlightId() + "          " + flight.getDestination());
            printWriter.println("Passenger Details");
            printWriter.println("--Passenger ID--|---Name--- ");
            for(Passenger p : flight.getPassengers()) {
                printWriter.println("    " + p.getPassengerId() + "          " + p.getPassengerName());
            }
            printWriter.println("-----------------------------------------");
        }

        printWriter.close();

    }



    // TODO: The action to bring user back to the beginning
    public void takeAnymoreActionsOrEnd(){

        System.out.println("Would you like to take anymore actions?");
        String answer = scanner.next().toLowerCase();
        if(answer.equals("yes")) this.start();
        else {
            System.out.println("See you next time");
            try{
                this.writePassengerDetailsToFile();}
            catch(Exception exception){
            }
        }

    }








}
