import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<String> players = new ArrayList<String>();
        players.add("messi");
        players.add("neymar");
        players.add("ronaldo");
        players.add("pele");

        for(var names : players){
            System.out.println(names);
        }
// can use treeset for arranging integers in ascending order

        Set<Integer> nums = new TreeSet<>();
        nums.add(93);
        nums.add(77);
        nums.add(63);
        nums.add(48);
        nums.add(80);
        nums.add(93);
    
        for (Integer n : nums) {
            System.out.println(n);
        }

// for key-value pairs , we can use hashmap

        Map<Integer,String> records = new HashMap<>();

        records.put(1,"prasiddha");
        records.put(2, "ram");
        records.put(3,"shyam");

        System.out.println(records);
}

}