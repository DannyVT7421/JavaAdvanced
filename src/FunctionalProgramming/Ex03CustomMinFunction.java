package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Ex03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<int[], Integer> getMinElement = nums -> Arrays.stream(nums).min().getAsInt();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int minElement = getMinElement.apply(numbers);
        System.out.println(minElement);
    }
}
