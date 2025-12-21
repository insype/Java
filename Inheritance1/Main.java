import java.util.ArrayList;

@FunctionalInterface
interface Ifilter{
    void greaterThanTwo(int n);    
}



public class Main {
    
    public static void main(String[] args) {
       ArrayList<Integer> num = new ArrayList<>();
       num.add(1); 
       num.add(2); 
       num.add(3); 
       num.add(4); 

    Ifilter filter = n -> {
        if(n>2)
            System.out.println(n);
    };

    for (int n: num) {
    filter.greaterThanTwo(n);        
    }
    
    }

    
    
}