package Generics.Ex06GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            Double value = Double.valueOf(scanner.nextLine());
            box.addValue(value);
        }
        Double toCompare = Double.valueOf(scanner.nextLine());
        System.out.println(box.countGraterElements(toCompare));
    }
}
