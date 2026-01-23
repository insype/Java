// public class Main{
//     public static void main(String[] args){
//         int number = 12345;
//         int count = 0;
//             while(number > 0){
//               number = number/10;
//               count ++;
//             }
//         System.out.println(count);
//        }
// }
//public class Main {
//     public static void main(String[] args) {
//         int number = 121;
//         int n = number;
//         int rev = 0;

//         while (n > 0) {
//             int r = n % 10;
//             rev = rev * 10 + r;
//             n= n / 10;
//         }

//         if(number == rev){
//             System.out.println("palindrom");
//         }
//         else {
//             System.out.println("not plalindrom");
//         }
//     }
// }

// 

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 3 };

        for (int i = 0; i < arr.length; i++) {
            boolean alreadyCounted = false;
            // checking if the number is already counted or not

            for (int k = 0; k < i; k++) {
                if (arr[k] == arr[i]) {
                    alreadyCounted = true;
                }
            }

            if (alreadyCounted) {
                continue;
            }

            //count the freqnecy
            int count = 1;
            for(int j = i+1; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }

            System.out.println(arr[i]+" ->"+count);
        }
    }
}