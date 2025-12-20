class Vehicle {
   public static void Start(){
        System.out.println("all vehicle needs key to start");
    }
   public void Tires(){
    System.out.println("vehicles has different number of tires");
   } 
}


class Car extends Vehicle{
    //hiding 
    public static void Start(){
        System.out.println("car needs key to start");
    }
    @Override
    public void Tires(){
        System.out.println("cars has 4 tires");
    }
}
class Bike extends Vehicle{
    public static void Start(){
        System.out.println("bike needs key to start");
    }
    @Override
    public void Tires(){
        System.out.println("bike has 2 tires");
    }
}

public class Main {

    public static void main(String[] args) {

        Vehicle v2 = new Car();
        v2.Tires();


    }
    
}

    