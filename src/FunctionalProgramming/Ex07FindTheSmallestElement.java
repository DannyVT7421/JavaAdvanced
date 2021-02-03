package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> getLastIndexOfMinElement = list ->
                list.lastIndexOf(list.stream().min(Integer::compare).get());
        System.out.println(getLastIndexOfMinElement.apply(nums));
    }
}
