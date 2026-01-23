//use set to avoid duplicate values 
//use TreeSet to arrange the list in ascending order

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Set<Integer> num = new TreeSet<Integer>();

        num.add(1);
        num.add(4);
        num.add(99);
        num.add(80);

        for (Integer integer : num) {
            System.out.println(integer);
        }
        Set<Integer> numms = new HashSet<Integer>();

        numms.add(1);
        numms.add(4);
        numms.add(99);
        numms.add(80);

        for (Integer integer : numms) {
            System.out.println(integer);
        }
    }
}