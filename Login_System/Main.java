import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Login> user = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("1 -> Register");
            System.out.println("2 -> Login");
            System.out.println("3 -> Display Users");
            System.out.println("4 -> Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("enter username: ");
                    String username = sc.nextLine();

                    System.out.println("enter password: ");
                    String password = sc.nextLine();

                    Login previousUser = user.get(username);
                    if (previousUser == null) {

                        user.put(username, new Login(username, password));
                    } else {
                        System.out.println("user already registered by that user name");
                    }

                    break;
                case 2:
                    System.out.println("enter username: ");
                    String loginUsername = sc.nextLine();

                    System.out.println("enter password: ");
                    String loginPassword = sc.nextLine();

                    Login u = user.get(loginUsername);
                    if (u == null) {
                        System.out.println("there is no such username ");
                    } else {
                        if (u.CheckPassword(loginPassword)) {
                            System.out.println("login successful");
                        } else {
                            System.out.println("login unsuccessful");
                        }
                    }
                    break;

                case 3:
                    // display
                    if (!user.isEmpty()) {
                        for (Login users : user.values()) {
                            users.Display();
                        }
                    } else {
                        System.out.println("no register users till now ");
                    }
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
        sc.close();
    }
}
