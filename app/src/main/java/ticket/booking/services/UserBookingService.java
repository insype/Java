package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.DoubleToIntFunction;

public class UserBookingService {

    private static final String USERS_PATH = "LocalDb/users.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<User> userList;

    // Default constructor: loads all users
    public UserBookingService() throws IOException {
        userList = loadUsers();
    }

    // Load users from users.json
    private List<User> loadUsers() throws IOException {
        File usersFile = new File(USERS_PATH);

        if (!usersFile.exists()) {
            usersFile.getParentFile().mkdirs();
            usersFile.createNewFile();
            objectMapper.writeValue(usersFile, new ArrayList<User>());
        }

        // Read users, ignore unknown fields in JSON
        return objectMapper.readValue(usersFile, new TypeReference<List<User>>() {});
    }

    // Save all users to users.json
    private void saveUsers() throws IOException {
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    // Sign up a new user
    public boolean signUp(User user) throws IOException {
        // Check if username already exists
        boolean exists = userList.stream()
                .anyMatch(u -> u.getName().equalsIgnoreCase(user.getName()));

        if (exists) {
            System.out.println("Username already exists ❌");
            return false;
        }

        userList.add(user);
        saveUsers();
        return true;
    }

    // Login: returns the User object if credentials are correct, else null
    public User loginUser(String username, String password) throws IOException {
        for (User u : userList) {
            if (u.getName().equalsIgnoreCase(username)
                    && UserServiceUtil.checkPassword(password, u.getHashedPassword())) {
                return u;
            }
        }
        return null; // login failed
    }

    // Fetch bookings for a specific user
    public void fetchBooking(String username) {

        Optional<User> foundUser = userList.stream()
                .filter(u -> u.getName().equalsIgnoreCase(username))
                .findFirst();

        if (foundUser.isEmpty()) {
            System.out.println("User not found");
            return;
        }

        User realUser = foundUser.get();

        if (realUser.getTicketsBooked() == null ||
                realUser.getTicketsBooked().isEmpty()) {
            System.out.println("No bookings found for user " + realUser.getName());
            return;
        }

        System.out.println("Bookings for user: " + realUser.getName());
        realUser.getTicketsBooked()
                .forEach(ticket ->
                        System.out.println(ticket.getTicketInfo()));
        }

        public void bookSeat(User user, Train train, String source , String destination){
            List<List<Integer>> seats = train.getSeats();
            int row = -1, col = -1;

            //find the first available seat
            outer:
            for (int i = 0; i < seats.size(); i++){
                for (int j = 0; j < seats.get(i).size() ; j++){
                    if(seats.get(i).get(j) == 0){
                        row = i;
                        col = j;
                        break outer;
                    }
                }
            }

            if(row == -1){
                System.out.println("No seats available");
                return;
            }

            //Mark the seat as booked
            seats.get(row).set(col,1);

            Ticket ticket = new Ticket(
                    UUID.randomUUID().toString(),
                    user.getUserId(),
                    source,
                    destination,
                    java.time.LocalDate.now().toString(),
                    train
            );

            if(user.getTicketsBooked() == null)
            {
                user.setTicketsBooked(new ArrayList<>());
            }

            user.getTicketsBooked().add(ticket);
            try{
                saveUsers();
                System.out.println("seat booking successfully");
                System.out.println(ticket.getTicketInfo());
            }catch(IOException ex){
                System.out.println("failed to save booking "+ex.getMessage());
            }
        }

        public void cancelBooking(User user, String ticketId){
            if(user.getTicketsBooked() == null || user.getTicketsBooked().isEmpty()){
                System.out.println("No Booking to cancel ");
                return;
            }
            Ticket ticketToCancel = null;

            for (Ticket t : user.getTicketsBooked()){
                if(t.getTicketId().equals(ticketId)){
                    ticketToCancel = t;
                    break;
                }
            }
            if(ticketToCancel == null){
                System.out.println("ticket not found");
                return;
            }
            Train train = ticketToCancel.getTrain();
            freeSeat(train);

            user.getTicketsBooked().remove(ticketToCancel);

            try{
                saveUsers();
                System.out.println("booking cancelled successfully");
            }
            catch (IOException ex){
                System.out.println("failed to cancel booking "+ex.getMessage());
            }
        }

        private void freeSeat(Train train){
            List<List<Integer>> seats = train.getSeats();

            outer:
            for (int i = 0; i < seats.size(); i++) {
                for (int j = 0; j < seats.get(i).size() ; j++) {
                    if(seats.get(i).get(j)==1){
                        seats.get(i).set(j,0);
                        break outer;
                    }
                }

            }
        }
}
