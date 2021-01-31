package SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<Character, Integer> charOccurrences = new TreeMap<>();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (!charOccurrences.containsKey(symbol)) {
                charOccurrences.put(symbol, 1);
            } else {
                charOccurrences.put(symbol, charOccurrences.get(symbol) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
