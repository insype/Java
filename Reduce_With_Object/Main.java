import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("enter your choice(1=enter / 0=close) ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter name of player");
                String inputName = sc.nextLine();

                System.out.println("Enter goals scored by the player");
                int inputGoal = sc.nextInt();
                sc.nextLine();

                players.add(new Player(inputName, inputGoal));
            } else if (choice == 0) {
                running = false;
                sc.close();
            }

        }
        
        Player topScorerPlayer = players.stream().reduce((p1,p2) -> p1.goal > p2.goal ? p1 : p2).orElse(null);

        System.out.println("the topscorer is "+topScorerPlayer.name);
    }
}