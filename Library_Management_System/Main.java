import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Book> books = new HashMap<>();

        while (true) {
            System.out.println("1-> Add book");
            System.out.println("2-> Issue book");
            System.out.println("3-> Return book");
            System.out.println("4-> Display book");
            System.out.println("5-> Exit");

            System.out.println("enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //add book
                    
                    System.out.println("enter book id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("enter book name: ");
                    String bookName = sc.nextLine();

                    books.put(id, new Book(id, bookName, false, true));
                    break;
                case 2:
                    //Issue book
                    
                    System.out.println("enter book id: ");
                    int issuedId = sc.nextInt();
                    sc.nextLine();

                    Book b = books.get(issuedId);
                    b.issueBook();

                    break;

                case 3:
                    //Return book

                     System.out.println("enter book id: ");
                    int returnId = sc.nextInt();
                    sc.nextLine();

                    Book r = books.get(returnId);
                    r.returnBook();
                   
                    break;

                case 4:
                    //Display book
                    for (Book Books : books.values()) {
                        Books.displayBook(); 
                    } 
                    break;

                case 5:
                    sc.close();

                default:
                    System.out.println("wrong choice ");
                    break;
            }
        }
    }
}
