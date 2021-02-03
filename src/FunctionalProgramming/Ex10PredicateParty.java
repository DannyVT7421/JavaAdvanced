package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex10PredicateParty {
    static List<String> names = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String line = "";
        while (!line.equals("Party!")) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Double":
                    adOneMore(getPredicate(tokens));
                    break;
                case "Remove":
                    removeName(getPredicate(tokens));
                    break;
            }
            line = scanner.nextLine();
        }
        if(names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            Collections.sort(names);
            System.out.println(names.toString().replaceAll("\\[|\\]", "") + " are going to the party!");
        }
    }

    public static void  removeName(Predicate<String> predicate){
        names.removeIf(predicate);
    }

    public static void adOneMore(Predicate<String> predicate){
        List<String> namesToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(namesToAdd::add);
        names.addAll(namesToAdd);
    }

    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;
        if(tokens[1].equals("StartsWith")){
            predicate = name -> name.startsWith(tokens[2]);
        }else if(tokens[1].equals("EndsWith")){
            predicate = name -> name.endsWith(tokens[2]);
        }else{
            predicate = name -> name.length() ==  Integer.parseInt(tokens[2]);
        }
        return predicate;
    }
}
