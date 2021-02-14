package Generics.Ex02GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            Box<Integer> box = new Box<>(input);
            System.out.println(box);
        }
    }
}
