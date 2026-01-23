import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Main{
    public static void main(String[] args) {
        Collection nums = new ArrayList();
        nums.add(13);
        nums.add(14);
        nums.add(15);
        nums.add(16);

        for (Object object : nums) {
            System.out.println(object);
        }

        List<String> names = new ArrayList<>();

        names.add("ram");
        names.add("hari");
        names.add("shyam");

        for (String string : names) {
           System.out.println(string); 
        }

        System.out.print("the fetched name is ");
        System.out.println(names.get(2));

    }
}