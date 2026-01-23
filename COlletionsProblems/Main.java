// import java.util.HashSet;
// import java.util.Set;

// public class Main{
//     public static void main(String[] args){
//         int[] arr = {1,2,4,2,1};

//         Set<Integer> num = new HashSet<>();

//         for(int i=0; i<arr.length; i++){
//             num.add(arr[i]);
//         }

//         System.out.println(num);
//     }
// }

// import java.util.HashMap;
// import java.util.Map;

// public class Main{
//     public static void main(String[] args) {
//         int[] arr = {1,2,2,1,3,3,2};

//         Map<Integer,Integer> map = new HashMap<>();

//         for(int i = 0; i<arr.length; i++)
//         {
//             if (map.containsKey(arr[i])) {
//                 map.put(arr[i],map.get(arr[i])+1); 
//             }
//             else {
//                 map.put(arr[i],1);
//             }
//         }
//         System.out.println(map);
//     }
// }

// import java.util.HashMap;
// import java.util.Map;

// public class Main{
//     public static void main(String[] args) {
//         int[] arr = {1,2,2,1,1,1,3,3,3};

//         Map<Integer,Integer> map = new HashMap<>();

//         for(int i = 0 ; i < arr.length; i++){
//             if (map.containsKey(arr[i])) {
//                 map.put(arr[i], map.get(arr[i])+1); 
//             }
//             else {
//                 map.put(arr[i], 1);
//             }
//         }
//         int max = 0;
//         for (int i : map.values()) {
//             if(max<i){
//                 max = i;
//             }
//         }
//         System.out.println(max);

//         System.out.println(map.entrySet());

//         System.out.println(map.keySet());

//     for (int key : map.keySet()) {
//        if(max == map.get(key)) {
//         System.out.println(key);
//        }
//     }
//     }
// }

// import java.util.HashMap;
// import java.util.Map;

// public class Main{
//     public static void main(String[] args) {
//         int[] arr = {1,1,2,2,3,4,4,5};

//         Map<Integer,Integer> map = new HashMap<>();

//         for(int i = 0; i<arr.length; i++){
//             if(map.containsKey(arr[i])){
//                 map.put(arr[i],map.get(arr[i])+1);
//             }
//             else {
//                 map.put(arr[i],1);
//             }
//         }
//         System.out.println(map.entrySet());

//         // for (int key : map.keySet()) {
//         //      if(map.get(key) == 1){
//         //         System.out.println(key);
//         //      }
//         // }

//         for(int i = 0; i <arr.length;i++){
//             if(map.get(arr[i]) == 1){
//                 System.out.println(arr[i]);
//                 break;
//             }
//         }
//     }
// }

// public class Main{
//     public static void main(String[] args) {
//         int[] arr = {1, 2, 2, 1,6, 3, 4, 4, 5};

//         Set<Integer> set = new LinkedHashSet<>();
//         for(int i = 0; i<arr.length; i++){
//             set.add(arr[i]);
//         }
//         System.out.println(set);
//     }
// }

// import java.util.*;

// public class Main{
//     public static void main(String[] args) {
//         int[] arr = {2,7,1,15,8};
//         int target = 9;

//         for(int i = 0; i< arr.length; i++){
//             for(int j = i+1; j<arr.length; j++){
//                 if((arr[i]+arr[j]) == target){
//                     System.out.println(arr[i] +" "+arr[j]);
//                 }
//             }
//         }
//     }
// }

// import java.util.HashMap;
// import java.util.Map;

// public class Main {
//     public static void main(String[] args) {
//         int[] arr = { 2, 7, 1, 15, 8 };
//         int target = 9;

//         Map<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < arr.length; i++) {
//             int needed = target - arr[i];
//             if (map.containsKey(needed)) {
//                 System.out.println(needed + " " + arr[i]);
//             }
//             map.put(arr[i], i);
//         }
//     }
// }
import java.util.*;

public class Main{
    public static void main(String[] args) {
        String s = "aabbcddee";
        Map<String,Integer> map = new LinkedHashMap<>();
        for(int i = 0 ; i<s.length(); i++){
            String ch = String.valueOf(s.charAt(i));
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }
        System.out.println(map);
     for(int i = 0 ; i<s.length(); i++){
        String newch = String.valueOf(s.charAt(i));
        if(map.get(newch) == 1){
            System.out.println(newch);
            break;
        }
     }
    }
}