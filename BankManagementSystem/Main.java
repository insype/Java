import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 -> Create account");
            System.out.println("2 -> Deposit");
            System.out.println("3 -> Withdraw");
            System.out.println("4 -> Display all account");
            System.out.println("5 -> Exit");

            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account Number: ");
                    int accountNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter account Holder Name: ");
                    String accountHolderName = sc.nextLine();

                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    accounts.add(new BankAccount(accountNumber, accountHolderName, balance));
                    System.out.println("Account Created");
                    break;

                case 2:
                    System.out.print("enter account number: ");
                    int depAccount = sc.nextInt();
                    System.out.print("enter balance: ");
                    double enteredAmount = sc.nextDouble();
                    for(var acc : accounts){
                        if(acc.GetAccountNumber() == depAccount){
                            acc.deposit(enteredAmount);
                        }
                    }
                    System.out.println("Amount Deposited...");
                        break;
                    

                case 3:
                    System.out.print("enter account number: ");
                    int withAccount = sc.nextInt();
                    System.out.print("enter withdrawing amount: ");
                    double Amount = sc.nextDouble();
                    for(var acc : accounts){
                        if(acc.GetAccountNumber() == withAccount){
                            acc.withdraw(Amount);
                        }
                    }
                    System.out.println("Amount Withdrawed...");
                break;

                case 4:
                    for(var acc : accounts){
                        acc.accountInfo();
                    }
                break;

                case 5:
                    System.out.println("Exiting ....");
                    sc.close();

                default:
                    break;
            }
        }

    }
}
