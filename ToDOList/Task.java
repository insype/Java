public class Task {

    public int id;
    public String task;
    public boolean completed;

    public Task(int id , String task , boolean completed){
        this.id = id;
        this.task = task;
        this.completed = completed;
    }

    public int getId(){
        return id;
    }

    public void markCompleted(){
        completed = true;

    }

    public void displayTask(){
        System.out.println("task id : "+id);
        System.out.println("task name : "+task);
        String Status =(completed)?"Complete":"pending";
        System.out.println(Status);
    }
}