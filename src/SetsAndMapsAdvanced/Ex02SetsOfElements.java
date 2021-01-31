package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<Integer> firsSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            firsSet.add(scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            secondSet.add(scanner.nextInt());
        }
        firsSet.forEach(e->{
            if(secondSet.contains(e)){
                System.out.print(e + " ");
            }
        });
    }
}
