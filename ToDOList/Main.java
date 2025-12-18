import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 -> Add Task"); 
            System.out.println("2 ->Mark Task as Completed"); 
            System.out.println("3 -> Display all Task"); 
            System.out.println("4 -> Delete Task"); 
            System.out.println("5 -> Exit"); 

            System.out.println("enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add Task
                    System.out.println("enter task id :");                    
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("enter task name :");                    
                    String taskName = sc.nextLine();

                    tasks.add(new Task( id, taskName, false));
                    break;

                case 2:
                    //Mark task as completed
                    System.out.println("Enter task id: ");
                    int taskId = sc.nextInt();

                    for (var task : tasks) {
                        if(task.getId()== taskId){
                            task.markCompleted();
                        }
                    }

                break;

                case 3:
                    //Display all task

                    if(tasks.isEmpty())
                    {
                        System.out.println("no tasks till now ");
                    }
                    else
                    {
                        for (Task task : tasks) {
                            task.displayTask();
                        }     
                    }

                    break;
                
                case 4:
                    //Delete task
                    System.out.println("Enter task id: ");
                    int t_id = sc.nextInt(); 
                    
                    tasks.removeIf(t->t.getId() == t_id); 
                    break;

                case 5:
                    //exit
                    System.out.println("exiting....");
                    sc.close();
                    break;

                default:
                    System.out.println("wrong choice");
                    break;
            }

        }
    } 
}
