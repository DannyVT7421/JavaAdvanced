package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> compounds = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String s : line) {
                compounds.add(s);
            }
        }
        compounds.forEach(e -> System.out.print(e + " "));
    }
}
