import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
           System.out.println("1. add expense"); 
           System.out.println("2. view all expense"); 
           System.out.println("3. view total expense"); 
           System.out.println("4. exit"); 

           System.out.println("enter your choice: ");
           int choice = sc.nextInt();

           switch (choice) {
            case 1:
                System.out.println("enter id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("enter amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter category (FOOD, TRAVEL, STUDY, OTHER): ");
                String categoryInput = sc.nextLine().toUpperCase();
                ExpenseCategory category = ExpenseCategory.valueOf(categoryInput); 

                System.out.println("enter description: ");
                String description = sc.nextLine();

                expenses.add(new Expense(id, amount, category, description));
                System.out.println("expenses added successfully ");

                break;
            case 2:
                for (Expense e: expenses) {
                    e.Display();
                }
            break;

            case 3:
                //add all expenses
                double totalExpense = 0;
                for (Expense e : expenses) {
                   totalExpense+=e.getAmount(); 
                }
                System.out.println("total expense is "+totalExpense);
            break;

            case 4:
                running = false;
                sc.close();
            break;
                
            default:
                System.out.println("you entered wrong choice");
                break;
           }
        }
    }
}
