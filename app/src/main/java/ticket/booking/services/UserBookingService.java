package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void fetchBooking(User user) {
        if (user.getTicketsBooked() == null || user.getTicketsBooked().isEmpty()) {
            System.out.println("No bookings found for user " + user.getName());
            return;
        }

        System.out.println("Bookings for user: " + user.getName());
        for (var ticket : user.getTicketsBooked()) {
            System.out.println(ticket.getTicketInfo());
        }
    }
}
