package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(nums);
        Predicate<Integer> predicate = e -> e % n != 0;
        nums.stream().filter(predicate::test).forEach(e -> System.out.print(e + " "));
    }
}
