package Generics.Ex03GenericSwapMethodStrings;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            box.addValue(value);
        }
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int first = indexes[0];
        int second = indexes[1];
        box.swap(first,second);
        System.out.println(box);
    }
}
