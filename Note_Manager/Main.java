import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Note> note = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("1 -> Add Note");
            System.out.println("2 -> View all Note");
            System.out.println("3 -> Save notes to file");
            System.out.println("4 -> Load notes from file");
            System.out.println("5 -> Exit ");
            
            System.out.print("enter your choice");
            int choice = sc.nextInt();      

            switch (choice) {
                case 1:
                    //add
                    System.out.println("enter note id:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("enter note title:");
                    String title = sc.nextLine();

                    System.out.println("enter note content:");
                    String content= sc.nextLine();

                    note.add(new Note(id,title,content));
                    break;

                case 2:
                    if(note.isEmpty()){
                        System.out.println("no Note to show beacuse note is empty");
                    }
                    else {
                        for (Note n : note) {
                            n.Display();
                        }
                    }
                break;

                case 3:
                    if (note.isEmpty()) {
                       System.out.println("no notes to save: "); 
                    }
                    else {
                        try{
                            FileWriter fw = new FileWriter("note.txt");
                            BufferedWriter bw = new BufferedWriter(fw);

                            for (Note n : note) {
                                bw.write(n.id + "|" +n.title + "|" +n.content);
                                bw.newLine();
                            }
                            bw.close();
                            System.out.println("notes saved to file successfully");
                        }
                        catch(IOException ex){
                            System.out.println(ex);
                        }
                    }
                break;

                case 4:
                    try{
                        BufferedReader br = new BufferedReader(new FileReader("note.txt"));
                        String line;
                        note.clear();

                        while ((line = br.readLine()) != null) {
                            String[] part = line.split("\\|");
                            int readId = Integer.parseInt(part[0]);
                            String readTitle = part[1];
                            String readContent = part[2];

                            note.add(new Note(readId, readTitle, readContent));
                        }
                    br.close();
                    System.out.println("Notes loaded form file ");
                    }
                    catch(IOException ex){
                        System.out.println(ex);
                    }
                break;

                case 5:
                    running = false;
                break;
            
                default:
                    break;
            }
        }
   } 
}
