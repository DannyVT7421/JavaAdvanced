package Generics.Ex07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();
        String command;
        while (!(command = scanner.nextLine()).equals("END")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Add":
                    String element = tokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = tokens[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int first = Integer.parseInt(tokens[1]);
                    int second = Integer.parseInt(tokens[2]);
                    customList.swap(first,second);
                    break;
                case "Greater":
                    element = tokens[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    String max = customList.getMax();
                    System.out.println(max);
                    break;
                case "Min":
                    String min = customList.getMin();
                    System.out.println(min);
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
            }
        }
    }
}
