//Map means key value pair

import java.util.HashMap;
import java.util.Map;

class Main{
    public static void main(String[] args){
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "Ram");
        students.put(2, "Shyam");
        students.put(3, "Hari");

        System.out.println(students.get(2));

        System.out.println(students.size());
        System.out.println(students.keySet());
   }
}