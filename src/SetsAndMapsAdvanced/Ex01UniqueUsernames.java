package SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueNames = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            uniqueNames.add(name);
        }
        uniqueNames.forEach(System.out::println);
    }
}
