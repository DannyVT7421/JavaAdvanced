package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ex04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Function<int[], int[]> addOne = arr -> Arrays.stream(arr).map(num -> num += 1).toArray();
        Function<int[], int[]> multiplyByTwo = arr -> Arrays.stream(arr).map(num -> num *= 2).toArray();
        Function<int[], int[]> subtractOne = arr -> Arrays.stream(arr).map(num -> num -= 1).toArray();
        Consumer<int[]> printConsumer = arr -> Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
        String command = "";
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    nums = addOne.apply(nums);
                    break;
                case "multiply":
                    nums = multiplyByTwo.apply(nums);
                    break;
                case "subtract":
                    nums = subtractOne.apply(nums);
                    break;
                case "print":
                    printConsumer.accept(nums);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }

    }

}
