package ticket.booking;

import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.services.TrainService;
import ticket.booking.services.UserBookingService;
import ticket.booking.util.TrainServiceUtil;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class App {

    public static void main(String[] args) {
        System.out.println("Running Train Booking System 🚆");

        Scanner sc = new Scanner(System.in);

        // Step 1: Ensure LocalDb/users.json exists
        File dbFolder = new File("LocalDb");
        if (!dbFolder.exists()) dbFolder.mkdirs();

        File usersFile = new File("LocalDb/users.json");
        try {
            if (!usersFile.exists()) {
                usersFile.createNewFile();
                java.nio.file.Files.writeString(usersFile.toPath(), "[]"); // empty JSON array
            }
        } catch (IOException e) {
            System.out.println("Failed to create users.json: " + e.getMessage());
            return;
        }

        // Step 2: Initialize service
        UserBookingService bookingService;
        try {
            bookingService = new UserBookingService();
        } catch (IOException e) {
            System.out.println("Failed to initialize booking service: " + e.getMessage());
            return;
        }

        User loggedInUser = null;
        int option = 0;

        // Step 3: Main loop
        while (option != 7) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Fetch Booking");
            System.out.println("4. Search Trains");
            System.out.println("5. Book a seat");
            System.out.println("6. Cancel my booking");
            System.out.println("7. Exit");

            option = sc.nextInt();

            switch (option) {
                case 1: // Sign up
                    System.out.print("Enter username: ");
                    String name = sc.next();
                    System.out.print("Enter password: ");
                    String password = sc.next();

                    User newUser = new User(
                            name,
                            null, // plain password not saved
                            UserServiceUtil.hashPassword(password),
                            new ArrayList<>(),
                            UUID.randomUUID().toString()
                    );

                    try {
                        bookingService.signUp(newUser);
                        System.out.println("Signup successful ✅");
                    } catch (IOException e) {
                        System.out.println("Signup failed: " + e.getMessage());
                    }
                    break;

                case 2: // Login
                    System.out.print("Enter username: ");
                    String loginName = sc.next();
                    System.out.print("Enter password: ");
                    String loginPassword = sc.next();

                    try {
                        User user = bookingService.loginUser(loginName, loginPassword);
                        if (user != null) {
                            loggedInUser = user;
                            System.out.println("Login successful ");
                        } else {
                            System.out.println("Invalid username or password ");
                        }
                    } catch (IOException e) {
                        System.out.println("Login failed: " + e.getMessage());
                    }
                    break;

                case 3:
                    //fetch booking
                    if (loggedInUser == null)
                    {
                        System.out.println("Please login first ");
                        break;
                    }
                   else {
                       bookingService.fetchBooking(loggedInUser.getName());
                    }
                    break;

                case 4://search trains
                    System.out.println("Enter source: ");
                    String source = sc.next();

                    System.out.println("Enter Destination: ");
                    String destination = sc.next();

                    try{
                        // load trains form the json
                        List<Train> trains = TrainServiceUtil.loadTrains();

                        //create TrainService
                        TrainService trainService = new TrainService(trains);

                        //search the trains and if there is , the store it int the list<train> result
                        List<Train> result = trainService.searchTrains(source,destination);

                        //show the result
                        if(result.isEmpty()){
                            System.out.println("No trains found");
                        }
                        else {
                            result.forEach(t -> System.out.println(t.getTrainInfo()));
                        }

                    }
                    catch (IOException ex){
                        System.out.println("Error loading the trains "+ex.getMessage());
                    }
                    break;

                case 5: //Booking seat
                    if(loggedInUser == null){
                        System.out.println("please login first");
                        break;
                    }
                    System.out.println("Enter source: ");
                    String src = sc.next();

                    System.out.println("Enter Destination: ");
                    String dest = sc.next();

                    try{
                        //load trains form trains.json into the list trains
                        List<Train> trains = TrainServiceUtil.loadTrains();

                        TrainService trainService = new TrainService(trains);
                        List<Train> availableTrains = trainService.searchTrains(src,dest);

                        if(availableTrains.isEmpty()){
                            System.out.println("no trains available");
                        }
                        else {
                            availableTrains.forEach(t-> System.out.println(t.getTrainInfo()));
                        }

                        System.out.println("Choose the train index for 0,1,2..");
                        int index = sc.nextInt();
                        Train selectedTrain = availableTrains.get(index);

                        bookingService.bookSeat(loggedInUser,selectedTrain,src,dest);

                    }
                    catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }

                    break;

                case 6: // cancel the booking
                    if(loggedInUser == null){
                        System.out.println("login first");
                        break;
                    }
                    else{
                        bookingService.fetchBooking(loggedInUser.getName());
                        System.out.println("enter ticket id to cancel: ");
                        String ticketId = sc.next();

                        bookingService.cancelBooking(loggedInUser,ticketId);
                    }

                case 7:
                    System.out.println("Exiting... 👋");
                    break;

                default:
                    System.out.println("Invalid option ❌");
            }
        }

        sc.close();
    }
}
