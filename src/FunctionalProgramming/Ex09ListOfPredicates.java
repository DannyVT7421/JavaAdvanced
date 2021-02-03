package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Integer> numsSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> isDivisible = num -> {
            for (Integer divider : numsSet) {
                if (num % divider != 0) {
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <= n; i++) {
            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
