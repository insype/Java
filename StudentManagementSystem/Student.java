public class Student 
{

    //attributes

    private int id;
    private String name;
    private int age;
        
    //methods

    public Student(int id,String name,int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void displayInfo()
    {
        System.out.println("id : "+id);
        System.out.println("name : "+name);
        System.out.println("age : "+age);
    }
    }
