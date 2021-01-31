package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> allResources = new LinkedHashMap<>();
        String line;
        String resource = "";
        int counter = 0;
        int quantity = 0;
        while (!(line = scanner.nextLine()).equals("stop")) {
            counter++;
            if (counter % 2 != 0) {
                resource = line;
            } else {
                quantity = Integer.parseInt(line);
                if (allResources.get(resource) == null) {
                    allResources.put(resource, quantity);
                } else {
                    int currentQuantity = allResources.get(resource);
                    allResources.put(resource, currentQuantity + quantity);
                }
            }
        }
        allResources.entrySet()
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
