import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        for (Integer n : evenNumbers) {
            System.out.println(n);
        }
        int totalSum = evenNumbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(totalSum);

        List<String> players = Arrays.asList("messi", "ronaldo", "Neymar");

        players.stream().filter(p -> p.length() > 5).map(String::toLowerCase).forEach(System.out::println);
        ;
    }
}